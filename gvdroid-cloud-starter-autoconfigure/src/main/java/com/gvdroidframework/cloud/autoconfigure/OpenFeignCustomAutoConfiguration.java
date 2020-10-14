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
