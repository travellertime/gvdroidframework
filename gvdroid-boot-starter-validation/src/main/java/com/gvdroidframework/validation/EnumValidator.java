package com.gvdroidframework.validation;

import com.gvdroidframework.validation.util.EnumUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnumValidator implements ConstraintValidator<Enum, String> {

	private Class<?> enumClass;

	public void initialize(Enum constraintAnnotation) {
		enumClass = constraintAnnotation.enumClass();
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (null == value) {
			return true;
		}
		// 校验是否在枚举中
		if (!EnumUtil.isEnumValues(enumClass, value)) {
			return false;
		}
		return true;
	}

}
