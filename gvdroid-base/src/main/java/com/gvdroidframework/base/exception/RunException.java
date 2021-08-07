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
package com.gvdroidframework.base.exception;


import com.gvdroidframework.base.constant.ErrorCode;

/**
 * 自定义运行时异常
 *
 * @author Colin
 * @since 3.0.0
 */
public class RunException extends RuntimeException {

    private String errorDesc;
    private String errorCode;
    private long timestamp;
    private String errorLevel = ErrorCode.SUCCESS;

    public String getErrorDesc() {
        return this.errorDesc;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public long getTimeStamp() {
        return this.timestamp;
    }

    public String getErrorLevel() {
        return this.errorLevel;
    }

    public RunException() {
        super();
    }

    public RunException(String message) {
        super(message, null, false, false);
        this.errorDesc = message;
    }

    public RunException(String message, Throwable throwable) {
        super(message, throwable, false, false);
        this.errorDesc = message;
    }

    public RunException(String message, String errorLevel, long timestamp, Throwable cause) {
        super(message, cause, false, false);
        this.errorDesc = message;
        this.errorLevel = errorLevel;
        this.timestamp = timestamp;
    }

    public RunException(String message, String errorCode, String errorLevel, long timestamp) {
        super(message, null, false, false);
        this.errorDesc = message;
        this.errorCode = errorCode;
        this.errorLevel = errorLevel;
        this.timestamp = timestamp;
    }
}
