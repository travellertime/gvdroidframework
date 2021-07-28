package com.gvdroidframework.base.component;

import java.io.Serializable;
import java.util.Date;


public class BaseEntity implements Serializable {

    /**
     * 状态
     */
    int status;

    /**
     * 创建时间
     */
    Date createAt;

    /**
     * 创建人
     */
    String createBy;

    /**
     * 修改时间
     */
    Date updateAt;

    /**
     * 实体编号
     */
    String entityId;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }
}
