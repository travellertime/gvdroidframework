package com.gvdroidframework.mybatis.configuration;


import com.gvdroidframework.mybatis.plugins.PaginationInterceptor;
import com.gvdroidframework.mybatis.plugins.RepositoryInterceptor;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(MybatisProperties.class)
@AutoConfigureAfter({DataSourceAutoConfiguration.class, MybatisAutoConfiguration.class})
@Import(value = {PaginationInterceptor.class, RepositoryInterceptor.class})
public class MysqlPluginAutoConfiguration {
}
