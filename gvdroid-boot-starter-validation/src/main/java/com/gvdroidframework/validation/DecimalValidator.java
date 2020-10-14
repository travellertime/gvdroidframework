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
