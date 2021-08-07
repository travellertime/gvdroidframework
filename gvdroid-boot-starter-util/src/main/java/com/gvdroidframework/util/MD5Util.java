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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5工具类
 *
 * @author Internet
 * @version 1.0.0
 * @since 1.0.0
 */
//@Deprecated
public class MD5Util {

    private static Logger logger = LoggerFactory.getLogger(MD5Util.class);


    private static final String HEX_NUMS_STR = "0123456789ABCDEF";
    private static final Integer SALT_LENGTH = 12;


    public static final String MD5_16bit(String readyEncryptStr) {
        if (readyEncryptStr != null) {
            return MD5_32bit(readyEncryptStr).substring(8, 24);
        } else {
            return null;
        }
    }


    /**
     * Determine encrypt algorithm MD5
     */
    private static final String ALGORITHM_MD5 = "MD5";
    /**
     * UTF-8 Encoding
     */
    private static final String UTF_8 = "UTF-8";


    /**
     * MD5 32bit Encrypt Methods.
     *
     * @param readyEncryptStr ready encrypt string
     * @return String encrypt result string
     */
    public static final String MD5_32bit(String readyEncryptStr) {
        if (StringUtils.isEmpty(readyEncryptStr))
            return null;
        try {

            //Get MD5 digest algorithm's MessageDigest's instance.
            MessageDigest md = null;
            md = MessageDigest.getInstance("MD5");
            //Use specified byte update digest.
            md.update(readyEncryptStr.getBytes());
            //Get cipher text
            byte[] b = md.digest();
            //The cipher text converted to hexadecimal string
            StringBuilder su = new StringBuilder();
            //byte array switch hexadecimal number.
            for (int offset = 0, bLen = b.length; offset < bLen; offset++) {
                String haxHex = Integer.toHexString(b[offset] & 0xFF);
                if (haxHex.length() < 2) {
                    su.append("0");
                }
                su.append(haxHex);
            }
            return su.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage());
        }
        return null;

    }

    /**
     * MD5 32bit Encrypt Methods.
     *
     * @param readyEncryptStr ready encrypt string
     * @return String encrypt result string
     */
    public static String MD5_32bit1(String readyEncryptStr) {
        if (StringUtils.isEmpty(readyEncryptStr))
            return null;
        try {
            //The cipher text converted to hexadecimal string
            StringBuilder su = new StringBuilder();
            //Get MD5 digest algorithm's MessageDigest's instance.
            MessageDigest md = null;
            md = MessageDigest.getInstance(ALGORITHM_MD5);
            byte[] b = md.digest(readyEncryptStr.getBytes());
            int temp = 0;
            //byte array switch hexadecimal number.
            for (int offset = 0, bLen = b.length; offset < bLen; offset++) {
                temp = b[offset];
                if (temp < 0) {
                    temp += 256;
                }
                int d1 = temp / 16;
                int d2 = temp % 16;
                su.append(Integer.toHexString(d1) + Integer.toHexString(d2));
            }
            return su.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage());
        }
        return null;

    }

    /**
     * MD5 32bit Encrypt Methods.
     *
     * @param readyEncryptStr ready encrypt string
     * @return String encrypt result string
     */
    public static String MD5_32bit2(String readyEncryptStr) {
        if (StringUtils.isEmpty(readyEncryptStr))
            return null;
        try {
            //The cipher text converted to hexadecimal string
            StringBuilder su = new StringBuilder();
            //Get MD5 digest algorithm's MessageDigest's instance.
            MessageDigest md = MessageDigest.getInstance(ALGORITHM_MD5);

            //Use specified byte update digest.
            md.update(readyEncryptStr.getBytes());
            byte[] b = md.digest();
            int temp = 0;
            //byte array switch hexadecimal number.
            for (int offset = 0, bLen = b.length; offset < bLen; offset++) {
                temp = b[offset];
                if (temp < 0) {
                    temp += 256;
                }
                if (temp < 16) {
                    su.append("0");
                }
                su.append(Integer.toHexString(temp));
            }
            return su.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage());
        }
        return null;
    }


    /**
     * MD5 16bit Encrypt Methods.
     *
     * @param readyEncryptStr ready encrypt string
     * @return String encrypt result string
     */
    public static String MD5_64bit(String readyEncryptStr) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(ALGORITHM_MD5);
//            BASE64Encoder base64Encoder = new BASE64Encoder();

            return Base64Utils.encodeToString(md.digest(readyEncryptStr.getBytes(StandardCharsets.UTF_8))).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage());
        }
        return null;
    }


    /**
     * 判断是否32位的md5密码
     *
     * @param password   password
     * @param dbPassword dbPassword
     * @return boolean
     */
    public static boolean validPassword32Bit(String password, String dbPassword) {
        return MD5_32bit(password).toUpperCase().equals(dbPassword.toUpperCase());
    }
}
