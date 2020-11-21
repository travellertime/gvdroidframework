package com.gvdroidframework.util;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Field;
import java.util.*;

public class BeanUtils {

    /**
     * 对象转Map
     *
     * @param object Object
     * @return Map
     */
    public static Map<String, Object> ConvertObjToMap(Object object) {
        Map<String, Object> reMap = new HashMap<>();
        if (object == null) {
            return null;
        }
        Field[] fields = object.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                try {
                    Field f = object.getClass().getDeclaredField(field.getName());
                    f.setAccessible(true);
                    Object o = f.get(object);
                    if ((null != o) && (!"".equals(o))) {
                        reMap.put(field.getName(), o);
                    }
                } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
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
     *
     * @param sourceObject 源对象
     * @param targetClass 目标对象
     * @param <T>       t
     * @param <E>       e
     * @return destClazz.class
     */
    public static <T, E> T copy(E sourceObject, Class<T> targetClass) {
        try {
            if (null == sourceObject) {
                return targetClass.newInstance();
            }
            String srcObj = JSON.toJSONString(sourceObject);
            return JSON.parseObject(srcObj, targetClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * copy List
     *
     * @param sourceList    源List
     * @param targetClass 目标对象
     * @param <E>       e
     * @return List
     */
    public static <E> List<E> copyList(List<?> sourceList, Class<E> targetClass) {
        try {
            if (sourceList.size() == 0) {
                return Collections.emptyList();
            }
            List<E> res = new ArrayList<>(sourceList.size());
            for (Object o : sourceList) {
                res.add(JSON.parseObject(JSON.toJSONString(o), targetClass));
            }
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
