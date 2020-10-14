package com.gvdroidframework.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApplication.class)
public class RedisTest {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Test
    public void simple() {
        redisTemplate.opsForValue().set("1","1", Duration.ofSeconds(10));
        String s = redisTemplate.opsForValue().get("1");
        System.out.println(s);
    }
}
