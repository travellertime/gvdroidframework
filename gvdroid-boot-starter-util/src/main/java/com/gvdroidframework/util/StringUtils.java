package com.gvdroidframework.util;

import org.springframework.lang.Nullable;

public class StringUtils {

    public static boolean isEmpty(@Nullable Object str) {
        return str == null || "".equals(str);
    }

    /**
     * 字符串补齐
     *
     * @param source     源字符串
     * @param fillLength 补齐长度
     * @param fillChar   补齐的字符
     * @param isLeftFill true为左补齐，false为右补齐
     * @return String
     */
    private static String stringFill(String source, int fillLength,
                                     char fillChar, boolean isLeftFill) {
        if (source == null || source.length() >= fillLength)
            return source;

        StringBuilder result = new StringBuilder(fillLength);
        int len = fillLength - source.length();
        if (isLeftFill) {
            for (; len > 0; len--) {
                result.append(fillChar);
            }
            result.append(source);
        } else {
            result.append(source);
            for (; len > 0; len--) {
                result.append(fillChar);
            }
        }
        return result.toString();
    }

}
