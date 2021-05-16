package com.gvdroidframework.helper.core;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.gvdroidframework.security.component.JWTTokenClaim;
import com.gvdroidframework.security.component.TokenClaim;
import com.gvdroidframework.security.util.JWTUtils;
import com.gvdroidframework.util.MD5Util;
import com.gvdroidframework.util.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class PassportSecurityTemplateImpl implements PassportSecurityTemplate {

    //    private static final String REDIS_TOKEN_FIELD = "gvdroid-token-";
    private static final int TOKEN_EXPIRY = 2419200; // 28天

    private final RedisTemplate<String, String> redisTemplate;

    public PassportSecurityTemplateImpl(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private String getTokenRedisKey(String tokenId) {
        // 生成redis key
        return JWTTokenClaim.KEY_TOKEN_PREFIX + MD5Util.MD5_32bit(tokenId);
    }

    @Override
    public String getTokenSecretKey(String tokenId) {
        String key = getTokenRedisKey(tokenId);
        return this.redisTemplate.opsForValue().get(key);
    }

    /**
     * 将生成的token写入redis
     *
     * @param tokenId  tokenId
     * @param saltCode saltCode
     */
    private void setRedis(String tokenId, String saltCode) {
        // 得到redis key
        String key = getTokenRedisKey(tokenId);
        // 异步写入redis
        redisTemplate.opsForValue().set(key, saltCode, Duration.ofSeconds(TOKEN_EXPIRY));
    }

    /**
     * 将生成的token写入redis
     *
     * @param tokenId      tokenId
     * @param saltCode     saltCode
     * @param expirySecond expirySecond
     */
    private void setRedis(String tokenId, String saltCode, int expirySecond) {
        // 得到redis key
        String key = getTokenRedisKey(tokenId);
        // 异步写入redis
        redisTemplate.opsForValue().set(key, saltCode, Duration.ofSeconds(expirySecond));
    }

    /**
     * 将生成的token从redis删除
     *
     * @param tokenId tokenId
     */
    @Override
    public void remove(String tokenId) {
        // 得到redis key
        String key = getTokenRedisKey(tokenId);

        // 异步删除redis
        redisTemplate.delete(key);
    }

    /**
     * 生成token
     *
     * @param customerId customerId
     * @param entityCode entityCode
     * @param channelId  channelId
     * @param saltCode   saltCode
     * @return tokenId
     */
    @Override
    public String generateTokenId(String customerId, String entityCode, String channelId, String saltCode) {

        Map<String, String> map = this.getTokenMap(customerId, entityCode, channelId);

        String complexToken = JWTUtils.genToken(map, saltCode);

        setRedis(complexToken, saltCode);

        return complexToken;
    }

    /**
     * 生成token
     *
     * @param customerId customerId
     * @param entityCode entityCode
     * @param channelId  channelId
     * @param saltCode   saltCode
     * @return tokenId
     */
    @Override
    public String generateTokenId(String customerId, String entityCode, String channelId, String saltCode, int expirySeconds) {

        Map<String, String> map = this.getTokenMap(customerId, entityCode, channelId);

        String complexToken = JWTUtils.genToken(map, saltCode, expirySeconds);

        setRedis(complexToken, saltCode, expirySeconds);

        return complexToken;
    }

    @Override
    public TokenObject generateToken(String customerId, String entityCode, String channelId, String saltCode, int expirySeconds) {
        Map<String, String> map = this.getTokenMap(customerId, entityCode, channelId);

        String complexToken = JWTUtils.genToken(map, saltCode, expirySeconds);

        setRedis(complexToken, saltCode, expirySeconds);

        DecodedJWT decodedJWT = JWTUtils.getDecodedJWT(complexToken, saltCode);

        return fillToken(complexToken, decodedJWT);
    }

    public TokenObject generateToken(TokenClaim tokenClaim, String secretKey, int expirySeconds) {
        Map<String, String> map = new HashMap<>();
        map.put(JWTTokenClaim.KEY_USER, tokenClaim.getUserId());
        map.put(JWTTokenClaim.KEY_CHANNEL, tokenClaim.getChannelId());
        map.put(JWTTokenClaim.KEY_ENTITY, tokenClaim.getEntityId());
        map.put(JWTTokenClaim.KEY_ROLE, tokenClaim.getRoles());
        map.put(JWTTokenClaim.KEY_PRIVILEGE, tokenClaim.getPrivileges());

        String complexToken = JWTUtils.genToken(map, secretKey, expirySeconds);

        setRedis(complexToken, secretKey, expirySeconds);

        DecodedJWT decodedJWT = JWTUtils.getDecodedJWT(complexToken, secretKey);

        return fillToken(complexToken, decodedJWT);
    }

    private Map<String, String> getTokenMap(String customerId, String entityCode, String channelId) {
        Map<String, String> map = new HashMap<>();
        map.put(JWTTokenClaim.KEY_USER, customerId);
        map.put(JWTTokenClaim.KEY_CHANNEL, channelId);
        map.put(JWTTokenClaim.KEY_ENTITY, entityCode);
        return map;
    }

    @Override
    public TokenObject refreshToken(String tokenId, String saltCode, int expireSeconds) {

        // 解码传入的token，失败则抛出异常
        Map<String, String> tokenMap = JWTUtils.getMap(tokenId, saltCode, JWTTokenClaim.KEY_USER, JWTTokenClaim.KEY_ENTITY, JWTTokenClaim.KEY_CHANNEL);

        // 生成新的token
        String complexToken = JWTUtils.genToken(tokenMap, saltCode, expireSeconds);

        // 写入Redis缓存
        this.setRedis(complexToken, saltCode, expireSeconds);

        // 删除旧的Token
        this.remove(tokenId);

        DecodedJWT decodedJWT = JWTUtils.getDecodedJWT(complexToken, saltCode);

        return fillToken(complexToken, decodedJWT);
    }

    private TokenObject fillToken(String complexToken, DecodedJWT decodedJWT) {
        TokenObject tokenObject = new TokenObject();
        tokenObject.setToken(complexToken);
        tokenObject.setIssueAt(decodedJWT.getIssuedAt().getTime());
        tokenObject.setExpiresAt(decodedJWT.getExpiresAt().getTime());
        return tokenObject;
    }
}
