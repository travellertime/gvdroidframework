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
