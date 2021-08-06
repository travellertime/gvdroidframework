package com.gvdroidframework.util;

import com.gvdroidframework.base.component.Context;
import com.gvdroidframework.base.constant.ErrorCode;
import com.gvdroidframework.base.exception.BaseException;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

public class CommonUtils {

    public static boolean isEmptyOrZero(Short value) {
        return null == value || value == 0;
    }

    public static boolean isEmptyOrZero(Integer value) {
        return null == value || value == 0;
    }

    public static boolean isEmptyOrZero(Long value) {
        return null == value || value == 0;
    }

    public static boolean isEmptyOrZero(Boolean value) {
        return null == value || !value;
    }

    public static boolean isEmptyOrZero(BigDecimal value) {
        return null == value || BigDecimal.ZERO.compareTo(value) == 0;
    }

    public static void primaryKeyValidation(Context context, String... keys) {
        if (!StringUtils.hasLength(context.getEntityId())) {
            throw new BaseException(ErrorCode.ERROR_MSG_902, ErrorCode.ERROR_CODE_902);
        }

        for (String key : keys) {
            if (!StringUtils.hasLength(key)) {
                throw new BaseException(ErrorCode.ERROR_MSG_903, ErrorCode.ERROR_CODE_903);
            }
        }
    }

//    /**
//     * 判断对象是否为空
//     *
//     * @param value
//     * @return
//     */
//    public static boolean isEmpty(Object value) {
//        if (value == null) {
//            return true;
//        }
//        if ((value instanceof String)) {
//            if (((String) value).trim().replaceAll("\\s", "").equals("")) {
//                return true;
//            }
//        } else if ((value instanceof Collection)) {
//            if (((Collection) value).isEmpty()) {
//                return true;
//            }
//        } else if (value.getClass().isArray()) {
//            if (Array.getLength(value) == 0) {
//                return true;
//            }
//        } else if ((value instanceof Map)) {
//            if (((Map) value).isEmpty()) {
//                return true;
//            }
//        } else {
//            return false;
//        }
//        return false;
//    }
//
//    /**
//     * 判断所有对象是否为空
//     *
//     * @param value
//     * @param items
//     * @return
//     */
//    public static boolean isEmpty(Object value, Object... items) {
//        if ((isEmpty(value)) || (isEmpty(items))) {
//            return true;
//        }
//        for (Object item : items) {
//            if (isNotEmpty(item)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static boolean isNotEmpty(Object value) {
//        return !isEmpty(value);
//    }
//
//    public static boolean isNotEmpty(Object value, Object... items) {
//        return !isEmpty(value, items);
//    }
//
//    /**
//     * 判断多个对象中是否有空对象
//     *
//     * @param value
//     * @param items
//     * @return
//     */
//    public static boolean isHasEmpty(Object value, Object... items) {
//        if ((isEmpty(value)) || (isEmpty(items))) {
//            return true;
//        }
//        for (Object item : items) {
//            if (isEmpty(item)) {
//                return true;
//            }
//        }
//        return false;
//    }

}
