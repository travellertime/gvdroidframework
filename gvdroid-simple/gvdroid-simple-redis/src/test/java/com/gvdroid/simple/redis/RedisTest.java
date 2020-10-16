package com.gvdroid.simple.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void stringRedisTest() {
        this.stringRedisTemplate.opsForValue().set("1", "1", Duration.ofSeconds(60));

    }

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void redisTest() {
        this.redisTemplate.opsForValue().set("2", "2", Duration.ofSeconds(60));
    }

    @Autowired
    private ValueOperations<String, Object> valueOperations;

    @Autowired
    private HashOperations<String, String, Object> hashOperations;

    @Autowired
    private ListOperations<String, Object> listOperations;

    @Autowired
    private SetOperations<String, Object> setOperations;

    @Autowired
    private ZSetOperations<String, Object> zSetOperations;
}
