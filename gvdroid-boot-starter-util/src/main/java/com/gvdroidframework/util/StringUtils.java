package com.gvdroidframework.util;

import org.springframework.lang.Nullable;

public class StringUtils {

    public static boolean isEmpty(@Nullable String str) {
        return !org.springframework.util.StringUtils.hasLength(str);
    }

    public static boolean isEmpty(@Nullable CharSequence str) {
        return !org.springframework.util.StringUtils.hasLength(str);
    }
}
