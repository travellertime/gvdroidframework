package com.gvdroidframework.logging.annotation;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * 业务日志注解，该注解用于接口的入口方法，并且方法所属类必须继承接口实现类的父类
 * 根据配置文件定义业务日志类型, 1-查询类，2-维护类，4-交易类，类型支持位运算，如希望支持查询类和交易类则将配置属性配置为5即可。
 * 根据配置文件定义运行环境，dev和prod，dev会记录所有日志，prod默认只记录查询类的统计日志和维护类以及交易类的所有日志。
 *
 * @author XIEZHONG
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Order(Ordered.HIGHEST_PRECEDENCE + 999)
public @interface BusinessLogger {

    String value() default "";
}
