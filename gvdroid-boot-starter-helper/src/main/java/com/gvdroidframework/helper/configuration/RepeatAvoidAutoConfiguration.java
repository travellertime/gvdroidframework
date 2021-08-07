/*
 * Copyright 2014-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
