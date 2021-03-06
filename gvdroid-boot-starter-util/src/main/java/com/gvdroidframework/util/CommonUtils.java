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

    public static boolean isEmptyOrZero(Boolean value) {
        return null == value || !value;
    }

    public static boolean isEmptyOrZero(BigDecimal value) {
        return null == value || BigDecimal.ZERO.compareTo(value) == 0;
    }

    public static void primaryKeyValidation(Context context, String... keys) {
        if (StringUtils.isEmpty(context.getEntityId())) {
            throw new BaseException(ErrorCode.ERROR_MSG_902, ErrorCode.ERROR_CODE_902);
        }

        for (String key : keys) {
            if (StringUtils.isEmpty(key)) {
                throw new BaseException(ErrorCode.ERROR_MSG_903, ErrorCode.ERROR_CODE_903);
            }
        }
    }
}
