package com.gvdroidframework.base.component;

import com.gvdroidframework.base.constant.ErrorCode;

public class Status {

    private static String APPLICATION_NAME = null;

    public static void setDefaultApplicationName(String applicationName) {
        if (null == APPLICATION_NAME || null != applicationName) {
            APPLICATION_NAME = applicationName;
        } else {
            APPLICATION_NAME = "gvdroid-unknown-service";
        }
    }

    /**
     * 错误代码
     */
    private String errorCode;

    /**
     * 响应代码
     */
    private String replyCode;

    /**
     * 响应描述
     */
    private String replyText;

    /**
     * 备注
     */
    private String memo;

    /**
     * 应用名称
     */
    private String appName;

    /**
     * 耗时
     */
    private long duration;

    /**
     * 构造函数
     */
    public Status() {
        this.errorCode = ErrorCode.SUCCESS;
        this.appName = APPLICATION_NAME;
    }

    public Status(String replyText, String replyCode) {
        this.errorCode = ErrorCode.EXCEPTION;
        this.replyText = replyText;
        this.replyCode = replyCode;
        this.appName = APPLICATION_NAME;
    }

    /**
     * @param errorCode 错误代码
     * @param replyCode 响应代码
     * @param replyText 响应描述
     */
    public Status(String errorCode, String replyText, String replyCode) {
        this.errorCode = errorCode;
        this.replyText = replyText;
        this.replyCode = replyCode;
        this.appName = APPLICATION_NAME;
    }

    /**
     * @param errorCode 错误代码
     * @param replyCode 响应代码
     * @param replyText 响应描述
     * @param memo      备注
     */
    public Status(String errorCode, String replyText, String replyCode, String memo) {
        this.errorCode = errorCode;
        this.replyText = replyText;
        this.replyCode = replyCode;
        this.memo = memo;
        this.appName = APPLICATION_NAME;
    }

    /**
     * 设置执行状态错误信息
     * errorCode会默认设置为1, errorCode = 1代表自定义错误.
     *
     * @param replyCode 响应代码
     * @param replyText 响应描述
     */
    public void setError(String replyText, String replyCode) {
        this.errorCode = ErrorCode.FAILURE;
        this.replyCode = replyCode;
        this.replyText = replyText;
    }

    public void setError(String replyText, String replyCode, String errorCode) {
        this.errorCode = errorCode;
        this.replyCode = replyCode;
        this.replyText = replyText;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getReplyCode() {
        return replyCode;
    }

    public void setReplyCode(String replyCode) {
        this.replyCode = replyCode;
    }

    public String getReplyText() {
        return replyText;
    }

    public void setReplyText(String replyText) {
        this.replyText = replyText;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

}
