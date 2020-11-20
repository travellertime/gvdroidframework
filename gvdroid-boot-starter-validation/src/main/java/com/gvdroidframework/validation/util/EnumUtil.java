package com.gvdroidframework.validation.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class EnumUtil {
	public static <T> boolean isEnumValues(Class<T> c, String checkValue) {
		boolean flag = false;
		if (c.isEnum()) {
			try {
				Object[] objs = c.getEnumConstants();
				List<Object> list = Arrays.asList(objs);
				Iterator<Object> it = list.iterator();
				while (it.hasNext()) {
					Object objOne = it.next();
					Field value = objOne.getClass().getDeclaredField("value");
					value.setAccessible(true);
					if ((value.getGenericType().toString().equals("class java.lang.String"))
							&& (value.get(objOne).equals(checkValue))) {
						return true;
					}
					if ((value.getGenericType().toString().equals("class java.lang.Integer"))
							&& (value.get(objOne).toString().equals(checkValue))) {
						return true;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getEnumLable(Class<T> c, Object labelValue) {
		if (!c.isEnum()) {
			return null;
		}
		try {
			Object[] objs = c.getEnumConstants();
			for (Object obj : objs) {
				Field value = obj.getClass().getDeclaredField("value");
				Field description = obj.getClass().getDeclaredField("description");
				value.setAccessible(true);
				description.setAccessible(true);
				if (((labelValue instanceof Integer)) || ((labelValue instanceof Long))) {
					if (Integer.parseInt(String.valueOf(value.get(obj))) == Integer.parseInt(labelValue.toString())) {
						return (T) obj;
					}
				} else if (((labelValue instanceof String))
						&& (String.valueOf(value.get(obj)).equals(labelValue))) {
					return (T) obj;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}