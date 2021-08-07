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
package com.gvdroidframework.logging.core;

import com.alibaba.fastjson.JSON;
import com.gvdroidframework.logging.component.BusinessLoggingDTO;
import com.gvdroidframework.logging.configuration.LoggingProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * 日志模板实现方法
 *
 * @param <T> T must extends from BusinessLoggingDTO
 * @author Colin
 * @since 3.0.0
 */
@Slf4j
public class LoggingTemplateImpl<T extends BusinessLoggingDTO> implements LoggingTemplate<T>, InitializingBean {

    private AmqpTemplate rabbit;
    private LoggingProperties properties;

    public void setLoggingProperties(LoggingProperties loggingProperties, AmqpTemplate rabbit) {
        this.properties = loggingProperties;
        this.rabbit = rabbit;
    }

    /**
     * 通过消息队列将日志进行保存
     */
    @SuppressWarnings("unchecked")
    @Async
    public void save(T t, String className) {
        T cloneT;
        try {
            cloneT = (T) t.clone();
            if (StringUtils.isEmpty(className))
                return;

            LoggingCategoryEnum loggingCategoryEnum = LoggingCategoryEnum.getByString(className);
            if (loggingCategoryEnum == null)
                return;
            doFilter(cloneT, loggingCategoryEnum);
        } catch (Exception e) {
            log.error(e.getMessage());
//            e.printStackTrace();
        }
    }

    /**
     * 根据配置文件，判断是否存入日志，以及是否存RequestDTO和ResponseDTO
     *
     * @param t                   extends BusinessLoggingDTO
     * @param loggingCategoryEnum LoggingCategoryEnum
     */
    private void doFilter(T t, LoggingCategoryEnum loggingCategoryEnum) {

        // 判读请求类型是属于配置文件中配置的类型，如果不满足配置文件中的条件则直接退出
        if (!LoggingCategoryEnum.isInclude(loggingCategoryEnum, properties.getCategory())) {
            return;
        }

        // 当满足上面条件时
        // 判断运行所属环境是否是开发环境，开发环境的时候直接保存所有日志
        if (LoggingEnvironmentEnum.dev.toString().equals(properties.getEnv())) {
            saveAll(t);
            return;
        }

        // 当满足前置条件
        // 判断运行所属环境是否是生产环境，生产环境并且请求类型为查询的时候不保存请求和相应对象，非请求类型保存请求和响应对象。
        if (LoggingEnvironmentEnum.prod.toString().equals(properties.getEnv()) &&
                loggingCategoryEnum.getCode().intValue() == LoggingCategoryEnum.inquiry.getCode().intValue()) {
            saveWithoutDTO(t);
        } else {
            saveAll(t);
        }
    }

    /**
     * 保存整个日志对象
     *
     * @param t T
     */
    private void saveAll(T t) {
        invokeRabbit(t);
    }

    /**
     * 不保存RequestDTO和ResponseDTO
     *
     * @param t T
     */
    private void saveWithoutDTO(T t) {
        t.setRequestDTO(null);
        t.setResponseDTO(null);
        invokeRabbit(t);
    }

    /**
     * 调用RabbitTemplate将日志以JSON字符串形式发送至RabbitMQ
     *
     * @param t T
     */
    private void invokeRabbit(T t) {

        String msg = JSON.toJSONString(t);


        rabbit.convertAndSend(properties.getMq().getExchange(), properties.getMq().getRouting(), msg);
//        asyncRabbit.convertSendAndReceive(properties.getMq().getExchange(),
//                properties.getMq().getRouting(),
//                msg);

    }

    @Override
    public void afterPropertiesSet() {
        Assert.notNull(this.properties, "Logging properties cannot be null");
    }
}
