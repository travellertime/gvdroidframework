package com.gvdroidframework.util;

import org.springframework.lang.Nullable;

import java.util.List;

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
    public static String stringFill(String source, int fillLength, char fillChar, boolean isLeftFill) {
        if (source == null || source.length() >= fillLength) {
            return source;
        }

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

    /**
     * 字符串拼接
     *
     * @param srcList
     * @param patternStr
     * @return
     */
    public static String strAppend(List<String> srcList, String patternStr) {
        try {
            if (CommonUtils.isEmpty(patternStr) || CommonUtils.isEmpty(srcList)) {
                return null;
            }
            StringBuilder target = new StringBuilder();
            if (srcList.size() <= 1) {
                target.append(srcList.get(0));
                return target.toString();
            }
            for (String s : srcList) {
                if (CommonUtils.isNotEmpty(s)) {
                    target.append(s);
                    target.append(patternStr);
                }
            }
            return target.substring(0, target.toString().length() - patternStr.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 字符串拼接
     *
     * @param patternStr
     * @param strs
     * @return
     */
    public static String strAppend(String patternStr, String... strs) {
        try {
            if (CommonUtils.isEmpty(patternStr) || CommonUtils.isEmpty(strs)) {
                return null;
            }

            StringBuilder target = new StringBuilder();
            if (strs.length <= 1) {
                target.append(strs[0]);
                return target.toString();
            }
            for (String s : strs) {
                if (CommonUtils.isNotEmpty(s)) {
                    target.append(s);
                    target.append(patternStr);
                }
            }
            return target.substring(0, target.toString().length() - patternStr.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
