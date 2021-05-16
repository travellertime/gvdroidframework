package com.gvdroidframework.helper.core;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gvdroidframework.base.exception.BaseException;
import com.gvdroidframework.helper.constant.TokenSignKeyConstant;
import com.gvdroidframework.security.component.JWTTokenClaim;
import com.gvdroidframework.security.component.TokenClaimRequest;
import com.gvdroidframework.security.component.TokenClaimResponse;
import com.gvdroidframework.security.util.JWTUtils;
import com.gvdroidframework.util.MD5Util;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class PassportSecurityTemplateImpl implements PassportSecurityTemplate {

    //    private static final String REDIS_TOKEN_FIELD = "gvdroid-token-";

    private static final boolean reuseRefreshToken = true;

    private static final int TOKEN_EXPIRY = 2419200; // 28天

    private static final int TOKEN_EXPIRY_FACTOR = 2;

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
    public void removeToken(String tokenId) {
        // 得到redis key
        String key = getTokenRedisKey(tokenId);

        // 异步删除redis
        redisTemplate.delete(key);
    }

//    /**
//     * 生成token
//     *
//     * @param customerId customerId
//     * @param entityCode entityCode
//     * @param channelId  channelId
//     * @param saltCode   saltCode
//     * @return tokenId
//     */
//    @Override
//    public String generateTokenId(String customerId, String entityCode, String channelId, String saltCode) {
//
//        Map<String, String> map = this.getTokenMap(customerId, entityCode, channelId);
//
//        String complexToken = JWTUtils.genToken(map, saltCode);
//
//        setRedis(complexToken, saltCode);
//
//        return complexToken;
//    }
//
//    /**
//     * 生成token
//     *
//     * @param customerId customerId
//     * @param entityCode entityCode
//     * @param channelId  channelId
//     * @param saltCode   saltCode
//     * @return tokenId
//     */
//    @Override
//    public String generateTokenId(String customerId, String entityCode, String channelId, String saltCode, int expirySeconds) {
//
//        Map<String, String> map = this.getTokenMap(customerId, entityCode, channelId);
//
//        String complexToken = JWTUtils.genToken(map, saltCode, expirySeconds);
//
//        setRedis(complexToken, saltCode, expirySeconds);
//
//        return complexToken;
//    }
//
//    @Override
//    public TokenObject generateToken(String customerId, String entityCode, String channelId, String saltCode, int expirySeconds) {
//        Map<String, String> map = this.getTokenMap(customerId, entityCode, channelId);
//
//        String complexToken = JWTUtils.genToken(map, saltCode, expirySeconds);
//
//        setRedis(complexToken, saltCode, expirySeconds);
//
//        DecodedJWT decodedJWT = JWTUtils.getDecodedJWT(complexToken, saltCode);
//
//        return fillToken(complexToken, decodedJWT);
//    }

    public TokenClaimResponse generateToken(TokenClaimRequest tokenClaimRequest) {
        return this.generateToken(tokenClaimRequest, false);
    }

    public TokenClaimResponse generateToken(TokenClaimRequest tokenClaimRequest, boolean reuseRefreshToken) {
        Map<String, String> map = new HashMap<>();
        this.tokenClaimConvertMap(map, tokenClaimRequest);

        // 生成accessToken
        String accessToken = JWTUtils.genToken(map, TokenSignKeyConstant.TOKEN_ACCESS_SIGN_KEY, tokenClaimRequest.getExpiresIn());

        // 生成refreshToken
        String refreshToken = "";
        if (!reuseRefreshToken) {
            refreshToken = JWTUtils.genToken(map, TokenSignKeyConstant.TOKEN_REFRESH_SIGN_KEY, tokenClaimRequest.getExpiresIn() * TOKEN_EXPIRY_FACTOR);
        }
//        // 将accessToken存入Redis
//        setRedis(accessToken, secretKey, tokenClaimRequest.getExpiresIn());

        return fillToken(accessToken, refreshToken, tokenClaimRequest.getExpiresIn());
    }



    private void tokenClaimConvertMap(Map<String, String> map, TokenClaimRequest tokenClaimRequest) {
        map.put(JWTTokenClaim.KEY_USER, tokenClaimRequest.getUserId());
        map.put(JWTTokenClaim.KEY_CHANNEL, tokenClaimRequest.getChannelId());
        map.put(JWTTokenClaim.KEY_ENTITY, tokenClaimRequest.getEntityId());
        map.put(JWTTokenClaim.KEY_ROLE, tokenClaimRequest.getRoles());
        map.put(JWTTokenClaim.KEY_PRIVILEGE, tokenClaimRequest.getPrivileges());
        map.put(JWTTokenClaim.KEY_EXPIRES_IN, String.valueOf(tokenClaimRequest.getExpiresIn()));
    }

    private TokenClaimRequest getTokenClaim(String refreshToken) {
        DecodedJWT jwt = JWTUtils.getDecodedJWT(refreshToken, TokenSignKeyConstant.TOKEN_REFRESH_SIGN_KEY);

        return TokenClaimRequest.builder()
                .userId(jwt.getClaim(JWTTokenClaim.KEY_USER).asString())
                .channelId(jwt.getClaim(JWTTokenClaim.KEY_CHANNEL).asString())
                .entityId(jwt.getClaim(JWTTokenClaim.KEY_ENTITY).asString())
                .roles(jwt.getClaim(JWTTokenClaim.KEY_ROLE).asString())
                .privileges(jwt.getClaim(JWTTokenClaim.KEY_PRIVILEGE).asString())
                .expiresIn(Integer.parseInt(jwt.getClaim(JWTTokenClaim.KEY_EXPIRES_IN).asString()))
                .build();
    }

    @Override
    public TokenClaimResponse refreshToken(String refreshToken) {

        try {
            TokenClaimRequest tokenClaim = this.getTokenClaim(refreshToken);

            TokenClaimResponse tokenClaimResponse = this.generateToken(tokenClaim, true);
            tokenClaimResponse.setRefreshToken(refreshToken);
            return tokenClaimResponse;
        } catch (SignatureVerificationException sve) {
            throw new BaseException("Invalid refresh token", "101");
        }
    }

    private TokenClaimResponse fillToken(String accessToken, String refreshToken, long expiresIn) {
        TokenClaimResponse tokenClaimResponse = new TokenClaimResponse();
        tokenClaimResponse.setAccessToken(accessToken);
        tokenClaimResponse.setRefreshToken(refreshToken);
        tokenClaimResponse.setExpiresIn(expiresIn);
        return tokenClaimResponse;
    }
}
