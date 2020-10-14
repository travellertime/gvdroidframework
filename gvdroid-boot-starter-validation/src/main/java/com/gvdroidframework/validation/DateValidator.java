package com.gvdroidframework.validation;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 自定义日期校验类
 *
 * @author Colin
 * @since 2.0.0
 */
public class DateValidator implements ConstraintValidator<Date, String> {

    // 日期格式
    String format;

    @Override
    public void initialize(Date constraintAnnotation) {
        this.format = constraintAnnotation.format();
    }

    @Override
    public boolean isValid(String date, ConstraintValidatorContext context) {

        if(StringUtils.isEmpty(date)){
            return true;
        }

        if (date.length() > this.format.length()) {
            return false;
        }
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat dateFormat = new SimpleDateFormat(this.format);
        try {
            // 设置lenient为false.
            // 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            dateFormat.setLenient(false);
            dateFormat.parse(date);
        } catch (ParseException e) {
            // e.printStackTrace();
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return false;
        }
        return true;
    }

}
