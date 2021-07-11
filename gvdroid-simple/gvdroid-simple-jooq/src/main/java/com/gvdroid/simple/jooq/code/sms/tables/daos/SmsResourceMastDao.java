/*
 * This file is generated by jOOQ.
 */
package com.gvdroid.simple.jooq.code.sms.tables.daos;


import com.gvdroid.simple.jooq.code.sms.tables.SmsResourceMast;
import com.gvdroid.simple.jooq.code.sms.tables.records.SmsResourceMastRecord;

import java.time.LocalDateTime;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * 权限-权限主表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class SmsResourceMastDao extends DAOImpl<SmsResourceMastRecord, com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast, Long> {

    /**
     * Create a new SmsResourceMastDao without any configuration
     */
    public SmsResourceMastDao() {
        super(SmsResourceMast.SMS_RESOURCE_MAST, com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast.class);
    }

    /**
     * Create a new SmsResourceMastDao with an attached configuration
     */
    @Autowired
    public SmsResourceMastDao(Configuration configuration) {
        super(SmsResourceMast.SMS_RESOURCE_MAST, com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast.class, configuration);
    }

    @Override
    public Long getId(com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(SmsResourceMast.SMS_RESOURCE_MAST.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchById(Long... values) {
        return fetch(SmsResourceMast.SMS_RESOURCE_MAST.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast fetchOneById(Long value) {
        return fetchOne(SmsResourceMast.SMS_RESOURCE_MAST.ID, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(SmsResourceMast.SMS_RESOURCE_MAST.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchByName(String... values) {
        return fetch(SmsResourceMast.SMS_RESOURCE_MAST.NAME, values);
    }

    /**
     * Fetch records that have <code>resourceType BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchRangeOfResourcetype(String lowerInclusive, String upperInclusive) {
        return fetchRange(SmsResourceMast.SMS_RESOURCE_MAST.RESOURCETYPE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>resourceType IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchByResourcetype(String... values) {
        return fetch(SmsResourceMast.SMS_RESOURCE_MAST.RESOURCETYPE, values);
    }

    /**
     * Fetch records that have <code>resources BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchRangeOfResources(String lowerInclusive, String upperInclusive) {
        return fetchRange(SmsResourceMast.SMS_RESOURCE_MAST.RESOURCES, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>resources IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchByResources(String... values) {
        return fetch(SmsResourceMast.SMS_RESOURCE_MAST.RESOURCES, values);
    }

    /**
     * Fetch records that have <code>treeLeaf BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchRangeOfTreeleaf(Boolean lowerInclusive, Boolean upperInclusive) {
        return fetchRange(SmsResourceMast.SMS_RESOURCE_MAST.TREELEAF, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>treeLeaf IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchByTreeleaf(Boolean... values) {
        return fetch(SmsResourceMast.SMS_RESOURCE_MAST.TREELEAF, values);
    }

    /**
     * Fetch records that have <code>treeLevel BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchRangeOfTreelevel(Short lowerInclusive, Short upperInclusive) {
        return fetchRange(SmsResourceMast.SMS_RESOURCE_MAST.TREELEVEL, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>treeLevel IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchByTreelevel(Short... values) {
        return fetch(SmsResourceMast.SMS_RESOURCE_MAST.TREELEVEL, values);
    }

    /**
     * Fetch records that have <code>treeParent BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchRangeOfTreeparent(String lowerInclusive, String upperInclusive) {
        return fetchRange(SmsResourceMast.SMS_RESOURCE_MAST.TREEPARENT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>treeParent IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchByTreeparent(String... values) {
        return fetch(SmsResourceMast.SMS_RESOURCE_MAST.TREEPARENT, values);
    }

    /**
     * Fetch records that have <code>treeSequence BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchRangeOfTreesequence(String lowerInclusive, String upperInclusive) {
        return fetchRange(SmsResourceMast.SMS_RESOURCE_MAST.TREESEQUENCE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>treeSequence IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchByTreesequence(String... values) {
        return fetch(SmsResourceMast.SMS_RESOURCE_MAST.TREESEQUENCE, values);
    }

    /**
     * Fetch records that have <code>status BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchRangeOfStatus(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(SmsResourceMast.SMS_RESOURCE_MAST.STATUS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>status IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchByStatus(Integer... values) {
        return fetch(SmsResourceMast.SMS_RESOURCE_MAST.STATUS, values);
    }

    /**
     * Fetch records that have <code>deleted BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchRangeOfDeleted(Boolean lowerInclusive, Boolean upperInclusive) {
        return fetchRange(SmsResourceMast.SMS_RESOURCE_MAST.DELETED, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>deleted IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchByDeleted(Boolean... values) {
        return fetch(SmsResourceMast.SMS_RESOURCE_MAST.DELETED, values);
    }

    /**
     * Fetch records that have <code>createDate BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchRangeOfCreatedate(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(SmsResourceMast.SMS_RESOURCE_MAST.CREATEDATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>createDate IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchByCreatedate(LocalDateTime... values) {
        return fetch(SmsResourceMast.SMS_RESOURCE_MAST.CREATEDATE, values);
    }

    /**
     * Fetch records that have <code>createUser BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchRangeOfCreateuser(String lowerInclusive, String upperInclusive) {
        return fetchRange(SmsResourceMast.SMS_RESOURCE_MAST.CREATEUSER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>createUser IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchByCreateuser(String... values) {
        return fetch(SmsResourceMast.SMS_RESOURCE_MAST.CREATEUSER, values);
    }

    /**
     * Fetch records that have <code>createOrg BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchRangeOfCreateorg(String lowerInclusive, String upperInclusive) {
        return fetchRange(SmsResourceMast.SMS_RESOURCE_MAST.CREATEORG, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>createOrg IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchByCreateorg(String... values) {
        return fetch(SmsResourceMast.SMS_RESOURCE_MAST.CREATEORG, values);
    }

    /**
     * Fetch records that have <code>updateDate BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchRangeOfUpdatedate(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(SmsResourceMast.SMS_RESOURCE_MAST.UPDATEDATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>updateDate IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchByUpdatedate(LocalDateTime... values) {
        return fetch(SmsResourceMast.SMS_RESOURCE_MAST.UPDATEDATE, values);
    }

    /**
     * Fetch records that have <code>updateUser BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchRangeOfUpdateuser(String lowerInclusive, String upperInclusive) {
        return fetchRange(SmsResourceMast.SMS_RESOURCE_MAST.UPDATEUSER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>updateUser IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchByUpdateuser(String... values) {
        return fetch(SmsResourceMast.SMS_RESOURCE_MAST.UPDATEUSER, values);
    }

    /**
     * Fetch records that have <code>updateOrg BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchRangeOfUpdateorg(String lowerInclusive, String upperInclusive) {
        return fetchRange(SmsResourceMast.SMS_RESOURCE_MAST.UPDATEORG, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>updateOrg IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchByUpdateorg(String... values) {
        return fetch(SmsResourceMast.SMS_RESOURCE_MAST.UPDATEORG, values);
    }

    /**
     * Fetch records that have <code>updateNo BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchRangeOfUpdateno(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(SmsResourceMast.SMS_RESOURCE_MAST.UPDATENO, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>updateNo IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchByUpdateno(Integer... values) {
        return fetch(SmsResourceMast.SMS_RESOURCE_MAST.UPDATENO, values);
    }

    /**
     * Fetch records that have <code>entityId BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchRangeOfEntityid(String lowerInclusive, String upperInclusive) {
        return fetchRange(SmsResourceMast.SMS_RESOURCE_MAST.ENTITYID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>entityId IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsResourceMast> fetchByEntityid(String... values) {
        return fetch(SmsResourceMast.SMS_RESOURCE_MAST.ENTITYID, values);
    }
}