package com.gvdroidframework.security.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.gvdroidframework.util.StringUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Java Web Token工具类
 *
 * @author Colin
 * @since 2.0.0
 */
public class JWTUtils {

    /**
     * token default secret key. do not reveal and modify it at will.
     */
    public static final String SECRET_KEY = "GVDr0id.Bo0tcRA2_PR0";

    /**
     * token default expire days: 7 days, 604800 second totally.
     */
    public static final int calendarField = Calendar.SECOND;
    public static final int calendarInterval = 60 * 60 * 24 * 7; // 60s * 60m * 24h * 7day

    /**
     * generate token by JWT.
     * JWT constitute: header, payload, signature.
     *
     * @param map              map
     * @param secretKey        secretKey
     * @param expiresInSeconds expirySecond
     * @return String
     */
    public static String genToken(Map<String, String> map, String secretKey, int expiresInSeconds) {
        // input parameters validation.
        if (null == map || StringUtils.isEmpty(secretKey) || expiresInSeconds == 0)
            return null;

        JWTCreator.Builder builder = getJWTCreator(expiresInSeconds);
        map.forEach(builder::withClaim);

        return builder.sign(Algorithm.HMAC256(secretKey));
    }

    private static JWTCreator.Builder getJWTCreator(int expiresInSeconds) {
        // token issue date. use current date get from system.
        Date issueDate = new Date();

        // token expire date. add by set.
        Calendar expireDate = Calendar.getInstance();
        expireDate.add(calendarField, expiresInSeconds);
        Date expiresDate = expireDate.getTime();

        // header Map
        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("alg", "HS256");
        headerMap.put("typ", "JWT");

        // build token
        return JWT.create() // header
                .withHeader(headerMap) // payload
                .withIssuedAt(issueDate) // payload
                .withExpiresAt(expiresDate);// payload
    }


    /**
     * Generate token by JWT.
     * JWT constitute: header, payload, signature.
     * Token default expire days: 7 days, 604800 second totally.
     *
     * @param map    map
     * @param secret secret
     * @return String
     */
    public static String genToken(Map<String, String> map, String secret) {
        return genToken(map, secret, calendarInterval);
    }

    /**
     * Generate token by JWT.
     * JWT constitute: header, payload, signature.
     *
     * @param map          map
     * @param expirySecond expirySecond
     * @return String
     */
    public static String genToken(Map<String, String> map, int expirySecond) {
        return genToken(map, SECRET_KEY, expirySecond);
    }

    /**
     * Generate token by JWT.
     * JWT constitute: header, payload, signature.
     * Token default expire days: 7 days, 604800 second totally.
     * Generate token by using default secret key.
     *
     * @param map map
     * @return String
     */
    public static String genToken(Map<String, String> map) {
        return genToken(map, SECRET_KEY, calendarInterval);
    }

    /**
     * verify token by default secret key. return decoded token if key is valid.
     *
     * @param token String
     * @return DecodedJWT
     */
    public static DecodedJWT decodeToken(String token) {
        return decodeToken(token, SECRET_KEY);
    }

    /**
     * verify token by provided secret key. return decoded token if key is valid.
     *
     * @param token     String
     * @param secretKey String
     * @return DecodedJWT
     */
    public static DecodedJWT decodeToken(String token, String secretKey) {
        DecodedJWT jwt;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey)).build();
            jwt = verifier.verify(token);
        } catch (JWTVerificationException e) {
//            e.printStackTrace();
            throw e;
        }
        return jwt;
    }


    public static Map<String, String> getMap(String token, String secretKey, String... keys) {
        DecodedJWT jwt = decodeToken(token, secretKey);

        Map<String, String> map = new HashMap<>();
        for (String key : keys) {
            String val = jwt.getClaim(key).asString();
            map.put(key, val);
        }

        return map;
    }

    public static void main(String[] args) {

    }
}
