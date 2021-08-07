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

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitOperations;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * 业务日志使用RabbitMQ进行传输时，自动初始化MQ
 *
 * @author XIEZHONG
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(RabbitOperations.class)
@ConditionalOnProperty(prefix = "gvdroid.business.logging", name = "enabled", havingValue = "true")
@AutoConfigureAfter(RabbitAutoConfiguration.class)
@RequiredArgsConstructor
public class LoggingRabbitAutoConfiguration {

//    final LoggingProperties properties;

//    @Bean
//    Queue businessLogQueue() {
//        return new Queue(properties.getMq().getName(), properties.getMq().isQueueDurable());
//    }
//
//    @Bean
//    TopicExchange businessLogExchange() {
//        return new TopicExchange(properties.getMq().getExchange(), properties.getMq().isExchangeDurable(), properties.getMq().isExchangeAutoDelete());
//    }
//
//    @Bean
//    Binding businessLogBinding(Queue businessLogQueue, TopicExchange businessLogExchange) {
//        return BindingBuilder.bind(businessLogQueue).to(businessLogExchange).with(properties.getMq().getRouting());
//    }

}
