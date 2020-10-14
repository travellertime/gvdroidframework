package com.gvdroidframework.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 校验字符串是否满足指定日期格式
 *
 * @author Colin
 */
@Target({FIELD, METHOD, PARAMETER, CONSTRUCTOR, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = DateValidator.class)
@Documented
public @interface Date {
    String message() default "message";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String format();
}
