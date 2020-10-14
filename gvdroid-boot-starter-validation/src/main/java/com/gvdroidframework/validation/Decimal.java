package com.gvdroidframework.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 只适用于BigDecimal类型
 *
 * @author Colin
 * @since 2.0.0
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = DecimalValidator.class)
@Documented
public @interface Decimal {

    String message() default "message";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    // 有效位
    int precision();

    // 小数位
    int scale();

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        Decimal[] value();
    }
}
