/*
 * Copyright 2014-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gvdroidframework.helper.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gvdroidframework.base.constant.ErrorCode;
import com.gvdroidframework.base.exception.BaseException;
import com.gvdroidframework.security.component.JWTTokenClaim;
import com.gvdroidframework.security.component.Token;
import com.gvdroidframework.security.component.TokenClaim;
import com.gvdroidframework.security.component.TokenSignKey;
import com.gvdroidframework.security.util.JWTUtils;
import com.gvdroidframework.util.MD5Util;
import com.gvdroidframework.util.StringUtils;
import lombok.SneakyThrows;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.integration.support.locks.LockRegistry;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;

import static com.gvdroidframework.security.component.JWTTokenClaim.KEY_REFRESH_TOKEN_PREFIX;
import static java.util.concurrent.TimeUnit.SECONDS;

public class PassportSecurityTemplateImpl implements PassportSecurityTemplate {

    //    private static final String REDIS_TOKEN_FIELD = "gvdroid-token-";

//    private static final int TOKEN_EXPIRY = 2419200; // 28天

    private static final int TOKEN_EXPIRY_FACTOR = 2;
//    private static final String REFRESH_TOKEN_KEY = "gvdroid:refreshKey:";
    private static final long LOCK_SECONDS = 10;

    //    private String getTokenRedisKey(String tokenId) {
//        // 生成redis key
//        return JWTTokenClaim.KEY_TOKEN_PREFIX + MD5Util.MD5_32bit(tokenId);
//    }
    private final RedisTemplate<String, String> redisTemplate;
    private final LockRegistry lockRegistry;

    public PassportSecurityTemplateImpl(RedisTemplate<String, String> redisTemplate, LockRegistry lockRegistry) {
        this.redisTemplate = redisTemplate;
        this.lockRegistry = lockRegistry;
    }

    /**
     * 根据tokenClaim生成accessToken和refreshToken,
     * accessToken的有效时间为tokenClaim里的expiresIn（秒）
     * refreshToken的有效时间为accessToken有效时间的两倍
     *
     * @param tokenClaim token请求参数
     * @return token
     */
    public Token generateToken(TokenClaim tokenClaim) {
        return this.generateToken(tokenClaim, true);
    }

    public Token generateToken(TokenClaim tokenClaim, boolean generateRefreshToken) {
        Map<String, String> map = new HashMap<>();
        this.tokenClaimConvertMap(map, tokenClaim);

        // 生成accessToken
        String accessToken = JWTUtils.genToken(map, TokenSignKey.TOKEN_ACCESS_SIGN_KEY, tokenClaim.getExpiresIn());

        // 生成refreshToken
        String refreshToken = "";
        if (generateRefreshToken) {
            refreshToken = JWTUtils.genToken(map, TokenSignKey.TOKEN_REFRESH_SIGN_KEY, tokenClaim.getExpiresIn() * TOKEN_EXPIRY_FACTOR);
        }

        return fillToken(accessToken, refreshToken, tokenClaim.getExpiresIn());
    }


    private void tokenClaimConvertMap(Map<String, String> map, TokenClaim tokenClaim) {
        map.put(JWTTokenClaim.KEY_USER, tokenClaim.getUserId());
        map.put(JWTTokenClaim.KEY_CHANNEL, tokenClaim.getChannelId());
        map.put(JWTTokenClaim.KEY_ENTITY, tokenClaim.getEntityId());
        map.put(JWTTokenClaim.KEY_ROLE, tokenClaim.getRoles());
        map.put(JWTTokenClaim.KEY_PRIVILEGE, tokenClaim.getPrivileges());
        map.put(JWTTokenClaim.KEY_EXPIRES_IN, String.valueOf(tokenClaim.getExpiresIn()));
    }

    private TokenClaim fillTokenClaim(DecodedJWT jwt) {
        return TokenClaim.builder()
                .userId(jwt.getClaim(JWTTokenClaim.KEY_USER).asString())
                .channelId(jwt.getClaim(JWTTokenClaim.KEY_CHANNEL).asString())
                .entityId(jwt.getClaim(JWTTokenClaim.KEY_ENTITY).asString())
                .roles(jwt.getClaim(JWTTokenClaim.KEY_ROLE).asString())
                .privileges(jwt.getClaim(JWTTokenClaim.KEY_PRIVILEGE).asString())
                .expiresIn(Integer.parseInt(jwt.getClaim(JWTTokenClaim.KEY_EXPIRES_IN).asString()))
                .build();
    }

    /**
     * 使用refreshToken重新生成accessToken
     * 重新生成的accessToken的有效时间等于上次accessToken的时间
     * 仅当refreshToken在有效时间内才能够重新生成accessToken
     * <p>
     * 当并发调用的时候，会采用分布式锁将线程锁住，只允许一个线程进行处理
     * 获得锁的线程，到redis中获取accessToken，如果存在则直接返回
     * 如果不存在则生成token并写入redis中，锁的最长时间为10s
     *
     * @param refreshToken refreshToken
     * @return Token
     */
    //TODO 需要修改一下，将RefreshToken也重新生成
    @SneakyThrows
    public Token refreshToken(String refreshToken) {
        // 解析refreshToken
        TokenClaim tokenClaim = this.getRefreshTokenClaim(refreshToken);

        String key = MD5Util.MD5_32bit(refreshToken);
        Lock lock = this.lockRegistry.obtain(key);

        try {
            boolean lockAcquired = lock.tryLock(LOCK_SECONDS, SECONDS);
            if (lockAcquired) {

                // 校验Redis是否有Token的JSON对象，如果有则直接返回
                String tokenString = this.redisTemplate.opsForValue().get(KEY_REFRESH_TOKEN_PREFIX + key);
                if (!StringUtils.isEmpty(tokenString)) {
                    return JSONObject.parseObject(tokenString, Token.class);
                }

                // 生成token
                Token token = generateToken(tokenClaim, false);
                token.setRefreshToken(refreshToken);

                // 写入Redis，过期时间设置为10秒
                this.redisTemplate.opsForValue().set(KEY_REFRESH_TOKEN_PREFIX + key, JSON.toJSONString(token), Duration.ofSeconds(LOCK_SECONDS));

                // 返回
                return token;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    private TokenClaim getRefreshTokenClaim(String refreshToken) {
        try {
            DecodedJWT jwt = JWTUtils.decodeToken(refreshToken, TokenSignKey.TOKEN_REFRESH_SIGN_KEY);
            return fillTokenClaim(jwt);
        } catch (TokenExpiredException expiredException) {
            throw new BaseException("Refresh token has expired", "101", ErrorCode.INVALID_REFRESH_TOKEN, System.currentTimeMillis());
        } catch (JWTVerificationException sve) {
            throw new BaseException("Invalid refresh token", "101", ErrorCode.INVALID_REFRESH_TOKEN, System.currentTimeMillis());
        }

    }


    /**
     * 解析已经生成好的AccessToken
     *
     * @param accessToken accessToken
     * @return 解析后的Token对象
     */
    @Override
    public TokenClaim getTokenClaim(String accessToken) {
        try {
            DecodedJWT jwt = JWTUtils.decodeToken(accessToken, TokenSignKey.TOKEN_ACCESS_SIGN_KEY);
            return fillTokenClaim(jwt);
        } catch (TokenExpiredException expiredException) {
            throw new BaseException("Access token has expired", "101", ErrorCode.INVALID_ACCESS_TOKEN, System.currentTimeMillis());
        } catch (JWTVerificationException e) {
            throw new BaseException("Invalid access token", "101", ErrorCode.INVALID_ACCESS_TOKEN, System.currentTimeMillis());
        }
    }

    private Token fillToken(String accessToken, String refreshToken, long expiresIn) {
        Token token = new Token();
        token.setAccessToken(accessToken);
        token.setRefreshToken(refreshToken);
        token.setExpiresIn(expiresIn);
        return token;
    }
}
