package com.gvdroidframework.logging.core;

public enum LoggingCategoryEnum {

    inquiry(1), maintenance(2), transaction(4);

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    LoggingCategoryEnum(Integer code) {
        this.code = code;
    }

    public static LoggingCategoryEnum getByCode(Integer code) {
        LoggingCategoryEnum loggingCategoryEnum;
        for (int i = 0; i < LoggingCategoryEnum.values().length; i++) {
            loggingCategoryEnum = LoggingCategoryEnum.values()[i];
            if (code.equals(loggingCategoryEnum.getCode())) {
                return loggingCategoryEnum;
            }
        }
        return null;
    }

    public static boolean isInclude(LoggingCategoryEnum category, Integer c) {
        return (c & category.getCode()) != 0;

    }

    public static LoggingCategoryEnum getByString(String str) {
        LoggingCategoryEnum loggingCategoryEnum;
        for (int i = 0; i < LoggingCategoryEnum.values().length; i++) {
            loggingCategoryEnum = LoggingCategoryEnum.values()[i];
            if (str.contains(loggingCategoryEnum.toString())){
                return loggingCategoryEnum;
            }
        }
        return null;
    }
}
