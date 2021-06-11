package com.gvdroidframework.redis.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.integration.redis.util.RedisLockRegistry;

import java.io.Serializable;

@Configuration
public class GRedisAutoConfiguration implements Serializable {


    @Bean
    RedisLockRegistry redisLockRegistry(RedisConnectionFactory redisConnectionFactory) {
        return new RedisLockRegistry(redisConnectionFactory, "gvdroid:lock:");
    }

    /**
     * @param redisConnectionFactory RedisConnectionFactory
     * @return RedisTemplate
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {

        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(StringRedisSerializer.UTF_8);
        template.afterPropertiesSet();
        return template;
    }


    /**
     * @param redisTemplate RedisTemplate<String, Object>
     * @return HashOperations<String, String, Object>
     */
    @Bean
    public HashOperations<String, Object, Object> hashOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForHash();
    }

    /**
     * 对redis字符串类型数据操作
     *
     * @param redisTemplate RedisTemplate<String, Object> redisTemplate
     * @return ValueOperations<String, Object>
     */
    @Bean
    public ValueOperations<String, Object> valueOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForValue();
    }

    /**
     * 对链表类型的数据操作
     *
     * @param redisTemplate RedisTemplate<String, Object> redisTemplate
     * @return ListOperations<String, Object>
     */
    @Bean
    public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForList();
    }

    /**
     * 对无序集合类型的数据操作
     *
     * @param redisTemplate RedisTemplate<String, Object> redisTemplate
     * @return SetOperations<String, Object>
     */
    @Bean
    public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForSet();
    }

    /**
     * 对有序集合类型的数据操作
     *
     * @param redisTemplate RedisTemplate<String, Object> redisTemplate
     * @return ZSetOperations<String, Object>
     */
    @Bean
    public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForZSet();
    }
}
