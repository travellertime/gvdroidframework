package com.gvdroid.simple.helper;

import com.gvdroidframework.helper.core.PassportSecurityTemplate;
import com.gvdroidframework.security.component.JWTTokenClaim;
import com.gvdroidframework.security.util.JWTUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SimpleHelperApplication.class})
public class PassportSecuritySimpleTest {

    @Autowired
    PassportSecurityTemplate passportSecurityTemplate;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Test
    public void tokenTest() {
        String customerId = "colin";
        String entityId = "gvdroid";
        String channel = "web";
        String salt = "salt";

        String token = this.passportSecurityTemplate.generateTokenId(customerId, entityId, channel, salt);
        System.out.println(token);


        String secretKey = this.passportSecurityTemplate.getTokenSecretKey(token);
        Map<String, String> map = JWTUtils.getMap(token, secretKey, JWTTokenClaim.KEY_USER, JWTTokenClaim.KEY_ENTITY, JWTTokenClaim.KEY_CHANNEL);
        System.out.println(map.get(JWTTokenClaim.KEY_USER));
        System.out.println(map.get(JWTTokenClaim.KEY_ENTITY));
        System.out.println(map.get(JWTTokenClaim.KEY_CHANNEL));
    }
}
