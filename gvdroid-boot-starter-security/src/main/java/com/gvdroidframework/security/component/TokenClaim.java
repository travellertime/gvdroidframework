package com.gvdroidframework.security.component;

public class TokenClaim {

    private TokenClaim(Builder builder) {
        this.userId = builder.userId;
        this.channelId = builder.channelId;
        this.entityId = builder.entityId;
        this.roles = builder.roles;
        this.privileges = builder.privileges;
        this.expiresIn = builder.expiresIn;
    }

    /**
     * 用户编号
     */
    private String userId;
    /**
     * 渠道编号
     */
    private String channelId;
    /**
     * 实体编号
     */
    private String entityId;
    /**
     * 角色，多个角色用逗号分隔
     */
    private String roles;
    /**
     * 权限，多个权限用逗号分隔
     */
    private String privileges;
    /**
     * 多长时间后过期（秒）
     */
    private int expiresIn;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
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

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String userId;
        private String channelId;
        private String entityId;
        private String roles;
        private String privileges;
        private int expiresIn;

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder channelId(String channelId) {
            this.channelId = channelId;
            return this;
        }

        public Builder entityId(String entityId) {
            this.entityId = entityId;
            return this;
        }

        public Builder roles(String roles) {
            this.roles = roles;
            return this;
        }

        public Builder privileges(String privileges) {
            this.privileges = privileges;
            return this;
        }

        public Builder expiresIn(int expiresIn) {
            this.expiresIn = expiresIn;
            return this;
        }

        public TokenClaim build() {
            return new TokenClaim(this);
        }
    }
}
