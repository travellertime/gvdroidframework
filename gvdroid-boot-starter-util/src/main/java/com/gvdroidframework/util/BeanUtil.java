package com.gvdroidframework.util;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Field;
import java.util.*;

public class BeanUtil {

	/**
	 * 对象转Map
	 * @param obj
	 * @return
	 */
	public static Map<String, Object> ConvertObjToMap(Object obj) {
		Map<String, Object> reMap = new HashMap<>();
		if (obj == null) {
			return null;
		}
		Field[] fields = obj.getClass().getDeclaredFields();
		try {
			for (int i = 0; i < fields.length; i++) {
				try {
					Field f = obj.getClass().getDeclaredField(fields[i].getName());
					f.setAccessible(true);
					Object o = f.get(obj);
					if ((null != o) && (!"".equals(o))) {
						reMap.put(fields[i].getName(), o);
					}
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return reMap;
	}

	/**
	 * copy对象
	 * @param srcObject 源对象
	 * @param destClazz 目标对象
	 * @param <T>
	 * @param <E>
	 * @return
	 */
	public static <T, E> T copy(E srcObject, Class<T> destClazz) {
	    try {
            if (null == srcObject) {
                return (T) destClazz.newInstance();
            }
            String srcObj = JSON.toJSONString(srcObject);
            return (T) JSON.parseObject(srcObj, destClazz);
        }catch (Exception e){
            e.printStackTrace();
        }
	    return null;
	}

	/**
	 * copy List
	 * @param source 源List
	 * @param destinationClass 目标对象
	 * @param <E>
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <E> List<E> copyList(List<?> source, Class<E> destinationClass){
	    try {
            if (source.size() == 0) {
                return Collections.emptyList();
            }
            List<E> res = new ArrayList(source.size());
            for (Object o : source) {
                res.add(JSON.parseObject(JSON.toJSONString(o), destinationClass));
            }
            return res;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
	}
}
