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
package com.gvdroidframework.cloud.autoconfigure;

import feign.Logger;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign Client的全局日志配置
 *
 * @author Colin
 */
@Configuration
@ConditionalOnClass(value = {Logger.class})
@AutoConfigureAfter(FeignAutoConfiguration.class)
public class OpenFeignCustomAutoConfiguration {

    /**
     * 初始化FeignLoggerLevel Bean
     *
     * @return Feign Logger
     */
    @Bean
    Logger.Level feignLoggerLevel() {

        //这里记录所有，根据实际情况选择合适的日志level
        return Logger.Level.FULL;
    }
}
