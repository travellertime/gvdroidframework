package com.gvdroid.simple.print.utils;


import com.gvdroid.simple.print.EscPos;
import com.gvdroid.simple.print.params.Constant;
import org.apache.http.util.TextUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class SubByteString {
    public static String subStr(String str, int subSLength) throws UnsupportedEncodingException {
        if (str == null)
            return "";
        else {

            int tempSubLength = subSLength;//截取字节数
            String subStr = str.substring(0, Math.min(str.length(), subSLength));//截取的子串
//            String subStr = str.substring(0, subSLength);
            int subStrByetsL = subStr.getBytes("GBK").length;//截取子串的字节长度
            // 说明截取的字符串中包含有汉字
            while (subStrByetsL > tempSubLength) {
                int subSLengthTemp = --subSLength;
                subStr = str.substring(0, Math.min(subSLengthTemp, str.length()));
                subStrByetsL = subStr.getBytes("GBK").length;
            }
            return subStr;
        }
    }

    public static void main(String[] args) {
//        String str1 = "打包费打包费打包费打包费打包费打包费打包费打包费打包费打包费打包费打包费打包费打包费打包费打包费打包费";
//        String str2 = "外婆小炖菜+米饭套餐6.6折";
//        String[] subedStrings = getSubedStrings(str1, 40);
//        for (String subedString : subedStrings) {
//            System.out.println(subedString);
//        }



//        int num = 20;
//
//        String str = "打包费打包费打包费打包费打sazxz，包费打包费打包费打包费打包费打包费打包费打包费打包费打包费打包费打包费打包费";
//        char[] chars = str.toCharArray();
//
//        List<String> list = new ArrayList<>();
//        System.out.println(chars.length);
//        for (int i = 0; i < chars.length; i += num) {
//            String s1 = String.valueOf(chars[i]);
//            for (int k = 1; k <= num - 1; k++) {
//                if (i + k < chars.length)
//                    s1 = s1.concat(String.valueOf(chars[i + k]));
//            }
//            list.add(s1);
//        }
//
//        String[] strings = list.toArray(new String[0]);
//        for (String string : strings) {
//            System.out.println(string);
//        }
//        list.forEach(System.out::println);
    }

    public static String[] getSubedStrings(String str, int unitLength) {
        int num = unitLength;
        if ("GBK".equals(EscPos.encoding)) {
            num = unitLength / 2;
        }

//        String str = "打包费打包费打包费打包费打sazxz，包费打包费打包费打包费打包费打包费打包费打包费打包费打包费打包费打包费打包费";
        char[] chars = str.toCharArray();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i += num) {
            String s1 = String.valueOf(chars[i]);
            for (int k = 1; k <= num - 1; k++) {
                if (i + k < chars.length)
                    s1 = s1.concat(String.valueOf(chars[i + k]));
            }
            list.add(s1);
        }
        return list.toArray(new String[0]);
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
