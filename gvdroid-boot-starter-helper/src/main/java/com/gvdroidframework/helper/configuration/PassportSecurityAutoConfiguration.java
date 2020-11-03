package com.gvdroidframework.helper.configuration;

import com.gvdroidframework.helper.core.PassportSecurityTemplate;
import com.gvdroidframework.helper.core.PassportSecurityTemplateImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
@RequiredArgsConstructor
public class PassportSecurityAutoConfiguration {

    final RedisTemplate<String, String> redisTemplate;

    @Bean
    @Primary
    @ConditionalOnMissingBean(name = "passportSecurityTemplate")
    public PassportSecurityTemplate passportSecurityTemplate() {
        return new PassportSecurityTemplateImpl(redisTemplate);
    }
}
