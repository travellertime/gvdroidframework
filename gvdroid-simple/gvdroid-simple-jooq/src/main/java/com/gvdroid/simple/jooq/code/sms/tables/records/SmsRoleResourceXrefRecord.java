/*
 * This file is generated by jOOQ.
 */
package com.gvdroid.simple.jooq.code.sms.tables.records;


import com.gvdroid.simple.jooq.code.sms.tables.SmsRoleResourceXref;
import com.gvdroid.simple.jooq.code.sms.tables.interfaces.ISmsRoleResourceXref;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record13;
import org.jooq.Row13;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 权限-角色资源关联表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SmsRoleResourceXrefRecord extends UpdatableRecordImpl<SmsRoleResourceXrefRecord> implements Record13<Long, Long, Long, Integer, Boolean, LocalDateTime, String, String, LocalDateTime, String, String, Integer, String>, ISmsRoleResourceXref {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>sms.sms_role_resource_xref.id</code>. 主键
     */
    @Override
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>sms.sms_role_resource_xref.id</code>. 主键
     */
    @Override
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>sms.sms_role_resource_xref.roleId</code>. 角色编号
     */
    @Override
    public void setRoleid(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>sms.sms_role_resource_xref.roleId</code>. 角色编号
     */
    @Override
    public Long getRoleid() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>sms.sms_role_resource_xref.resourceId</code>. 资源编号
     */
    @Override
    public void setResourceid(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>sms.sms_role_resource_xref.resourceId</code>. 资源编号
     */
    @Override
    public Long getResourceid() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>sms.sms_role_resource_xref.status</code>. 状态 1 normal
     */
    @Override
    public void setStatus(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>sms.sms_role_resource_xref.status</code>. 状态 1 normal
     */
    @Override
    public Integer getStatus() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>sms.sms_role_resource_xref.deleted</code>. 删除状态 0 正常 1 逻辑删除
     */
    @Override
    public void setDeleted(Boolean value) {
        set(4, value);
    }

    /**
     * Getter for <code>sms.sms_role_resource_xref.deleted</code>. 删除状态 0 正常 1 逻辑删除
     */
    @Override
    public Boolean getDeleted() {
        return (Boolean) get(4);
    }

    /**
     * Setter for <code>sms.sms_role_resource_xref.createDate</code>. 创建时间
     */
    @Override
    public void setCreatedate(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>sms.sms_role_resource_xref.createDate</code>. 创建时间
     */
    @Override
    public LocalDateTime getCreatedate() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>sms.sms_role_resource_xref.createUser</code>. 创建人员
     */
    @Override
    public void setCreateuser(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>sms.sms_role_resource_xref.createUser</code>. 创建人员
     */
    @Override
    public String getCreateuser() {
        return (String) get(6);
    }

    /**
     * Setter for <code>sms.sms_role_resource_xref.createOrg</code>. 创建机构
     */
    @Override
    public void setCreateorg(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>sms.sms_role_resource_xref.createOrg</code>. 创建机构
     */
    @Override
    public String getCreateorg() {
        return (String) get(7);
    }

    /**
     * Setter for <code>sms.sms_role_resource_xref.updateDate</code>. 维护时间
     */
    @Override
    public void setUpdatedate(LocalDateTime value) {
        set(8, value);
    }

    /**
     * Getter for <code>sms.sms_role_resource_xref.updateDate</code>. 维护时间
     */
    @Override
    public LocalDateTime getUpdatedate() {
        return (LocalDateTime) get(8);
    }

    /**
     * Setter for <code>sms.sms_role_resource_xref.updateUser</code>. 维护人员
     */
    @Override
    public void setUpdateuser(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>sms.sms_role_resource_xref.updateUser</code>. 维护人员
     */
    @Override
    public String getUpdateuser() {
        return (String) get(9);
    }

    /**
     * Setter for <code>sms.sms_role_resource_xref.updateOrg</code>. 维护机构
     */
    @Override
    public void setUpdateorg(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>sms.sms_role_resource_xref.updateOrg</code>. 维护机构
     */
    @Override
    public String getUpdateorg() {
        return (String) get(10);
    }

    /**
     * Setter for <code>sms.sms_role_resource_xref.updateNo</code>. 维护序号
     */
    @Override
    public void setUpdateno(Integer value) {
        set(11, value);
    }

    /**
     * Getter for <code>sms.sms_role_resource_xref.updateNo</code>. 维护序号
     */
    @Override
    public Integer getUpdateno() {
        return (Integer) get(11);
    }

    /**
     * Setter for <code>sms.sms_role_resource_xref.entity_id</code>. 所属实体
     */
    @Override
    public void setEntityId(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>sms.sms_role_resource_xref.entity_id</code>. 所属实体
     */
    @Override
    public String getEntityId() {
        return (String) get(12);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record13 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row13<Long, Long, Long, Integer, Boolean, LocalDateTime, String, String, LocalDateTime, String, String, Integer, String> fieldsRow() {
        return (Row13) super.fieldsRow();
    }

    @Override
    public Row13<Long, Long, Long, Integer, Boolean, LocalDateTime, String, String, LocalDateTime, String, String, Integer, String> valuesRow() {
        return (Row13) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return SmsRoleResourceXref.SMS_ROLE_RESOURCE_XREF.ID;
    }

    @Override
    public Field<Long> field2() {
        return SmsRoleResourceXref.SMS_ROLE_RESOURCE_XREF.ROLEID;
    }

    @Override
    public Field<Long> field3() {
        return SmsRoleResourceXref.SMS_ROLE_RESOURCE_XREF.RESOURCEID;
    }

    @Override
    public Field<Integer> field4() {
        return SmsRoleResourceXref.SMS_ROLE_RESOURCE_XREF.STATUS;
    }

    @Override
    public Field<Boolean> field5() {
        return SmsRoleResourceXref.SMS_ROLE_RESOURCE_XREF.DELETED;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return SmsRoleResourceXref.SMS_ROLE_RESOURCE_XREF.CREATEDATE;
    }

    @Override
    public Field<String> field7() {
        return SmsRoleResourceXref.SMS_ROLE_RESOURCE_XREF.CREATEUSER;
    }

    @Override
    public Field<String> field8() {
        return SmsRoleResourceXref.SMS_ROLE_RESOURCE_XREF.CREATEORG;
    }

    @Override
    public Field<LocalDateTime> field9() {
        return SmsRoleResourceXref.SMS_ROLE_RESOURCE_XREF.UPDATEDATE;
    }

    @Override
    public Field<String> field10() {
        return SmsRoleResourceXref.SMS_ROLE_RESOURCE_XREF.UPDATEUSER;
    }

    @Override
    public Field<String> field11() {
        return SmsRoleResourceXref.SMS_ROLE_RESOURCE_XREF.UPDATEORG;
    }

    @Override
    public Field<Integer> field12() {
        return SmsRoleResourceXref.SMS_ROLE_RESOURCE_XREF.UPDATENO;
    }

    @Override
    public Field<String> field13() {
        return SmsRoleResourceXref.SMS_ROLE_RESOURCE_XREF.ENTITY_ID;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getRoleid();
    }

    @Override
    public Long component3() {
        return getResourceid();
    }

    @Override
    public Integer component4() {
        return getStatus();
    }

    @Override
    public Boolean component5() {
        return getDeleted();
    }

    @Override
    public LocalDateTime component6() {
        return getCreatedate();
    }

    @Override
    public String component7() {
        return getCreateuser();
    }

    @Override
    public String component8() {
        return getCreateorg();
    }

    @Override
    public LocalDateTime component9() {
        return getUpdatedate();
    }

    @Override
    public String component10() {
        return getUpdateuser();
    }

    @Override
    public String component11() {
        return getUpdateorg();
    }

    @Override
    public Integer component12() {
        return getUpdateno();
    }

    @Override
    public String component13() {
        return getEntityId();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getRoleid();
    }

    @Override
    public Long value3() {
        return getResourceid();
    }

    @Override
    public Integer value4() {
        return getStatus();
    }

    @Override
    public Boolean value5() {
        return getDeleted();
    }

    @Override
    public LocalDateTime value6() {
        return getCreatedate();
    }

    @Override
    public String value7() {
        return getCreateuser();
    }

    @Override
    public String value8() {
        return getCreateorg();
    }

    @Override
    public LocalDateTime value9() {
        return getUpdatedate();
    }

    @Override
    public String value10() {
        return getUpdateuser();
    }

    @Override
    public String value11() {
        return getUpdateorg();
    }

    @Override
    public Integer value12() {
        return getUpdateno();
    }

    @Override
    public String value13() {
        return getEntityId();
    }

    @Override
    public SmsRoleResourceXrefRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public SmsRoleResourceXrefRecord value2(Long value) {
        setRoleid(value);
        return this;
    }

    @Override
    public SmsRoleResourceXrefRecord value3(Long value) {
        setResourceid(value);
        return this;
    }

    @Override
    public SmsRoleResourceXrefRecord value4(Integer value) {
        setStatus(value);
        return this;
    }

    @Override
    public SmsRoleResourceXrefRecord value5(Boolean value) {
        setDeleted(value);
        return this;
    }

    @Override
    public SmsRoleResourceXrefRecord value6(LocalDateTime value) {
        setCreatedate(value);
        return this;
    }

    @Override
    public SmsRoleResourceXrefRecord value7(String value) {
        setCreateuser(value);
        return this;
    }

    @Override
    public SmsRoleResourceXrefRecord value8(String value) {
        setCreateorg(value);
        return this;
    }

    @Override
    public SmsRoleResourceXrefRecord value9(LocalDateTime value) {
        setUpdatedate(value);
        return this;
    }

    @Override
    public SmsRoleResourceXrefRecord value10(String value) {
        setUpdateuser(value);
        return this;
    }

    @Override
    public SmsRoleResourceXrefRecord value11(String value) {
        setUpdateorg(value);
        return this;
    }

    @Override
    public SmsRoleResourceXrefRecord value12(Integer value) {
        setUpdateno(value);
        return this;
    }

    @Override
    public SmsRoleResourceXrefRecord value13(String value) {
        setEntityId(value);
        return this;
    }

    @Override
    public SmsRoleResourceXrefRecord values(Long value1, Long value2, Long value3, Integer value4, Boolean value5, LocalDateTime value6, String value7, String value8, LocalDateTime value9, String value10, String value11, Integer value12, String value13) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(ISmsRoleResourceXref from) {
        setId(from.getId());
        setRoleid(from.getRoleid());
        setResourceid(from.getResourceid());
        setStatus(from.getStatus());
        setDeleted(from.getDeleted());
        setCreatedate(from.getCreatedate());
        setCreateuser(from.getCreateuser());
        setCreateorg(from.getCreateorg());
        setUpdatedate(from.getUpdatedate());
        setUpdateuser(from.getUpdateuser());
        setUpdateorg(from.getUpdateorg());
        setUpdateno(from.getUpdateno());
        setEntityId(from.getEntityId());
    }

    @Override
    public <E extends ISmsRoleResourceXref> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SmsRoleResourceXrefRecord
     */
    public SmsRoleResourceXrefRecord() {
        super(SmsRoleResourceXref.SMS_ROLE_RESOURCE_XREF);
    }

    /**
     * Create a detached, initialised SmsRoleResourceXrefRecord
     */
    public SmsRoleResourceXrefRecord(Long id, Long roleid, Long resourceid, Integer status, Boolean deleted, LocalDateTime createdate, String createuser, String createorg, LocalDateTime updatedate, String updateuser, String updateorg, Integer updateno, String entityId) {
        super(SmsRoleResourceXref.SMS_ROLE_RESOURCE_XREF);

        setId(id);
        setRoleid(roleid);
        setResourceid(resourceid);
        setStatus(status);
        setDeleted(deleted);
        setCreatedate(createdate);
        setCreateuser(createuser);
        setCreateorg(createorg);
        setUpdatedate(updatedate);
        setUpdateuser(updateuser);
        setUpdateorg(updateorg);
        setUpdateno(updateno);
        setEntityId(entityId);
    }
}
