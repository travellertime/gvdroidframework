//package com.gvdroidframework.boot.security;
//
//import com.auth0.jwt.interfaces.Claim;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.gvdroidframework.boot.util.JWTUtils;
//
//import java.util.*;
//
//import static com.gvdroidframework.boot.util.JWTUtils.genToken;
//import static com.gvdroidframework.boot.util.JWTUtils.getMap;
//
//public class JWTTest {
//
//        public static void main(String[] args) {
//         String token = genToken("linshaobin", "2000", 60);
//         System.out.println(token);
//
////        String enToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MzM1NTIwNTAsInVzZXJJZCI6ImxpbnNoYW9iaW4iLCJpYXQiOjE1MzM1NTE5OTB9.Jo9n9vSR9iO1UwIVE7O-uaCN8kta7b_-57toKkmBZ4s";
////        String userId = getUserId(enToken, "1000");
////        System.out.println(userId);
//
//     String enToken =
//     "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MzIzMjAxOTcsInVzZXJJZCI6IjEwMDAwMDAwIiwiaWF0IjoxNTMyMzIwMTM3fQ.dkWW_DdpehdWBPUNYknKBMln4oAJQJ1hVg0qkMK2A90";
//     DecodedJWT jwt = JWTUtils.decodeToken(enToken);
//
//     String userId = jwt.getClaim("userId").asString();
//     String alg = jwt.getAlgorithm();
//     String sign = jwt.getSignature();
//     String s = jwt.getExpiresAt().toString();
//
//     Map<String, Claim> claims = verifyToken(enToken);
//     Claim userId = claims.get("userId");
//     System.out.println(userId);
//     System.out.println(alg);
//     System.out.println(sign);
//     System.out.println(s);
//
//        testMapToken();
//    }
//
//    private static void testMapToken() {
////        String token = genToken(map, "11111", 10);
//
//        List<Integer> list = new ArrayList<>();
//        for (int i = 1; i < 1001; i++) {
//            list.add(i);
//        }
//
//        List<String[]> list2 = Collections.synchronizedList(new ArrayList());
//        list.forEach(x -> {
//            Map<String, String> map = new HashMap<>();
//            map.put("user", "colin");
//            map.put("channel", "channel");
//            map.put("entity", x.toString());
//            String tok = genToken(map, x.toString(), 10);
//            map.clear();
//            String[] strs = new String[2];
//            strs[0] = x.toString();
//            strs[1] = tok;
//            list2.add(strs);
//        });
//
//        System.out.println(list2.stream().distinct().count());
//
//        String[] s = list2.stream().findFirst().get();
//
//        list2.stream().forEach(x ->{
//            Map<String, String> m = getMap(x[1], x[0], "user", "channel", "entity", "2");
//            System.out.println(m);
//        });
//    }
//}
