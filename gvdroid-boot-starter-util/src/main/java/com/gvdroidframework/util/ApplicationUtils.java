package com.gvdroidframework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 属性文件取值
 * 
 * @author TuJun
 * @date 2019年7月2日
 */
@Component
public class ApplicationUtils implements ApplicationContextAware {
	static Logger logger = LoggerFactory.getLogger(ApplicationUtils.class);
	private static ApplicationContext applicationContext;

	public ApplicationUtils() {
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ApplicationUtils.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}

	public static <T> T getBean(Class<T> requiredType) {
		return applicationContext.getBean(requiredType);
	}

	public static <T> T getPropertie(String key, Class<T> t) {
		try {
			return applicationContext.getEnvironment().getProperty(key, t);
		} catch (Exception var3) {
			logger.info(var3.getMessage());
			return null;
		}
	}

}
