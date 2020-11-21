package com.gvdroidframework.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    public static final DateTimeFormatter TIME_FORMAT_FULL = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter TIME_FORMAT_YMD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter TIME_FORMAT_HMS = DateTimeFormatter.ofPattern("HH:mm:ss");

    /**
     * 获取当前系统时间
     *
     * @return
     */
    public static LocalTime getLocalTime() {
        return LocalTime.now();
    }

    /**
     * 获取当前系统日期
     *
     * @return
     */
    public static LocalDate getLocalDate() {
        return LocalDate.now();
    }

    /**
     * 获取当前系统日期时间
     *
     * @return
     */
    public static LocalDateTime getLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 获取当前系统时间字符串,格式：HH:mm:ss
     *
     * @return
     */
    public static String getLocalTimeString() {
        return LocalTime.now().format(TIME_FORMAT_HMS);
    }

    /**
     * 获取当前系统日期字符串，格式：yyyy-MM-dd
     *
     * @return
     */
    public static String getLocalDateString() {
        return LocalDate.now().format(TIME_FORMAT_YMD);
    }

    /**
     * 获取当前系统日期时间字符串，格式：yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getLocalDateTimeString() {
        return LocalDateTime.now().format(TIME_FORMAT_FULL);
    }

}
