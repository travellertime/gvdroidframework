package com.gvdroidframework.base.component;

import java.io.Serializable;
import java.time.Instant;

public class Context implements Serializable {

    /**
     * 实体编号，填入对方给定的编号，每个接口都需要填入该字段。（必填）
     */
    private String entityId;

    /**
     * 渠道编号，填入系统缩写名称，如果是前端则填入mobile, mini, h5, pc等等。（必填）
     */
    private String channel;

    /**
     * 服务编号。（不填）
     */
    private String serviceId;

    /**
     * 调用方本地时间 --年月日时分秒。（前端不填，后端可选）
     */
    private String localDateTime;

    /**
     * 交易机构编号。（可选）
     */
    private String orgId;

    /**
     * 用户编号。（当用户登陆后必填）。
     */
    private String userId;

    /**
     * 角色
     */
    private String roles;

    /**
     * 权限
     */
    private String privileges;

    /**
     * 外部流水号。（前端必填，后台不填）
     */
    private String txnReferenceNo;

    /**
     * 内部流水号。（前端必填，与内部流水号相同，后台必填，系统根据流水号规则自动生成。）
     */
    private String userReferenceNo;

    /**
     * 终端设备的唯一Id。（前端必填）
     */
    private String deviceId;

    /**
     * 本地语言，用于多语言控制。（非必填）
     */
    private String locale;

    /**
     * 访问令牌。（登陆后必填）
     */
    private String token;

    /**
     * IP地址。（除PC外必填）
     */
    private String ip;

    /**
     * LBS。
     */
    private String lbs;

    /**
     * 回调主键编号，用户找寻业务信息。（需要回调时必填）
     */
    private String callbackId;

    /**
     * 回调地址，提供给调用方，待对方处理完后回调的地址。（需要回调时必填）
     */
    private String callBackUrl;

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(String localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }

    public String getTxnReferenceNo() {
        return txnReferenceNo;
    }

    public void setTxnReferenceNo(String txnReferenceNo) {
        this.txnReferenceNo = txnReferenceNo;
    }

    public String getUserReferenceNo() {
        return userReferenceNo;
    }

    public void setUserReferenceNo(String userReferenceNo) {
        this.userReferenceNo = userReferenceNo;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLbs() {
        return lbs;
    }

    public void setLbs(String lbs) {
        this.lbs = lbs;
    }

    public String getCallbackId() {
        return callbackId;
    }

    public void setCallbackId(String callbackId) {
        this.callbackId = callbackId;
    }

    public String getCallBackUrl() {
        return callBackUrl;
    }

    public void setCallBackUrl(String callBackUrl) {
        this.callBackUrl = callBackUrl;
    }
}
