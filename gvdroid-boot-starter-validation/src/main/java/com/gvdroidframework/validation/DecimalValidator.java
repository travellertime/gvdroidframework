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

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

/**
 * 自定义校验数字带精度类型
 *
 * @author Colin
 * @since 2.0.0
 */
public class DecimalValidator implements ConstraintValidator<Decimal, BigDecimal> {

    // 有效位
    private int precision;

    // 小数位
    private int scale;

    @Override
    public void initialize(Decimal constraintAnnotation) {
        this.precision = constraintAnnotation.precision();
        this.scale = constraintAnnotation.scale();
    }

    @Override
    public boolean isValid(BigDecimal decimal, ConstraintValidatorContext context) {
        if (decimal == null) {
            return true;
        }
        // 比较长度
        if (decimal.precision() > this.precision) {
            return false;
        }
        // 比较整数位
        if ((decimal.precision() - decimal.scale()) > (this.precision - this.scale)) {
            return false;
        }
        // 比较小数位
        return decimal.scale() <= this.scale;

    }

}
