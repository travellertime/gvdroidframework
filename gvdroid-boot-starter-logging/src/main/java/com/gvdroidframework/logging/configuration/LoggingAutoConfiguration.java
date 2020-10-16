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
