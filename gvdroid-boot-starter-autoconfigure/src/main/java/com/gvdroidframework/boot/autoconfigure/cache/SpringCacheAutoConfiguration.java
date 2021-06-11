package com.gvdroidframework.boot.autoconfigure.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;

@Configuration
@ConditionalOnClass(value = {RedisOperations.class})
@AutoConfigureAfter(RedisAutoConfiguration.class)
@EnableCaching
@Slf4j
public class SpringCacheAutoConfiguration {

    /**
     * 申明缓存管理器，会创建一个切面（aspect）并触发Spring缓存注解的切点（pointcut）
     * 根据类或者方法所使用的注解以及缓存的状态，这个切面会从缓存中获取数据，将数据添加到缓存之中或者从缓存中移除某个值
     *
     * @param redisConnectionFactory redisConnectionFactory
     * @return RedisCacheManager
     */
    @Bean
    public RedisCacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory) {
        log.info("redisCacheManager created.");
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration
                .defaultCacheConfig()
                .computePrefixWith(name -> name + ":");

        return RedisCacheManager.
                builder(redisConnectionFactory).
                cacheDefaults(redisCacheConfiguration).
                build();
    }
}
