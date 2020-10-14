package com.gvdroidframework.boot.autoconfigure.base;

import com.gvdroidframework.base.component.Status;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.util.Assert;

/**
 * 应用程序属性初始化配置
 */
@Configuration
@Order(value = -99999)
public class ApplicationAutoConfiguration implements ApplicationContextAware {

    /**
     * 在程序启动的时候将执行状态中的应用程序名称进行设置。
     *
     * @param applicationContext Spring上下文。
     * @throws BeansException 当应用名称没有设置的时候，系统会在启动的时候抛出异常。
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        String applicationName = applicationContext.getEnvironment().getProperty("spring.application.name");
        Status.setDefaultApplicationName(applicationName);
        Assert.notNull(applicationName, "spring.application.name cannot be null");

    }
}
