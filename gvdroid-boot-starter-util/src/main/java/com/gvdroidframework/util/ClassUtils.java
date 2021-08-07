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
package com.gvdroidframework.util;

import com.gvdroidframework.base.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassUtils {

    private static final Logger logger = LoggerFactory.getLogger(ClassUtils.class);

    /**
     * 获取当前类以及其父类中某个字段类型的值,必须有get方法
     *
     * @param o         要查找的实体，必须是一个已实例化的类
     * @param filedName filedName
     * @param t         要返回的类型CLASS
     * @param <T>       T
     * @return 返回列的字段, 没有就是null
     */
    @SuppressWarnings("unchecked")
    public static <T> T getObjFiledValue(Object o, String filedName, Class<T> t) {
        if (null == o || filedName == null)
            return null;
        T t1 = null;
        try {
            //获取首字母大写
            char[] cs = filedName.toCharArray();
            cs[0] -= 32;
            String methodName = "get" + String.valueOf(cs);
            for (Method m : o.getClass().getMethods()) {
                if (methodName.equals(m.getName())) {
                    t1 = (T) m.invoke(o);
                    break;
                }
            }
        } catch (InvocationTargetException | IllegalAccessException e) {
            logger.error(e.getMessage());
        }
        return t1;
    }

    /**
     * 利用反射获取指定对象的指定属性
     * 因为没使用泛型，导致返回值要重新转型，建议使用getObjFiledValue方法代替
     *
     * @param obj       目标对象
     * @param fieldName 目标属性
     * @return 目标属性的值
     */
    public static Object getFieldValue(Object obj, String fieldName) {
        Object result = null;
        Field field = getField(obj, fieldName);
        if (field != null) {
            field.setAccessible(true);
            try {
                result = field.get(obj);
            } catch (IllegalArgumentException | IllegalAccessException e) {
//                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 利用反射获取指定对象里面的指定属性
     *
     * @param obj       目标对象
     * @param fieldName 目标属性
     * @return 目标字段
     */
    private static Field getField(Object obj, String fieldName) {
        Field field = null;
        for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                break;
            } catch (NoSuchFieldException e) {
//                e.printStackTrace();
            }
        }
        return field;
    }

    /**
     * 利用反射设置指定对象的指定属性为指定的值
     *
     * @param obj        目标对象
     * @param fieldName  目标属性
     * @param fieldValue 目标值
     */
    public static void setFieldValue(Object obj, String fieldName,
                                     String fieldValue) {
        Field field = getField(obj, fieldName);
        if (field != null) {
            try {
                field.setAccessible(true);
                field.set(obj, fieldValue);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                logger.error("get error:" + e.getMessage());
                throw new BaseException(e.getMessage());
            }
        }
    }
}
