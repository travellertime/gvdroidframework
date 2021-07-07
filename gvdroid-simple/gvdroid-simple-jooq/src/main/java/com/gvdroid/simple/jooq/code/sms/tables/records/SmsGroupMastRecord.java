/*
 * This file is generated by jOOQ.
 */
package com.gvdroid.simple.jooq.code.sms.tables.records;


import com.gvdroid.simple.jooq.code.sms.tables.SmsGroupMast;
import com.gvdroid.simple.jooq.code.sms.tables.interfaces.ISmsGroupMast;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record18;
import org.jooq.Row18;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 权限-用户分组主表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SmsGroupMastRecord extends UpdatableRecordImpl<SmsGroupMastRecord> implements Record18<Long, String, String, String, Short, String, String, String, Integer, Boolean, LocalDateTime, String, String, LocalDateTime, String, String, Integer, String>, ISmsGroupMast {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>sms.sms_group_mast.groupId</code>. 主键(用户组编号)
     */
    @Override
    public void setGroupid(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>sms.sms_group_mast.groupId</code>. 主键(用户组编号)
     */
    @Override
    public Long getGroupid() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>sms.sms_group_mast.name</code>. 用户组名称
     */
    @Override
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>sms.sms_group_mast.name</code>. 用户组名称
     */
    @Override
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>sms.sms_group_mast.groupType</code>. 用户组类型 org/branch/dummy
     */
    @Override
    public void setGrouptype(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>sms.sms_group_mast.groupType</code>. 用户组类型 org/branch/dummy
     */
    @Override
    public String getGrouptype() {
        return (String) get(2);
    }

    /**
     * Setter for <code>sms.sms_group_mast.treeLeaf</code>. 树形-是否叶子节点
     */
    @Override
    public void setTreeleaf(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>sms.sms_group_mast.treeLeaf</code>. 树形-是否叶子节点
     */
    @Override
    public String getTreeleaf() {
        return (String) get(3);
    }

    /**
     * Setter for <code>sms.sms_group_mast.treeLevel</code>. 树形-级别
     */
    @Override
    public void setTreelevel(Short value) {
        set(4, value);
    }

    /**
     * Getter for <code>sms.sms_group_mast.treeLevel</code>. 树形-级别
     */
    @Override
    public Short getTreelevel() {
        return (Short) get(4);
    }

    /**
     * Setter for <code>sms.sms_group_mast.treeParent</code>. 树形-父编号
     */
    @Override
    public void setTreeparent(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>sms.sms_group_mast.treeParent</code>. 树形-父编号
     */
    @Override
    public String getTreeparent() {
        return (String) get(5);
    }

    /**
     * Setter for <code>sms.sms_group_mast.treeSequence</code>. 树形-排序
     */
    @Override
    public void setTreesequence(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>sms.sms_group_mast.treeSequence</code>. 树形-排序
     */
    @Override
    public String getTreesequence() {
        return (String) get(6);
    }

    /**
     * Setter for <code>sms.sms_group_mast.adminId</code>. 管理员
     */
    @Override
    public void setAdminid(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>sms.sms_group_mast.adminId</code>. 管理员
     */
    @Override
    public String getAdminid() {
        return (String) get(7);
    }

    /**
     * Setter for <code>sms.sms_group_mast.status</code>. 状态 1 normal
     */
    @Override
    public void setStatus(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>sms.sms_group_mast.status</code>. 状态 1 normal
     */
    @Override
    public Integer getStatus() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>sms.sms_group_mast.deleted</code>. 删除状态 0 正常 1 逻辑删除
     */
    @Override
    public void setDeleted(Boolean value) {
        set(9, value);
    }

    /**
     * Getter for <code>sms.sms_group_mast.deleted</code>. 删除状态 0 正常 1 逻辑删除
     */
    @Override
    public Boolean getDeleted() {
        return (Boolean) get(9);
    }

    /**
     * Setter for <code>sms.sms_group_mast.createDate</code>. 创建时间
     */
    @Override
    public void setCreatedate(LocalDateTime value) {
        set(10, value);
    }

    /**
     * Getter for <code>sms.sms_group_mast.createDate</code>. 创建时间
     */
    @Override
    public LocalDateTime getCreatedate() {
        return (LocalDateTime) get(10);
    }

    /**
     * Setter for <code>sms.sms_group_mast.createUser</code>. 创建人员
     */
    @Override
    public void setCreateuser(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>sms.sms_group_mast.createUser</code>. 创建人员
     */
    @Override
    public String getCreateuser() {
        return (String) get(11);
    }

    /**
     * Setter for <code>sms.sms_group_mast.createOrg</code>. 创建机构
     */
    @Override
    public void setCreateorg(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>sms.sms_group_mast.createOrg</code>. 创建机构
     */
    @Override
    public String getCreateorg() {
        return (String) get(12);
    }

    /**
     * Setter for <code>sms.sms_group_mast.updateDate</code>. 维护时间
     */
    @Override
    public void setUpdatedate(LocalDateTime value) {
        set(13, value);
    }

    /**
     * Getter for <code>sms.sms_group_mast.updateDate</code>. 维护时间
     */
    @Override
    public LocalDateTime getUpdatedate() {
        return (LocalDateTime) get(13);
    }

    /**
     * Setter for <code>sms.sms_group_mast.updateUser</code>. 维护人员
     */
    @Override
    public void setUpdateuser(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>sms.sms_group_mast.updateUser</code>. 维护人员
     */
    @Override
    public String getUpdateuser() {
        return (String) get(14);
    }

    /**
     * Setter for <code>sms.sms_group_mast.updateOrg</code>. 维护机构
     */
    @Override
    public void setUpdateorg(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>sms.sms_group_mast.updateOrg</code>. 维护机构
     */
    @Override
    public String getUpdateorg() {
        return (String) get(15);
    }

    /**
     * Setter for <code>sms.sms_group_mast.updateNo</code>. 维护序号
     */
    @Override
    public void setUpdateno(Integer value) {
        set(16, value);
    }

    /**
     * Getter for <code>sms.sms_group_mast.updateNo</code>. 维护序号
     */
    @Override
    public Integer getUpdateno() {
        return (Integer) get(16);
    }

    /**
     * Setter for <code>sms.sms_group_mast.entityId</code>. 所属实体
     */
    @Override
    public void setEntityid(String value) {
        set(17, value);
    }

    /**
     * Getter for <code>sms.sms_group_mast.entityId</code>. 所属实体
     */
    @Override
    public String getEntityid() {
        return (String) get(17);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record18 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row18<Long, String, String, String, Short, String, String, String, Integer, Boolean, LocalDateTime, String, String, LocalDateTime, String, String, Integer, String> fieldsRow() {
        return (Row18) super.fieldsRow();
    }

    @Override
    public Row18<Long, String, String, String, Short, String, String, String, Integer, Boolean, LocalDateTime, String, String, LocalDateTime, String, String, Integer, String> valuesRow() {
        return (Row18) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return SmsGroupMast.SMS_GROUP_MAST.GROUPID;
    }

    @Override
    public Field<String> field2() {
        return SmsGroupMast.SMS_GROUP_MAST.NAME;
    }

    @Override
    public Field<String> field3() {
        return SmsGroupMast.SMS_GROUP_MAST.GROUPTYPE;
    }

    @Override
    public Field<String> field4() {
        return SmsGroupMast.SMS_GROUP_MAST.TREELEAF;
    }

    @Override
    public Field<Short> field5() {
        return SmsGroupMast.SMS_GROUP_MAST.TREELEVEL;
    }

    @Override
    public Field<String> field6() {
        return SmsGroupMast.SMS_GROUP_MAST.TREEPARENT;
    }

    @Override
    public Field<String> field7() {
        return SmsGroupMast.SMS_GROUP_MAST.TREESEQUENCE;
    }

    @Override
    public Field<String> field8() {
        return SmsGroupMast.SMS_GROUP_MAST.ADMINID;
    }

    @Override
    public Field<Integer> field9() {
        return SmsGroupMast.SMS_GROUP_MAST.STATUS;
    }

    @Override
    public Field<Boolean> field10() {
        return SmsGroupMast.SMS_GROUP_MAST.DELETED;
    }

    @Override
    public Field<LocalDateTime> field11() {
        return SmsGroupMast.SMS_GROUP_MAST.CREATEDATE;
    }

    @Override
    public Field<String> field12() {
        return SmsGroupMast.SMS_GROUP_MAST.CREATEUSER;
    }

    @Override
    public Field<String> field13() {
        return SmsGroupMast.SMS_GROUP_MAST.CREATEORG;
    }

    @Override
    public Field<LocalDateTime> field14() {
        return SmsGroupMast.SMS_GROUP_MAST.UPDATEDATE;
    }

    @Override
    public Field<String> field15() {
        return SmsGroupMast.SMS_GROUP_MAST.UPDATEUSER;
    }

    @Override
    public Field<String> field16() {
        return SmsGroupMast.SMS_GROUP_MAST.UPDATEORG;
    }

    @Override
    public Field<Integer> field17() {
        return SmsGroupMast.SMS_GROUP_MAST.UPDATENO;
    }

    @Override
    public Field<String> field18() {
        return SmsGroupMast.SMS_GROUP_MAST.ENTITYID;
    }

    @Override
    public Long component1() {
        return getGroupid();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public String component3() {
        return getGrouptype();
    }

    @Override
    public String component4() {
        return getTreeleaf();
    }

    @Override
    public Short component5() {
        return getTreelevel();
    }

    @Override
    public String component6() {
        return getTreeparent();
    }

    @Override
    public String component7() {
        return getTreesequence();
    }

    @Override
    public String component8() {
        return getAdminid();
    }

    @Override
    public Integer component9() {
        return getStatus();
    }

    @Override
    public Boolean component10() {
        return getDeleted();
    }

    @Override
    public LocalDateTime component11() {
        return getCreatedate();
    }

    @Override
    public String component12() {
        return getCreateuser();
    }

    @Override
    public String component13() {
        return getCreateorg();
    }

    @Override
    public LocalDateTime component14() {
        return getUpdatedate();
    }

    @Override
    public String component15() {
        return getUpdateuser();
    }

    @Override
    public String component16() {
        return getUpdateorg();
    }

    @Override
    public Integer component17() {
        return getUpdateno();
    }

    @Override
    public String component18() {
        return getEntityid();
    }

    @Override
    public Long value1() {
        return getGroupid();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public String value3() {
        return getGrouptype();
    }

    @Override
    public String value4() {
        return getTreeleaf();
    }

    @Override
    public Short value5() {
        return getTreelevel();
    }

    @Override
    public String value6() {
        return getTreeparent();
    }

    @Override
    public String value7() {
        return getTreesequence();
    }

    @Override
    public String value8() {
        return getAdminid();
    }

    @Override
    public Integer value9() {
        return getStatus();
    }

    @Override
    public Boolean value10() {
        return getDeleted();
    }

    @Override
    public LocalDateTime value11() {
        return getCreatedate();
    }

    @Override
    public String value12() {
        return getCreateuser();
    }

    @Override
    public String value13() {
        return getCreateorg();
    }

    @Override
    public LocalDateTime value14() {
        return getUpdatedate();
    }

    @Override
    public String value15() {
        return getUpdateuser();
    }

    @Override
    public String value16() {
        return getUpdateorg();
    }

    @Override
    public Integer value17() {
        return getUpdateno();
    }

    @Override
    public String value18() {
        return getEntityid();
    }

    @Override
    public SmsGroupMastRecord value1(Long value) {
        setGroupid(value);
        return this;
    }

    @Override
    public SmsGroupMastRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public SmsGroupMastRecord value3(String value) {
        setGrouptype(value);
        return this;
    }

    @Override
    public SmsGroupMastRecord value4(String value) {
        setTreeleaf(value);
        return this;
    }

    @Override
    public SmsGroupMastRecord value5(Short value) {
        setTreelevel(value);
        return this;
    }

    @Override
    public SmsGroupMastRecord value6(String value) {
        setTreeparent(value);
        return this;
    }

    @Override
    public SmsGroupMastRecord value7(String value) {
        setTreesequence(value);
        return this;
    }

    @Override
    public SmsGroupMastRecord value8(String value) {
        setAdminid(value);
        return this;
    }

    @Override
    public SmsGroupMastRecord value9(Integer value) {
        setStatus(value);
        return this;
    }

    @Override
    public SmsGroupMastRecord value10(Boolean value) {
        setDeleted(value);
        return this;
    }

    @Override
    public SmsGroupMastRecord value11(LocalDateTime value) {
        setCreatedate(value);
        return this;
    }

    @Override
    public SmsGroupMastRecord value12(String value) {
        setCreateuser(value);
        return this;
    }

    @Override
    public SmsGroupMastRecord value13(String value) {
        setCreateorg(value);
        return this;
    }

    @Override
    public SmsGroupMastRecord value14(LocalDateTime value) {
        setUpdatedate(value);
        return this;
    }

    @Override
    public SmsGroupMastRecord value15(String value) {
        setUpdateuser(value);
        return this;
    }

    @Override
    public SmsGroupMastRecord value16(String value) {
        setUpdateorg(value);
        return this;
    }

    @Override
    public SmsGroupMastRecord value17(Integer value) {
        setUpdateno(value);
        return this;
    }

    @Override
    public SmsGroupMastRecord value18(String value) {
        setEntityid(value);
        return this;
    }

    @Override
    public SmsGroupMastRecord values(Long value1, String value2, String value3, String value4, Short value5, String value6, String value7, String value8, Integer value9, Boolean value10, LocalDateTime value11, String value12, String value13, LocalDateTime value14, String value15, String value16, Integer value17, String value18) {
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
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        value18(value18);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(ISmsGroupMast from) {
        setGroupid(from.getGroupid());
        setName(from.getName());
        setGrouptype(from.getGrouptype());
        setTreeleaf(from.getTreeleaf());
        setTreelevel(from.getTreelevel());
        setTreeparent(from.getTreeparent());
        setTreesequence(from.getTreesequence());
        setAdminid(from.getAdminid());
        setStatus(from.getStatus());
        setDeleted(from.getDeleted());
        setCreatedate(from.getCreatedate());
        setCreateuser(from.getCreateuser());
        setCreateorg(from.getCreateorg());
        setUpdatedate(from.getUpdatedate());
        setUpdateuser(from.getUpdateuser());
        setUpdateorg(from.getUpdateorg());
        setUpdateno(from.getUpdateno());
        setEntityid(from.getEntityid());
    }

    @Override
    public <E extends ISmsGroupMast> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SmsGroupMastRecord
     */
    public SmsGroupMastRecord() {
        super(SmsGroupMast.SMS_GROUP_MAST);
    }

    /**
     * Create a detached, initialised SmsGroupMastRecord
     */
    public SmsGroupMastRecord(Long groupid, String name, String grouptype, String treeleaf, Short treelevel, String treeparent, String treesequence, String adminid, Integer status, Boolean deleted, LocalDateTime createdate, String createuser, String createorg, LocalDateTime updatedate, String updateuser, String updateorg, Integer updateno, String entityid) {
        super(SmsGroupMast.SMS_GROUP_MAST);

        setGroupid(groupid);
        setName(name);
        setGrouptype(grouptype);
        setTreeleaf(treeleaf);
        setTreelevel(treelevel);
        setTreeparent(treeparent);
        setTreesequence(treesequence);
        setAdminid(adminid);
        setStatus(status);
        setDeleted(deleted);
        setCreatedate(createdate);
        setCreateuser(createuser);
        setCreateorg(createorg);
        setUpdatedate(updatedate);
        setUpdateuser(updateuser);
        setUpdateorg(updateorg);
        setUpdateno(updateno);
        setEntityid(entityid);
    }
}
