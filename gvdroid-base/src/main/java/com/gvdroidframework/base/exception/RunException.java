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
