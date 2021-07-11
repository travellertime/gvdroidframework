/*
 * This file is generated by jOOQ.
 */
package com.gvdroid.simple.jooq.code.sms.tables;


import com.gvdroid.simple.jooq.code.sms.Keys;
import com.gvdroid.simple.jooq.code.sms.Sms;
import com.gvdroid.simple.jooq.code.sms.tables.records.SmsGroupMastRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row18;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * 权限-用户分组主表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SmsGroupMast extends TableImpl<SmsGroupMastRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>sms.sms_group_mast</code>
     */
    public static final SmsGroupMast SMS_GROUP_MAST = new SmsGroupMast();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SmsGroupMastRecord> getRecordType() {
        return SmsGroupMastRecord.class;
    }

    /**
     * The column <code>sms.sms_group_mast.groupId</code>. 主键(用户组编号)
     */
    public final TableField<SmsGroupMastRecord, Long> GROUPID = createField(DSL.name("groupId"), SQLDataType.BIGINT.nullable(false), this, "主键(用户组编号)");

    /**
     * The column <code>sms.sms_group_mast.name</code>. 用户组名称
     */
    public final TableField<SmsGroupMastRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(128).nullable(false), this, "用户组名称");

    /**
     * The column <code>sms.sms_group_mast.groupType</code>. 用户组类型 org/branch/dummy
     */
    public final TableField<SmsGroupMastRecord, String> GROUPTYPE = createField(DSL.name("groupType"), SQLDataType.VARCHAR(8).nullable(false), this, "用户组类型 org/branch/dummy");

    /**
     * The column <code>sms.sms_group_mast.treeLeaf</code>. 树形-是否叶子节点
     */
    public final TableField<SmsGroupMastRecord, String> TREELEAF = createField(DSL.name("treeLeaf"), SQLDataType.VARCHAR(2).nullable(false), this, "树形-是否叶子节点");

    /**
     * The column <code>sms.sms_group_mast.treeLevel</code>. 树形-级别
     */
    public final TableField<SmsGroupMastRecord, Short> TREELEVEL = createField(DSL.name("treeLevel"), SQLDataType.SMALLINT.nullable(false), this, "树形-级别");

    /**
     * The column <code>sms.sms_group_mast.treeParent</code>. 树形-父编号
     */
    public final TableField<SmsGroupMastRecord, String> TREEPARENT = createField(DSL.name("treeParent"), SQLDataType.VARCHAR(32).nullable(false), this, "树形-父编号");

    /**
     * The column <code>sms.sms_group_mast.treeSequence</code>. 树形-排序
     */
    public final TableField<SmsGroupMastRecord, String> TREESEQUENCE = createField(DSL.name("treeSequence"), SQLDataType.VARCHAR(512).nullable(false), this, "树形-排序");

    /**
     * The column <code>sms.sms_group_mast.adminId</code>. 管理员
     */
    public final TableField<SmsGroupMastRecord, String> ADMINID = createField(DSL.name("adminId"), SQLDataType.VARCHAR(32), this, "管理员");

    /**
     * The column <code>sms.sms_group_mast.status</code>. 状态 1 normal
     */
    public final TableField<SmsGroupMastRecord, Integer> STATUS = createField(DSL.name("status"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.inline("1", SQLDataType.INTEGER)), this, "状态 1 normal");

    /**
     * The column <code>sms.sms_group_mast.deleted</code>. 删除状态 0 正常 1 逻辑删除
     */
    public final TableField<SmsGroupMastRecord, Boolean> DELETED = createField(DSL.name("deleted"), SQLDataType.BIT.nullable(false).defaultValue(DSL.inline("b'0'", SQLDataType.BIT)), this, "删除状态 0 正常 1 逻辑删除");

    /**
     * The column <code>sms.sms_group_mast.createDate</code>. 创建时间
     */
    public final TableField<SmsGroupMastRecord, LocalDateTime> CREATEDATE = createField(DSL.name("createDate"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "创建时间");

    /**
     * The column <code>sms.sms_group_mast.createUser</code>. 创建人员
     */
    public final TableField<SmsGroupMastRecord, String> CREATEUSER = createField(DSL.name("createUser"), SQLDataType.VARCHAR(32).nullable(false), this, "创建人员");

    /**
     * The column <code>sms.sms_group_mast.createOrg</code>. 创建机构
     */
    public final TableField<SmsGroupMastRecord, String> CREATEORG = createField(DSL.name("createOrg"), SQLDataType.VARCHAR(32).nullable(false), this, "创建机构");

    /**
     * The column <code>sms.sms_group_mast.updateDate</code>. 维护时间
     */
    public final TableField<SmsGroupMastRecord, LocalDateTime> UPDATEDATE = createField(DSL.name("updateDate"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "维护时间");

    /**
     * The column <code>sms.sms_group_mast.updateUser</code>. 维护人员
     */
    public final TableField<SmsGroupMastRecord, String> UPDATEUSER = createField(DSL.name("updateUser"), SQLDataType.VARCHAR(32).nullable(false), this, "维护人员");

    /**
     * The column <code>sms.sms_group_mast.updateOrg</code>. 维护机构
     */
    public final TableField<SmsGroupMastRecord, String> UPDATEORG = createField(DSL.name("updateOrg"), SQLDataType.VARCHAR(32).nullable(false), this, "维护机构");

    /**
     * The column <code>sms.sms_group_mast.updateNo</code>. 维护序号
     */
    public final TableField<SmsGroupMastRecord, Integer> UPDATENO = createField(DSL.name("updateNo"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.inline("0", SQLDataType.INTEGER)), this, "维护序号");

    /**
     * The column <code>sms.sms_group_mast.entityId</code>. 所属实体
     */
    public final TableField<SmsGroupMastRecord, String> ENTITYID = createField(DSL.name("entityId"), SQLDataType.VARCHAR(32).nullable(false), this, "所属实体");

    private SmsGroupMast(Name alias, Table<SmsGroupMastRecord> aliased) {
        this(alias, aliased, null);
    }

    private SmsGroupMast(Name alias, Table<SmsGroupMastRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("权限-用户分组主表"), TableOptions.table());
    }

    /**
     * Create an aliased <code>sms.sms_group_mast</code> table reference
     */
    public SmsGroupMast(String alias) {
        this(DSL.name(alias), SMS_GROUP_MAST);
    }

    /**
     * Create an aliased <code>sms.sms_group_mast</code> table reference
     */
    public SmsGroupMast(Name alias) {
        this(alias, SMS_GROUP_MAST);
    }

    /**
     * Create a <code>sms.sms_group_mast</code> table reference
     */
    public SmsGroupMast() {
        this(DSL.name("sms_group_mast"), null);
    }

    public <O extends Record> SmsGroupMast(Table<O> child, ForeignKey<O, SmsGroupMastRecord> key) {
        super(child, key, SMS_GROUP_MAST);
    }

    @Override
    public Schema getSchema() {
        return Sms.SMS;
    }

    @Override
    public UniqueKey<SmsGroupMastRecord> getPrimaryKey() {
        return Keys.KEY_SMS_GROUP_MAST_PRIMARY;
    }

    @Override
    public List<UniqueKey<SmsGroupMastRecord>> getKeys() {
        return Arrays.<UniqueKey<SmsGroupMastRecord>>asList(Keys.KEY_SMS_GROUP_MAST_PRIMARY, Keys.KEY_SMS_GROUP_MAST_IN_SMS_ORG_MAST_1);
    }

    @Override
    public SmsGroupMast as(String alias) {
        return new SmsGroupMast(DSL.name(alias), this);
    }

    @Override
    public SmsGroupMast as(Name alias) {
        return new SmsGroupMast(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SmsGroupMast rename(String name) {
        return new SmsGroupMast(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SmsGroupMast rename(Name name) {
        return new SmsGroupMast(name, null);
    }

    // -------------------------------------------------------------------------
    // Row18 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row18<Long, String, String, String, Short, String, String, String, Integer, Boolean, LocalDateTime, String, String, LocalDateTime, String, String, Integer, String> fieldsRow() {
        return (Row18) super.fieldsRow();
    }
}