/*
 * This file is generated by jOOQ.
 */
package com.gvdroid.simple.jooq.code.sms.tables;


import com.gvdroid.simple.jooq.code.sms.Keys;
import com.gvdroid.simple.jooq.code.sms.Sms;
import com.gvdroid.simple.jooq.code.sms.tables.records.SmsUserRoleXrefRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row13;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * 权限-用户角色关联表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SmsUserRoleXref extends TableImpl<SmsUserRoleXrefRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>sms.sms_user_role_xref</code>
     */
    public static final SmsUserRoleXref SMS_USER_ROLE_XREF = new SmsUserRoleXref();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SmsUserRoleXrefRecord> getRecordType() {
        return SmsUserRoleXrefRecord.class;
    }

    /**
     * The column <code>sms.sms_user_role_xref.id</code>. 主键
     */
    public final TableField<SmsUserRoleXrefRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false), this, "主键");

    /**
     * The column <code>sms.sms_user_role_xref.roleId</code>. 角色编号
     */
    public final TableField<SmsUserRoleXrefRecord, Long> ROLEID = createField(DSL.name("roleId"), SQLDataType.BIGINT.nullable(false), this, "角色编号");

    /**
     * The column <code>sms.sms_user_role_xref.userId</code>. 用户编号
     */
    public final TableField<SmsUserRoleXrefRecord, Long> USERID = createField(DSL.name("userId"), SQLDataType.BIGINT.nullable(false), this, "用户编号");

    /**
     * The column <code>sms.sms_user_role_xref.status</code>. 状态 1 normal
     */
    public final TableField<SmsUserRoleXrefRecord, Integer> STATUS = createField(DSL.name("status"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.inline("1", SQLDataType.INTEGER)), this, "状态 1 normal");

    /**
     * The column <code>sms.sms_user_role_xref.deleted</code>. 删除状态 0 正常 1 逻辑删除
     */
    public final TableField<SmsUserRoleXrefRecord, Boolean> DELETED = createField(DSL.name("deleted"), SQLDataType.BIT.nullable(false).defaultValue(DSL.inline("b'0'", SQLDataType.BIT)), this, "删除状态 0 正常 1 逻辑删除");

    /**
     * The column <code>sms.sms_user_role_xref.createDate</code>. 创建时间
     */
    public final TableField<SmsUserRoleXrefRecord, LocalDateTime> CREATEDATE = createField(DSL.name("createDate"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "创建时间");

    /**
     * The column <code>sms.sms_user_role_xref.createUser</code>. 创建人员
     */
    public final TableField<SmsUserRoleXrefRecord, String> CREATEUSER = createField(DSL.name("createUser"), SQLDataType.VARCHAR(32).nullable(false), this, "创建人员");

    /**
     * The column <code>sms.sms_user_role_xref.createOrg</code>. 创建机构
     */
    public final TableField<SmsUserRoleXrefRecord, String> CREATEORG = createField(DSL.name("createOrg"), SQLDataType.VARCHAR(32).nullable(false), this, "创建机构");

    /**
     * The column <code>sms.sms_user_role_xref.updateDate</code>. 维护时间
     */
    public final TableField<SmsUserRoleXrefRecord, LocalDateTime> UPDATEDATE = createField(DSL.name("updateDate"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "维护时间");

    /**
     * The column <code>sms.sms_user_role_xref.updateUser</code>. 维护人员
     */
    public final TableField<SmsUserRoleXrefRecord, String> UPDATEUSER = createField(DSL.name("updateUser"), SQLDataType.VARCHAR(32).nullable(false), this, "维护人员");

    /**
     * The column <code>sms.sms_user_role_xref.updateOrg</code>. 维护机构
     */
    public final TableField<SmsUserRoleXrefRecord, String> UPDATEORG = createField(DSL.name("updateOrg"), SQLDataType.VARCHAR(32).nullable(false), this, "维护机构");

    /**
     * The column <code>sms.sms_user_role_xref.updateNo</code>. 维护序号
     */
    public final TableField<SmsUserRoleXrefRecord, Integer> UPDATENO = createField(DSL.name("updateNo"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.inline("0", SQLDataType.INTEGER)), this, "维护序号");

    /**
     * The column <code>sms.sms_user_role_xref.entityId</code>. 所属实体
     */
    public final TableField<SmsUserRoleXrefRecord, String> ENTITYID = createField(DSL.name("entityId"), SQLDataType.VARCHAR(32).nullable(false), this, "所属实体");

    private SmsUserRoleXref(Name alias, Table<SmsUserRoleXrefRecord> aliased) {
        this(alias, aliased, null);
    }

    private SmsUserRoleXref(Name alias, Table<SmsUserRoleXrefRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("权限-用户角色关联表"), TableOptions.table());
    }

    /**
     * Create an aliased <code>sms.sms_user_role_xref</code> table reference
     */
    public SmsUserRoleXref(String alias) {
        this(DSL.name(alias), SMS_USER_ROLE_XREF);
    }

    /**
     * Create an aliased <code>sms.sms_user_role_xref</code> table reference
     */
    public SmsUserRoleXref(Name alias) {
        this(alias, SMS_USER_ROLE_XREF);
    }

    /**
     * Create a <code>sms.sms_user_role_xref</code> table reference
     */
    public SmsUserRoleXref() {
        this(DSL.name("sms_user_role_xref"), null);
    }

    public <O extends Record> SmsUserRoleXref(Table<O> child, ForeignKey<O, SmsUserRoleXrefRecord> key) {
        super(child, key, SMS_USER_ROLE_XREF);
    }

    @Override
    public Schema getSchema() {
        return Sms.SMS;
    }

    @Override
    public UniqueKey<SmsUserRoleXrefRecord> getPrimaryKey() {
        return Keys.KEY_SMS_USER_ROLE_XREF_PRIMARY;
    }

    @Override
    public List<UniqueKey<SmsUserRoleXrefRecord>> getKeys() {
        return Arrays.<UniqueKey<SmsUserRoleXrefRecord>>asList(Keys.KEY_SMS_USER_ROLE_XREF_PRIMARY, Keys.KEY_SMS_USER_ROLE_XREF_IN_SMS_USER_ROLE_XREF_1);
    }

    @Override
    public SmsUserRoleXref as(String alias) {
        return new SmsUserRoleXref(DSL.name(alias), this);
    }

    @Override
    public SmsUserRoleXref as(Name alias) {
        return new SmsUserRoleXref(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SmsUserRoleXref rename(String name) {
        return new SmsUserRoleXref(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SmsUserRoleXref rename(Name name) {
        return new SmsUserRoleXref(name, null);
    }

    // -------------------------------------------------------------------------
    // Row13 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row13<Long, Long, Long, Integer, Boolean, LocalDateTime, String, String, LocalDateTime, String, String, Integer, String> fieldsRow() {
        return (Row13) super.fieldsRow();
    }
}