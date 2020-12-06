package com.gvdroid.simple.print;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class StringLengthTest {
    public static void main(String[] args) throws UnsupportedEncodingException {

        String ss = "这个字符串这么长你\n是怎么截取它的长度的啊";

        int width = 120;
        int length = ss.getBytes("GBK").length;
        while (length < width) {
            ss += " ";
            length++;
        }

        System.out.println(ss);
        System.out.println(ss.length());
    }
}
