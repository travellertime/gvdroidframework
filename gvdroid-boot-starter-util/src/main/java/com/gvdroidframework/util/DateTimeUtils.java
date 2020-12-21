package com.gvdroidframework.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 日期时间工具
 *
 * @author TuJun
 */
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
     * @return LocalTime
     */
    public static LocalTime getLocalTime() {
        return LocalTime.now();
    }

    /**
     * 获取当前系统日期
     *
     * @return LocalDate
     */
    public static LocalDate getLocalDate() {
        return LocalDate.now();
    }

    /**
     * 获取当前系统日期时间
     *
     * @return LocalDateTime
     */
    public static LocalDateTime getLocalDateTime() {
        return LocalDateTime.now();
    }


    /**
     * 获取当前系统时间字符串,格式：HH:mm:ss
     *
     * @return String
     */
    public static String getDateHMSStr() {
        return LocalTime.now().format(TIME_FORMAT_HMS);
    }

    /**
     * 获取当前系统日期字符串，格式：yyyy-MM-dd
     *
     * @return String
     */
    public static String getDateYMDStr() {
        return LocalDate.now().format(TIME_FORMAT_YMD);
    }

    /**
     * 获取当前系统日期字符串，格式：yyyy-MM-dd
     *
     * @return String
     */
    public static String getDateYMDStr(LocalDateTime time) {
        return time.format(TIME_FORMAT_YMD);
    }

    /**
     * 获取当前系统日期字符串，格式：yyyyMMdd
     *
     * @return String
     */
    public static String getDateYMDSimpStr() {
        return LocalDate.now().format(TIME_FORMAT_YMD_SIMP);
    }

    /**
     * 获取当前系统日期字符串，格式：yyyyMMdd
     *
     * @return String
     */
    public static String getDateYMDSimpStr(LocalDateTime time) {
        return time.format(TIME_FORMAT_YMD_SIMP);
    }

    /**
     * 获取当前系统日期时间字符串，格式：yyyy-MM-dd HH:mm:ss
     *
     * @return String
     */
    public static String getDateStr() {
        return LocalDateTime.now().format(TIME_FORMAT_FULL);
    }

    /**
     * 获取当前系统日期时间字符串，格式：yyyy-MM-dd HH:mm:ss
     *
     * @return LocalDateTime
     */
    public static LocalDateTime getFormatDate(DateTimeFormatter format) {
        return LocalDateTime.parse(LocalDateTime.now().format(format), format);
    }

    /**
     * 获取当前星期几
     *
     * @return String
     */
    public static String getWeekDay(String timeZone) {
        LocalDateTime time = toLocalDateTimeTZ(timeZone);
        return String.valueOf(time.getDayOfWeek());
    }

    /**
     * 获取当前星期几
     *
     * @return String
     */
    public static String getWeekDay(LocalDateTime time) {
        return String.valueOf(time.getDayOfWeek());
    }

    /**
     * Date 转 LocalDateTime (默认时区转换）
     *
     * @return LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }

    /**
     * LocalDateTime 转换时区
     *
     * @return LocalDateTime
     */
    public static LocalDateTime toLocalDateTimeTZ(String timeZone) {
        ZoneId zoneId = ZoneId.of(timeZone);
        return ZonedDateTime.now().withZoneSameInstant(zoneId).toLocalDateTime();
    }


    /**
     * 校验当前时区时间是否在时间区域内
     *
     * @param time     时区ID
     * @param timeArea 时间区域，格式：HH:mm-HH:mm
     * @return boolean
     */
    public static boolean checkTimeIn(LocalDateTime time, String... timeArea) {
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
            } else {
                dateTimeEnd = LocalDateTime.of(time.toLocalDate(), timeEnd);
            }

            if (localDateTime.isAfter(dateTimeStart) && localDateTime.isBefore(dateTimeEnd)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 校验是否超时
     *
     * @param date             日期时间
     * @param effecMillisecond 有效时长（毫秒）
     * @return boolean
     */
    public static boolean checkTimeOut(Date date, Long effecMillisecond) {
        int denominator = 1000;
        LocalDateTime localDateTime = toLocalDateTime(date);
        return LocalDateTime.now().isAfter(localDateTime.plusSeconds(effecMillisecond / denominator));
    }


}
