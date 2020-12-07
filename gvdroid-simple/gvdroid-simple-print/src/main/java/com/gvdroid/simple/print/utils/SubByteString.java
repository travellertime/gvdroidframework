package com.gvdroid.simple.print.utils;


import com.gvdroid.simple.print.params.Constant;
import org.apache.http.util.TextUtils;

import java.io.UnsupportedEncodingException;

public class SubByteString {
    public static String subStr(String str, int subSLength) throws UnsupportedEncodingException {
        if (str == null)
            return "";
        else {
            int tempSubLength = subSLength;//截取字节数
            String subStr = str.substring(0, str.length() < subSLength ? str.length() : subSLength);//截取的子串
            int subStrByetsL = subStr.getBytes("GBK").length;//截取子串的字节长度
            //int subStrByetsL = subStr.getBytes().length;//截取子串的字节长度
            // 说明截取的字符串中包含有汉字
            while (subStrByetsL > tempSubLength) {
                int subSLengthTemp = --subSLength;
                subStr = str.substring(0, subSLengthTemp > str.length() ? str.length() : subSLengthTemp);
                subStrByetsL = subStr.getBytes("GBK").length;
                //subStrByetsL = subStr.getBytes().length;
            }
            return subStr;
        }
    }

    public static String[] getSubedStrings(String string, int unitLength) {
        if (TextUtils.isEmpty(string)) {
            return null;
        }

        String str = new String(string);

        int arraySize = 0;
        try {
            arraySize = str.getBytes("GBK").length / unitLength;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        if (str.getBytes().length % unitLength > 0) {
            arraySize++;
        }

        String[] result = new String[arraySize];

        for (int i = 0; i < arraySize; i++) {
            try {
                result[i] = subStr(str, unitLength);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            str = str.replace(result[i], "");
        }

        return result;
    }

    /**
     * 填充打印文本长度以及文本位置设置
     *
     * @param str    文本
     * @param width  长度
     * @param format 0 居左 1 居中 2 居右
     * @return 填充后的文本
     */
    private static String fillLength(String str, int width, int format) {
        try {
            int length = str.getBytes(Constant.DEFAULT_ENCODING).length;
            switch (format) {
                case 0: {
                    StringBuilder strBuilder = new StringBuilder(str);
                    while (length < width) {
                        strBuilder.append(" ");
                        length++;
                    }
                    str = strBuilder.toString();
                    break;
                }
                case 1: {
                    if (length < width) {
                        StringBuilder text = new StringBuilder();
                        int pre = (width - length) / 2;
                        int end = width - length - pre;
                        while (pre > 0) {
                            text.append(" ");
                            pre--;
                        }
                        while (end > 0) {
                            str += " ";
                            end--;
                        }
                        str = text + str;
                    }
                    break;
                }
                case 2: {
                    StringBuilder text = new StringBuilder();
                    while (length < width) {
                        text.append(" ");
                        length++;
                    }
                    str = text + str;
                    break;
                }
                default:
                    break;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }
}
