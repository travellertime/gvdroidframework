package com.gvdroidframework.logging.component;

import java.io.Serializable;
import java.time.Instant;

public class BusinessLoggingDTO implements Serializable, Cloneable {

    private static final long serialVersionUID = -2323370461240456563L;

    private long startTime;
    private long endTime;
    //    private long duration;
    private String serviceId;
    private String entityId;
    private String postingDate;
    private Instant localDate;
    private String channel;
    private String userId;
    private String orgId;
    private String requestDTO;
    private String responseDTO;
    private String refUserNo;
    private String refTxnNo;
    private String refOriginalNo;
    private String errorCode;
    private String ip;
    private String lbs;

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getDuration() {
        return (this.startTime != 0L && this.endTime != 0L) ? endTime - startTime : 0L;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(String postingDate) {
        this.postingDate = postingDate;
    }

    public Instant getLocalDate() {
        return localDate;
    }

    public void setLocalDate(Instant localDate) {
        this.localDate = localDate;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getRequestDTO() {
        return requestDTO;
    }

    public void setRequestDTO(String requestDTO) {
        this.requestDTO = requestDTO;
    }

    public String getResponseDTO() {
        return responseDTO;
    }

    public void setResponseDTO(String responseDTO) {
        this.responseDTO = responseDTO;
    }

    public String getRefUserNo() {
        return refUserNo;
    }

    public void setRefUserNo(String refUserNo) {
        this.refUserNo = refUserNo;
    }

    public String getRefTxnNo() {
        return refTxnNo;
    }

    public void setRefTxnNo(String refTxnNo) {
        this.refTxnNo = refTxnNo;
    }

    public String getRefOriginalNo() {
        return refOriginalNo;
    }

    public void setRefOriginalNo(String refOriginalNo) {
        this.refOriginalNo = refOriginalNo;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
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

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
