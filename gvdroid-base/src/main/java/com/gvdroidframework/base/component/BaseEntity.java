package com.gvdroidframework.base.component;

import java.io.Serializable;
import java.util.Date;


public class BaseEntity implements Serializable {

    /**
     * 状态
     */
    Integer status;

    /**
     * 逻辑删除
     */
    Boolean deleted;

    /**
     * 创建时间
     */
    Date createDate;

    /**
     * 创建人
     */
    String createUser;
//
//    /**
//     * 创建机构
//     */
//    String createOrg;

    /**
     * 修改时间
     */
    Date updateDate;

    /**
     * 修改人
     */
    String updateUser;
//
//    /**
//     * 修改机构
//     */
//    String updateOrg;

    /**
     * 修改编号
     */
    Integer updateNo;

//    /**
//     * 实体编号
//     */
//    String entityId;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }


    public Integer getUpdateNo() {
        return updateNo;
    }

    public void setUpdateNo(Integer updateNo) {
        this.updateNo = updateNo;
    }
}
