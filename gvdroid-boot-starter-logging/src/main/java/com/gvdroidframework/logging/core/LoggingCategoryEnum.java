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
