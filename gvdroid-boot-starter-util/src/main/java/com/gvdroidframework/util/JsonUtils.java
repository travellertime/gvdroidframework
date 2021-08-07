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
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;

@Deprecated
public class JsonUtils {

    /**
     * 对象转json串，全字段转换，含null
     *
     * @param object object
     * @return String
     */
    public static String allToJson(Object object) {
        if (null == object) {
            return null;
        }
        return JSON.toJSONString(object, SerializerFeature.WriteMapNullValue);
    }

    /**
     * 对象转json串，null字段忽略
     *
     * @param object object
     * @return String
     */
    public static String allToJsonIgnoreNull(Object object) {
        if (null == object) {
            return null;
        }
        return JSON.toJSONString(object);
    }

    /**
     * 功能描述：把JSON数据转换成指定的java对象
     *
     * @param jsonString  JSON数据
     * @param targetClass 指定的java对象
     * @return 指定的java对象
     */
    public static <T> T toBean(String jsonString, Class<T> targetClass) {
        return JSON.parseObject(jsonString, targetClass);
    }

    /**
     * 功能描述：把JSON数据转换成指定的java对象，属性保持原来的顺序
     *
     * @param sourceJsonString srcJsonString
     * @param targetClass      destClazz
     * @param <T>              t
     * @return destClazz
     */
    public static <T> T toBeanOrdered(String sourceJsonString, Class<T> targetClass) {
        return JSON.parseObject(sourceJsonString, targetClass, Feature.OrderedField);
    }

    /**
     * 将json转化成List
     *
     * @param sourceJsonString 源字符串
     * @param targetClass      目标对象
     * @return List
     */
    public static <T> List<T> toList(String sourceJsonString, Class<T> targetClass) {
        return JSONObject.parseArray(sourceJsonString, targetClass);
    }

}
