package com.gvdroidframework.security.util;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gvdroidframework.base.constant.ErrorCode;
import com.gvdroidframework.base.exception.BaseException;
import com.gvdroidframework.security.component.JWTTokenClaim;
import com.gvdroidframework.security.component.Token;
import com.gvdroidframework.security.component.TokenClaim;
import com.gvdroidframework.security.component.TokenSignKey;

import java.util.HashMap;
import java.util.Map;

@Deprecated
public class TokenUtils {

//    private static final int TOKEN_EXPIRY_FACTOR = 2;
//
//    /**
//     * 根据tokenClaim生成accessToken和refreshToken,
//     * accessToken的有效时间为tokenClaim里的expiresIn（秒）
//     * refreshToken的有效时间为accessToken有效时间的两倍
//     *
//     * @param tokenClaim token请求参数
//     * @return token
//     */
//    public static Token generateToken(TokenClaim tokenClaim) {
//        return generateToken(tokenClaim, true);
//    }
//
//    public static Token generateToken(TokenClaim tokenClaim, boolean generateRefreshToken) {
//        Map<String, String> map = new HashMap<>();
//        tokenClaimConvertMap(map, tokenClaim);
//
//        // 生成accessToken
//        String accessToken = JWTUtils.genToken(map, TokenSignKey.TOKEN_ACCESS_SIGN_KEY, tokenClaim.getExpiresIn());
//
//        // 生成refreshToken
//        String refreshToken = "";
//        if (generateRefreshToken) {
//            refreshToken = JWTUtils.genToken(map, TokenSignKey.TOKEN_REFRESH_SIGN_KEY, tokenClaim.getExpiresIn() * TOKEN_EXPIRY_FACTOR);
//        }
//
//        return fillToken(accessToken, refreshToken, tokenClaim.getExpiresIn());
//    }
//
//    private static void tokenClaimConvertMap(Map<String, String> map, TokenClaim tokenClaim) {
//        map.put(JWTTokenClaim.KEY_USER, tokenClaim.getUserId());
//        map.put(JWTTokenClaim.KEY_CHANNEL, tokenClaim.getChannelId());
//        map.put(JWTTokenClaim.KEY_ENTITY, tokenClaim.getEntityId());
//        map.put(JWTTokenClaim.KEY_ROLE, tokenClaim.getRoles());
//        map.put(JWTTokenClaim.KEY_PRIVILEGE, tokenClaim.getPrivileges());
//        map.put(JWTTokenClaim.KEY_EXPIRES_IN, String.valueOf(tokenClaim.getExpiresIn()));
//    }
//
//    public static TokenClaim getTokenClaim(String accessToken) {
//        try {
//            DecodedJWT jwt = JWTUtils.decodeToken(accessToken, TokenSignKey.TOKEN_ACCESS_SIGN_KEY);
//            return fillTokenClaim(jwt);
//        } catch (TokenExpiredException expiredException) {
//            throw new BaseException("Access token has expired", "101", ErrorCode.INVALID_ACCESS_TOKEN, System.currentTimeMillis());
//        } catch (JWTVerificationException e) {
//            throw new BaseException("Invalid access token", "101", ErrorCode.INVALID_ACCESS_TOKEN, System.currentTimeMillis());
//        }
//    }
//
//    public static void checkToken(String accessToken) {
//        try {
//            JWTUtils.decodeToken(accessToken, TokenSignKey.TOKEN_ACCESS_SIGN_KEY);
//        } catch (TokenExpiredException expiredException) {
//            throw new BaseException("Access token has expired", "101", ErrorCode.INVALID_ACCESS_TOKEN, System.currentTimeMillis());
//        } catch (JWTVerificationException e) {
//            throw new BaseException("Invalid access token", "101", ErrorCode.INVALID_ACCESS_TOKEN, System.currentTimeMillis());
//        }
//    }
//
//    public static TokenClaim fillTokenClaim(DecodedJWT jwt) {
//        return TokenClaim.builder()
//                .userId(jwt.getClaim(JWTTokenClaim.KEY_USER).asString())
//                .channelId(jwt.getClaim(JWTTokenClaim.KEY_CHANNEL).asString())
//                .entityId(jwt.getClaim(JWTTokenClaim.KEY_ENTITY).asString())
//                .roles(jwt.getClaim(JWTTokenClaim.KEY_ROLE).asString())
//                .privileges(jwt.getClaim(JWTTokenClaim.KEY_PRIVILEGE).asString())
//                .expiresIn(Integer.parseInt(jwt.getClaim(JWTTokenClaim.KEY_EXPIRES_IN).asString()))
//                .build();
//    }
//
//    public static Token fillToken(String accessToken, String refreshToken, long expiresIn) {
//        Token token = new Token();
//        token.setAccessToken(accessToken);
//        token.setRefreshToken(refreshToken);
//        token.setExpiresIn(expiresIn);
//        return token;
//    }
}
