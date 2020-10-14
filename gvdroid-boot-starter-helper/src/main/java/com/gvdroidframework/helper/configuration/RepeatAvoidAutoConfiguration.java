package com.gvdroidframework.helper.configuration;

import com.gvdroidframework.helper.core.RepeatAvoidTemplate;
import com.gvdroidframework.helper.core.RepeatAvoidTemplateImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Create By Colin.
 * 2019.03.16
 */
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
@RequiredArgsConstructor
public class RepeatAvoidAutoConfiguration {

    final RedisTemplate<String, String> redisTemplate;

    @Bean
    @Primary
    @ConditionalOnMissingBean(name = "repeatAvoidTemplate")
    public RepeatAvoidTemplate repeatAvoidTemplate() {
        return new RepeatAvoidTemplateImpl(redisTemplate);
    }
}
