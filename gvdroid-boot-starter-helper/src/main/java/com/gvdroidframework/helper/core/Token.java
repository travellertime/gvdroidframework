package com.gvdroidframework.helper.core;

public class Token {

    private String token;
    private long issueAt;
    private long expiresAt;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getIssueAt() {
        return issueAt;
    }

    public void setIssueAt(long issueAt) {
        this.issueAt = issueAt;
    }

    public long getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(long expiresAt) {
        this.expiresAt = expiresAt;
    }
}
