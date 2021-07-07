/*
 * This file is generated by jOOQ.
 */
package com.gvdroid.simple.jooq.code.sms.tables.daos;


import com.gvdroid.simple.jooq.code.sms.tables.SmsUserRoleXref;
import com.gvdroid.simple.jooq.code.sms.tables.records.SmsUserRoleXrefRecord;

import java.time.LocalDateTime;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * 权限-用户角色关联表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class SmsUserRoleXrefDao extends DAOImpl<SmsUserRoleXrefRecord, com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref, Long> {

    /**
     * Create a new SmsUserRoleXrefDao without any configuration
     */
    public SmsUserRoleXrefDao() {
        super(SmsUserRoleXref.SMS_USER_ROLE_XREF, com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref.class);
    }

    /**
     * Create a new SmsUserRoleXrefDao with an attached configuration
     */
    @Autowired
    public SmsUserRoleXrefDao(Configuration configuration) {
        super(SmsUserRoleXref.SMS_USER_ROLE_XREF, com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref.class, configuration);
    }

    @Override
    public Long getId(com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(SmsUserRoleXref.SMS_USER_ROLE_XREF.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref> fetchById(Long... values) {
        return fetch(SmsUserRoleXref.SMS_USER_ROLE_XREF.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref fetchOneById(Long value) {
        return fetchOne(SmsUserRoleXref.SMS_USER_ROLE_XREF.ID, value);
    }

    /**
     * Fetch records that have <code>roleId BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref> fetchRangeOfRoleid(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(SmsUserRoleXref.SMS_USER_ROLE_XREF.ROLEID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>roleId IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref> fetchByRoleid(Long... values) {
        return fetch(SmsUserRoleXref.SMS_USER_ROLE_XREF.ROLEID, values);
    }

    /**
     * Fetch records that have <code>userId BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref> fetchRangeOfUserid(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(SmsUserRoleXref.SMS_USER_ROLE_XREF.USERID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>userId IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref> fetchByUserid(Long... values) {
        return fetch(SmsUserRoleXref.SMS_USER_ROLE_XREF.USERID, values);
    }

    /**
     * Fetch records that have <code>status BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref> fetchRangeOfStatus(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(SmsUserRoleXref.SMS_USER_ROLE_XREF.STATUS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>status IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref> fetchByStatus(Integer... values) {
        return fetch(SmsUserRoleXref.SMS_USER_ROLE_XREF.STATUS, values);
    }

    /**
     * Fetch records that have <code>deleted BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref> fetchRangeOfDeleted(Boolean lowerInclusive, Boolean upperInclusive) {
        return fetchRange(SmsUserRoleXref.SMS_USER_ROLE_XREF.DELETED, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>deleted IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref> fetchByDeleted(Boolean... values) {
        return fetch(SmsUserRoleXref.SMS_USER_ROLE_XREF.DELETED, values);
    }

    /**
     * Fetch records that have <code>createDate BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref> fetchRangeOfCreatedate(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(SmsUserRoleXref.SMS_USER_ROLE_XREF.CREATEDATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>createDate IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref> fetchByCreatedate(LocalDateTime... values) {
        return fetch(SmsUserRoleXref.SMS_USER_ROLE_XREF.CREATEDATE, values);
    }

    /**
     * Fetch records that have <code>createUser BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref> fetchRangeOfCreateuser(String lowerInclusive, String upperInclusive) {
        return fetchRange(SmsUserRoleXref.SMS_USER_ROLE_XREF.CREATEUSER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>createUser IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref> fetchByCreateuser(String... values) {
        return fetch(SmsUserRoleXref.SMS_USER_ROLE_XREF.CREATEUSER, values);
    }

    /**
     * Fetch records that have <code>createOrg BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref> fetchRangeOfCreateorg(String lowerInclusive, String upperInclusive) {
        return fetchRange(SmsUserRoleXref.SMS_USER_ROLE_XREF.CREATEORG, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>createOrg IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref> fetchByCreateorg(String... values) {
        return fetch(SmsUserRoleXref.SMS_USER_ROLE_XREF.CREATEORG, values);
    }

    /**
     * Fetch records that have <code>updateDate BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref> fetchRangeOfUpdatedate(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(SmsUserRoleXref.SMS_USER_ROLE_XREF.UPDATEDATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>updateDate IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref> fetchByUpdatedate(LocalDateTime... values) {
        return fetch(SmsUserRoleXref.SMS_USER_ROLE_XREF.UPDATEDATE, values);
    }

    /**
     * Fetch records that have <code>updateUser BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref> fetchRangeOfUpdateuser(String lowerInclusive, String upperInclusive) {
        return fetchRange(SmsUserRoleXref.SMS_USER_ROLE_XREF.UPDATEUSER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>updateUser IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref> fetchByUpdateuser(String... values) {
        return fetch(SmsUserRoleXref.SMS_USER_ROLE_XREF.UPDATEUSER, values);
    }

    /**
     * Fetch records that have <code>updateOrg BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref> fetchRangeOfUpdateorg(String lowerInclusive, String upperInclusive) {
        return fetchRange(SmsUserRoleXref.SMS_USER_ROLE_XREF.UPDATEORG, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>updateOrg IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref> fetchByUpdateorg(String... values) {
        return fetch(SmsUserRoleXref.SMS_USER_ROLE_XREF.UPDATEORG, values);
    }

    /**
     * Fetch records that have <code>updateNo BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref> fetchRangeOfUpdateno(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(SmsUserRoleXref.SMS_USER_ROLE_XREF.UPDATENO, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>updateNo IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref> fetchByUpdateno(Integer... values) {
        return fetch(SmsUserRoleXref.SMS_USER_ROLE_XREF.UPDATENO, values);
    }

    /**
     * Fetch records that have <code>entityId BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref> fetchRangeOfEntityid(String lowerInclusive, String upperInclusive) {
        return fetchRange(SmsUserRoleXref.SMS_USER_ROLE_XREF.ENTITYID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>entityId IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserRoleXref> fetchByEntityid(String... values) {
        return fetch(SmsUserRoleXref.SMS_USER_ROLE_XREF.ENTITYID, values);
    }
}
