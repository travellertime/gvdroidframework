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
        super(message, null, false, false);
        this.errorDesc = message;
    }

    /**
     * @param message   String
     * @param errorCode String
     */
    public BaseException(String message, String errorCode) {
        super(message, null, false, false);
        this.errorDesc = message;
        this.errorCode = errorCode;
    }

    public BaseException(String message, String errorCode, String errorLevel, long timestamp) {
        super(message, null, false, false);
        this.errorDesc = message;
        this.errorCode = errorCode;
        this.errorLevel = errorLevel;
        this.timestamp = timestamp;
    }
}
