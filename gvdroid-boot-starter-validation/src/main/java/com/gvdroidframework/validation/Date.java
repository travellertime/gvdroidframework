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
