package com.gvdroidframework.base.component;

import java.io.Serializable;
import java.util.Date;


public class BaseEntity implements Serializable {

    /**
     * 状态
     */
    Integer status;

    /**
     * 创建时间
     */
    Date createAt;

    /**
     * 创建人
     */
    String createBy;

    /**
     * 创建人所属机构
     */
    String createOrg;

    /**
     * 修改时间
     */
    Date updateAt;

    /**
     * 实体编号
     */
    String entityId;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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

    public String getCreateOrg() {
        return createOrg;
    }

    public void setCreateOrg(String createOrg) {
        this.createOrg = createOrg;
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
