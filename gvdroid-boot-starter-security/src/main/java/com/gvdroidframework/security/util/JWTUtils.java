package com.gvdroidframework.security.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.gvdroidframework.security.component.JWTTokenClaim;
import com.gvdroidframework.util.StringUtils;

import java.util.*;

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
     * @param userId       String
     * @param secretKey    String
     * @param expirySecond int
     * @return String
     */
    public static String genToken(String userId, String secretKey, int expirySecond) {

        // input parameters validation.
        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(secretKey) || expirySecond == 0)
            return null;

        JWTCreator.Builder builder = getJWTCreator(expirySecond);
        builder.withClaim(JWTTokenClaim.KEY_USER, userId); // payload
        return builder.sign(Algorithm.HMAC256(secretKey)); // signature
    }

    /**
     * generate token by JWT.
     * JWT constitute: header, payload, signature.
     *
     * @param map          map
     * @param secretKey    secretKey
     * @param expirySecond expirySecond
     * @return String
     */
    public static String genToken(Map<String, String> map, String secretKey, int expirySecond) {
        // input parameters validation.
        if (null == map || StringUtils.isEmpty(secretKey) || expirySecond == 0)
            return null;

        JWTCreator.Builder builder = getJWTCreator(expirySecond);
        map.forEach(builder::withClaim);

        return builder.sign(Algorithm.HMAC256(secretKey));
    }

    private static JWTCreator.Builder getJWTCreator(int expirySecond) {
        // token issue date. use current date get from system.
        Date issueDate = new Date();

        // token expire date. add by set.
        Calendar expireDate = Calendar.getInstance();
        expireDate.add(calendarField, expirySecond);
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
     * @param userId String
     * @param secret String
     * @return String
     */
    public static String genToken(String userId, String secret) {
        return genToken(userId, secret, calendarInterval);
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
        return genToken(map, SECRET_KEY, calendarInterval);
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
     * Generate token by JWT.
     * JWT constitute: header, payload, signature.
     * Generate token by using default secret key.
     *
     * @param userId       String
     * @param expirySecond int
     * @return String
     */
    public static String genToken(String userId, int expirySecond) {
        return genToken(userId, SECRET_KEY, expirySecond);
    }

    /**
     * Generate token by JWT.
     * JWT constitute: header, payload, signature.
     * Token default expire days: 7 days, 604800 second totally.
     * Generate token by using default secret key.
     *
     * @param userId String
     * @return String
     */
    public static String genToken(String userId) {
        return genToken(userId, SECRET_KEY, calendarInterval);
    }

    /**
     * verify token by default secret key. return decoded token if key is valid.
     *
     * @param token String
     * @return DecodedJWT
     */
    private static DecodedJWT decodeToken(String token) {
        return decodeToken(token, SECRET_KEY);
    }

    /**
     * verify token by provided secret key. return decoded token if key is valid.
     *
     * @param token     String
     * @param secretKey String
     * @return DecodedJWT
     */
    private static DecodedJWT decodeToken(String token, String secretKey) {
        DecodedJWT jwt;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey)).build();
            jwt = verifier.verify(token);
        } catch (JWTVerificationException e) {
            e.printStackTrace();
            throw e;
        }
        return jwt;
    }

    /**
     * Get userId from token.
     * Note: this method can only be invoked when token is generated by using default secret key.
     *
     * @param token String
     * @return String
     */
    public static String getUserId(String token) {
        DecodedJWT jwt = decodeToken(token);
        return jwt.getClaim(JWTTokenClaim.KEY_USER).asString();
    }

    /**
     * Get userId from token.
     * Note: this method can only be invoked when token is generated by provided secret key.
     *
     * @param token     String
     * @param secretKey String
     * @return String
     */
    public static String getUserId(String token, String secretKey) {
        DecodedJWT jwt = decodeToken(token, secretKey);
        return jwt.getClaim(JWTTokenClaim.KEY_USER).asString();
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
        String token = genToken("colin", "2000", 600);
        System.out.println(token);

//        String enToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyIjZ3Zkcm9pZC51c2VyIjoiY29saW4iLCJleHAiOjE2MDI0OTczMTEsImlhdCI6MTYwMjQ5NzI1MX0.ue-i_Fd9Z9mqFPxqrFr8e4B8dqnoFHChhvrVs2V-G2Q";
//        String user = getUserId(enToken, "2000");
//        System.out.println(user);

        String enToken =
                "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyIjZ3Zkcm9pZC51c2VyIjoiY29saW4iLCJleHAiOjE2MDI0OTgxMDQsImlhdCI6MTYwMjQ5NzUwNH0.ltGxGqgtZlN_n3Lce41_eHX1-xrmdYdbZBpjiNDhvys";
        DecodedJWT jwt = decodeToken(enToken, "2000");

        String userId = jwt.getClaim(JWTTokenClaim.KEY_USER).asString();
        String alg = jwt.getAlgorithm();
        String sign = jwt.getSignature();
        String s = jwt.getExpiresAt().toString();

//     Map<String, Claim> claims = verifyToken(enToken);
//     Claim userId = claims.get("userId");
        System.out.println(userId);
        System.out.println(alg);
        System.out.println(sign);
        System.out.println(s);

        testMapToken();
    }

    private static void testMapToken() {
//        String token = genToken(map, "11111", 10);

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            list.add(i);
        }

        List<String[]> list2 = Collections.synchronizedList(new ArrayList<>());
        list.forEach(x -> {
            Map<String, String> map = new HashMap<>();
            map.put("user", "colin");
            map.put("channel", "channel");
            map.put("entity", x.toString());
            map.put("2", "2");
            String tok = genToken(map, x.toString(), 10);
            map.clear();
            String[] strs = new String[2];
            strs[0] = x.toString();
            strs[1] = tok;
            list2.add(strs);
        });

        System.out.println(list2.stream().distinct().count());

//        String[] s = list2.stream().findFirst().get();

        list2.stream().forEach(x -> {
            Map<String, String> m = getMap(x[1], x[0], "user", "channel", "entity", "2");
            System.out.println(m);
        });
    }
}
