package com.gvdroidframework.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;

public class JsonUtil {

    /**
     * 对象转json串，全字段转换，含null
     *
     * @param object
     * @return
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
     * @param object
     * @return
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
     * @param jsonStr JSON数据
     * @param clazz   指定的java对象
     * @return 指定的java对象
     */
    public static <T> T toBean(String jsonStr, Class<T> clazz) {
        return JSON.parseObject(jsonStr, clazz);
    }

    /**
     * 功能描述：把JSON数据转换成指定的java对象，属性保持原来的顺序
     * @param srcJsonStr
     * @param destClazz
     * @param <T>
     * @return
     */
    public static <T> T toBeanOrdered(String srcJsonStr, Class<T> destClazz) {
        return JSON.parseObject(srcJsonStr, destClazz, Feature.OrderedField);
    }

    /**
     * 将json转化成List
     *
     * @param srcJsonStr 源字符串
     * @param destClazz 目标对象
     * @return
     */
    public static <T> List<T> toList(String srcJsonStr, Class<T> destClazz) {
        return JSONObject.parseArray(srcJsonStr, destClazz);
    }

}
