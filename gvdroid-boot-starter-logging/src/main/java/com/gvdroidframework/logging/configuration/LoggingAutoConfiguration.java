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
package com.gvdroidframework.logging.configuration;

import com.gvdroidframework.logging.component.BusinessLoggingDTO;
import com.gvdroidframework.logging.core.LoggingTemplate;
import com.gvdroidframework.logging.core.LoggingTemplateImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitOperations;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 业务日志模板工具自动装配
 *
 * @author XIEZHONG
 */
@Configuration
@ConditionalOnClass(RabbitOperations.class)
@EnableConfigurationProperties(LoggingProperties.class)
@AutoConfigureAfter(LoggingRabbitAutoConfiguration.class)
@RequiredArgsConstructor
public class LoggingAutoConfiguration {

    final LoggingProperties loggingProperties;
    final AmqpTemplate amqpTemplate;


    @Bean
    @Primary
    @ConditionalOnMissingBean
    public LoggingTemplate<BusinessLoggingDTO> loggingTemplate() {
        LoggingTemplateImpl<BusinessLoggingDTO> template = new LoggingTemplateImpl<>();
        template.setLoggingProperties(loggingProperties, amqpTemplate);
        return template;
    }
}
