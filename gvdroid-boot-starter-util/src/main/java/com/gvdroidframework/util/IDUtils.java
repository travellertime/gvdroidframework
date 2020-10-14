package com.gvdroidframework.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * 生成ID的工具类.
 * 可生成UUID、订单编号、短信验证码等。
 *
 * @author Colin
 * @since 1.0.0
 */
public class IDUtils {

    /**
     * 生成UUID
     *
     * @return String
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }


    /**
     * 生成短的UUID
     *
     * @return String
     */
    public static String generateShortUUID() {
        return generateUUID().replaceAll("-", "").toUpperCase();
    }

    /**
     * 根据num获得指定数量的短uuid
     *
     * @param numbers 多少组uuid
     * @return Strings
     */
    public static String[] generateShortUUIDs(int numbers) {
        if (numbers < 1)
            return null;
        String[] strings = new String[numbers];
        for (int i = 0; i < numbers; i++) {
            strings[i] = generateShortUUID();
        }
        return strings;
    }

    /**
     * 根据num获得指定数量的uuid
     *
     * @param numbers 多少组uuid
     * @return Strings
     */
    public static String[] generateUUIDs(int numbers) {
        if (numbers < 1)
            return null;
        String[] strings = new String[numbers];
        for (int i = 0; i < numbers; i++) {
            strings[i] = generateUUID();
        }
        return strings;
    }


    public static String[] chars = new String[]{"a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};


    /**
     * 创建8位的uuid
     *
     * @return String
     */
    public static String generate8BitUUID() {
        StringBuilder shortBuffer = new StringBuilder();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString().toUpperCase();
    }

    /**
     * 生成6位数的短信验证码
     *
     * @return 6位数的短信验证码
     */
    public static int generatePinCode() {
        return doGeneratePinCode(100000);
    }

    /**
     * 根据传入的位数生成指定位数的验证码，最大只能支持8位，如果超过8位则只返回8位
     *
     * @param digits 位数
     * @return 返回验证码
     */
    public static int generatePinCode(int digits) {
        int x;
        if (digits > 8 || digits < 1) {
            x = (int) Math.pow(10, 7);
        } else {
            x = (int) Math.pow(10, digits - 1);
        }
        return doGeneratePinCode(x);
    }

    /**
     * 执行验证码生成
     *
     * @param x int
     * @return int
     */
    private static int doGeneratePinCode(int x) {
        return (int) ((Math.random() * 9 + 1) * x);
    }

    /**
     * snowFlake算法实现
     */
    private static SnowFlakeUtil snowFlake = null;

    /**
     * snowFlake算法实现的订单id生成, 注意该方法不建议在分布式环境下使用
     * @return long
     */
    public static long generateOrderId() {
        if (null == snowFlake) {
            Random random = new Random();
            snowFlake = new SnowFlakeUtil(random.nextInt(32), random.nextInt(32));
        }
        return snowFlake.nextId();
    }

    /**
     * snowFlake算法实现的订单id生成, 注意该方法不建议在分布式环境下使用
     * {@link #generateOrderId()}
     *
     * @param numbers numbers
     * @return Lists
     */
    public static List<Long> generateOrderIds(int numbers) {
        if (numbers < 1)
            return new ArrayList<>();
        if (null == snowFlake) {
            Random random = new Random();
            snowFlake = new SnowFlakeUtil(random.nextInt(32), random.nextInt(32));
        }
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < numbers; i++) {
            list.add(snowFlake.nextId());
        }
        return list;
    }
}
