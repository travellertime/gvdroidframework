/*
 * This file is generated by jOOQ.
 */
package com.gvdroid.simple.jooq.code.sms.tables;


import com.gvdroid.simple.jooq.code.sms.Keys;
import com.gvdroid.simple.jooq.code.sms.Sms;
import com.gvdroid.simple.jooq.code.sms.tables.records.SmsUserGroupXrefRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row14;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * 权限-用户用户组关联表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SmsUserGroupXref extends TableImpl<SmsUserGroupXrefRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>sms.sms_user_group_xref</code>
     */
    public static final SmsUserGroupXref SMS_USER_GROUP_XREF = new SmsUserGroupXref();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SmsUserGroupXrefRecord> getRecordType() {
        return SmsUserGroupXrefRecord.class;
    }

    /**
     * The column <code>sms.sms_user_group_xref.id</code>. 主键
     */
    public final TableField<SmsUserGroupXrefRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false), this, "主键");

    /**
     * The column <code>sms.sms_user_group_xref.userId</code>. 用户编号
     */
    public final TableField<SmsUserGroupXrefRecord, Long> USERID = createField(DSL.name("userId"), SQLDataType.BIGINT.nullable(false), this, "用户编号");

    /**
     * The column <code>sms.sms_user_group_xref.groupId</code>. 用户组编号
     */
    public final TableField<SmsUserGroupXrefRecord, Long> GROUPID = createField(DSL.name("groupId"), SQLDataType.BIGINT.nullable(false), this, "用户组编号");

    /**
     * The column <code>sms.sms_user_group_xref.defaulted</code>. 默认所属机构 0 非所属机构 1 所属机构
     */
    public final TableField<SmsUserGroupXrefRecord, Boolean> DEFAULTED = createField(DSL.name("defaulted"), SQLDataType.BIT, this, "默认所属机构 0 非所属机构 1 所属机构");

    /**
     * The column <code>sms.sms_user_group_xref.status</code>. 状态 1 normal
     */
    public final TableField<SmsUserGroupXrefRecord, Integer> STATUS = createField(DSL.name("status"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.inline("1", SQLDataType.INTEGER)), this, "状态 1 normal");

    /**
     * The column <code>sms.sms_user_group_xref.deleted</code>. 删除状态 0 正常 1 逻辑删除
     */
    public final TableField<SmsUserGroupXrefRecord, Boolean> DELETED = createField(DSL.name("deleted"), SQLDataType.BIT.nullable(false).defaultValue(DSL.inline("b'0'", SQLDataType.BIT)), this, "删除状态 0 正常 1 逻辑删除");

    /**
     * The column <code>sms.sms_user_group_xref.createDate</code>. 创建时间
     */
    public final TableField<SmsUserGroupXrefRecord, LocalDateTime> CREATEDATE = createField(DSL.name("createDate"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "创建时间");

    /**
     * The column <code>sms.sms_user_group_xref.createUser</code>. 创建人员
     */
    public final TableField<SmsUserGroupXrefRecord, String> CREATEUSER = createField(DSL.name("createUser"), SQLDataType.VARCHAR(32).nullable(false), this, "创建人员");

    /**
     * The column <code>sms.sms_user_group_xref.createOrg</code>. 创建机构
     */
    public final TableField<SmsUserGroupXrefRecord, String> CREATEORG = createField(DSL.name("createOrg"), SQLDataType.VARCHAR(32).nullable(false), this, "创建机构");

    /**
     * The column <code>sms.sms_user_group_xref.updateDate</code>. 维护时间
     */
    public final TableField<SmsUserGroupXrefRecord, LocalDateTime> UPDATEDATE = createField(DSL.name("updateDate"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "维护时间");

    /**
     * The column <code>sms.sms_user_group_xref.updateUser</code>. 维护人员
     */
    public final TableField<SmsUserGroupXrefRecord, String> UPDATEUSER = createField(DSL.name("updateUser"), SQLDataType.VARCHAR(32).nullable(false), this, "维护人员");

    /**
     * The column <code>sms.sms_user_group_xref.updateOrg</code>. 维护机构
     */
    public final TableField<SmsUserGroupXrefRecord, String> UPDATEORG = createField(DSL.name("updateOrg"), SQLDataType.VARCHAR(32).nullable(false), this, "维护机构");

    /**
     * The column <code>sms.sms_user_group_xref.updateNo</code>. 维护序号
     */
    public final TableField<SmsUserGroupXrefRecord, Integer> UPDATENO = createField(DSL.name("updateNo"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.inline("0", SQLDataType.INTEGER)), this, "维护序号");

    /**
     * The column <code>sms.sms_user_group_xref.entityId</code>. 所属实体
     */
    public final TableField<SmsUserGroupXrefRecord, String> ENTITYID = createField(DSL.name("entityId"), SQLDataType.VARCHAR(32).nullable(false), this, "所属实体");

    private SmsUserGroupXref(Name alias, Table<SmsUserGroupXrefRecord> aliased) {
        this(alias, aliased, null);
    }

    private SmsUserGroupXref(Name alias, Table<SmsUserGroupXrefRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("权限-用户用户组关联表"), TableOptions.table());
    }

    /**
     * Create an aliased <code>sms.sms_user_group_xref</code> table reference
     */
    public SmsUserGroupXref(String alias) {
        this(DSL.name(alias), SMS_USER_GROUP_XREF);
    }

    /**
     * Create an aliased <code>sms.sms_user_group_xref</code> table reference
     */
    public SmsUserGroupXref(Name alias) {
        this(alias, SMS_USER_GROUP_XREF);
    }

    /**
     * Create a <code>sms.sms_user_group_xref</code> table reference
     */
    public SmsUserGroupXref() {
        this(DSL.name("sms_user_group_xref"), null);
    }

    public <O extends Record> SmsUserGroupXref(Table<O> child, ForeignKey<O, SmsUserGroupXrefRecord> key) {
        super(child, key, SMS_USER_GROUP_XREF);
    }

    @Override
    public Schema getSchema() {
        return Sms.SMS;
    }

    @Override
    public UniqueKey<SmsUserGroupXrefRecord> getPrimaryKey() {
        return Keys.KEY_SMS_USER_GROUP_XREF_PRIMARY;
    }

    @Override
    public List<UniqueKey<SmsUserGroupXrefRecord>> getKeys() {
        return Arrays.<UniqueKey<SmsUserGroupXrefRecord>>asList(Keys.KEY_SMS_USER_GROUP_XREF_PRIMARY, Keys.KEY_SMS_USER_GROUP_XREF_IN_SMS_USER_ORG_XREF_1);
    }

    @Override
    public SmsUserGroupXref as(String alias) {
        return new SmsUserGroupXref(DSL.name(alias), this);
    }

    @Override
    public SmsUserGroupXref as(Name alias) {
        return new SmsUserGroupXref(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SmsUserGroupXref rename(String name) {
        return new SmsUserGroupXref(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SmsUserGroupXref rename(Name name) {
        return new SmsUserGroupXref(name, null);
    }

    // -------------------------------------------------------------------------
    // Row14 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row14<Long, Long, Long, Boolean, Integer, Boolean, LocalDateTime, String, String, LocalDateTime, String, String, Integer, String> fieldsRow() {
        return (Row14) super.fieldsRow();
    }
}