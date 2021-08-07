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


import com.gvdroidframework.base.component.Status;
import com.gvdroidframework.base.constant.ErrorCode;

/**
 * Function:  自定义异常基础类.
 * Date:      2015-11-16
 *
 * @author Colin
 * @since 1.0.0
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 4290784890876524392L;

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

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
//        super(message, null, false, false);
        this.errorDesc = message;
    }

    public BaseException(String message, Throwable throwable) {
        super(message, throwable, false, false);
        this.errorDesc = message;
    }

    /**
     * @param message   String
     * @param errorCode String
     */
    public BaseException(String message, String errorCode) {
//        super(message, null, false, false);
        super(message);
        this.errorDesc = message;
        this.errorCode = errorCode;
    }

    public BaseException(String message, String errorCode, String errorLevel) {
        super(message);
        this.errorDesc = message;
        this.errorCode = errorCode;
        this.errorLevel = errorLevel;
    }

    public BaseException(String message, String errorCode, Throwable throwable) {
//        super(message, null, false, false);
        super(message, throwable, false, false);
        this.errorDesc = message;
        this.errorCode = errorCode;
    }

    public BaseException(String message, String errorCode, String errorLevel, long timestamp) {
//        super(message, null, false, false);
        super(message);
        this.errorDesc = message;
        this.errorCode = errorCode;
        this.errorLevel = errorLevel;
        this.timestamp = timestamp;
    }

    public BaseException(String message, String errorCode, String errorLevel, long timestamp, Throwable throwable) {
//        super(message, null, false, false);
        super(message, throwable, false, false);
        this.errorDesc = message;
        this.errorCode = errorCode;
        this.errorLevel = errorLevel;
        this.timestamp = timestamp;
    }
}
