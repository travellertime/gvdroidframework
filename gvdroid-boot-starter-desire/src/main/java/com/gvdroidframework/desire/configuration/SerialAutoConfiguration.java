package com.gvdroidframework.desire.configuration;

import com.gvdroidframework.mybatis.configuration.MysqlPluginAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.jdbc.lock.DefaultLockRepository;
import org.springframework.integration.jdbc.lock.JdbcLockRegistry;
import org.springframework.integration.jdbc.lock.LockRepository;

import javax.sql.DataSource;

@Configuration
@ConditionalOnClass(value = {MybatisProperties.class})
@AutoConfigureAfter(value = {MysqlPluginAutoConfiguration.class})
@ComponentScan(basePackages = {"com.gvdroidframework.desire"})
@MapperScan(basePackages = "com.gvdroidframework.desire.repository")
public class SerialAutoConfiguration {

    @Bean
    public DefaultLockRepository defaultLockRepository(DataSource dataSource) {
        return new DefaultLockRepository(dataSource);
    }

    @Bean
    public JdbcLockRegistry jdbcLockRegistry(LockRepository lockRepository) {
        return new JdbcLockRegistry(lockRepository);
    }
}
