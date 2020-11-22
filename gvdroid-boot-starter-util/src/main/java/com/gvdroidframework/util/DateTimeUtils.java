package com.gvdroidframework.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    public static final DateTimeFormatter TIME_FORMAT_FULL = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter TIME_FORMAT_YMD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter TIME_FORMAT_YMD_SIMP = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static final DateTimeFormatter TIME_FORMAT_HMS = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static final DateTimeFormatter TIME_FORMAT_HM = DateTimeFormatter.ofPattern("HH:mm");
    public static final DateTimeFormatter TIME_FORMAT_YMD_HM = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

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
    public static String getDateHMSStr() {
        return LocalTime.now().format(TIME_FORMAT_HMS);
    }

    /**
     * 获取当前系统日期字符串，格式：yyyy-MM-dd
     *
     * @return
     */
    public static String getDateYMDStr() {
        return LocalDate.now().format(TIME_FORMAT_YMD);
    }

    /**
     * 获取当前系统日期字符串，格式：yyyyMMdd
     *
     * @return
     */
    public static String getDateYMDSimpStr() {
        return LocalDate.now().format(TIME_FORMAT_YMD_SIMP);
    }

    /**
     * 获取当前系统日期时间字符串，格式：yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getDateStr() {
        return LocalDateTime.now().format(TIME_FORMAT_FULL);
    }

    /**
     * 获取当前系统日期时间字符串，格式：yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static LocalDateTime getFormatDate(DateTimeFormatter format) {
        return LocalDateTime.parse(LocalDateTime.now().format(format), format);
    }

    /**
     * 获取当前星期几
     *
     * @return
     */
    public static String getWeekDay() {
        return String.valueOf(LocalDateTime.now().getDayOfWeek());
    }

    /**
     * 校验当前时间是否在时间区域内
     *
     * @param timeArea 时间区域，格式：HH:mm-HH:mm
     * @return
     */
    public static boolean checkTime(String... timeArea) {
        LocalDateTime time = LocalDateTime.now();
        LocalDateTime localDateTime = LocalDateTime.parse(time.format(TIME_FORMAT_YMD_HM), TIME_FORMAT_YMD_HM);
        int len = timeArea.length;
        for (int i = 0; i < len; i++) {
            LocalDateTime dateTimeEnd;
            String[] strArray = timeArea[i].split("-");
            LocalTime timeStart = LocalTime.parse(strArray[0], TIME_FORMAT_HM);
            LocalTime timeEnd = LocalTime.parse(strArray[1], TIME_FORMAT_HM);

            LocalDateTime dateTimeStart = LocalDateTime.of(time.toLocalDate(), timeStart);
            if (timeStart.isAfter(timeEnd)) {
                dateTimeEnd = LocalDateTime.of(time.toLocalDate(), timeEnd).plusDays(1);
            } else
                dateTimeEnd = LocalDateTime.of(time.toLocalDate(), timeEnd);

            if (localDateTime.isAfter(dateTimeStart) && localDateTime.isBefore(dateTimeEnd)) {
                return true;
            }
        }
        return false;
    }

}
