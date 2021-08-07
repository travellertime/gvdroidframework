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
     * @param targetClass  目标对象
     * @param <T>          t
     * @param <E>          e
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
     * @param sourceList  源List
     * @param targetClass 目标对象
     * @param <E>         e
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

    /**
     * copy Properties
     * @param sourceObject
     * @param targetObject
     */
    public static void copyProperties(Object sourceObject, Object targetObject) {
        try {
            org.springframework.beans.BeanUtils.copyProperties(sourceObject, targetObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
