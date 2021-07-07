/*
 * This file is generated by jOOQ.
 */
package com.gvdroid.simple.jooq.code.sms.tables.daos;


import com.gvdroid.simple.jooq.code.sms.tables.SmsUserMast;
import com.gvdroid.simple.jooq.code.sms.tables.records.SmsUserMastRecord;

import java.time.LocalDateTime;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * 权限-用户主表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class SmsUserMastDao extends DAOImpl<SmsUserMastRecord, com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast, Long> {

    /**
     * Create a new SmsUserMastDao without any configuration
     */
    public SmsUserMastDao() {
        super(SmsUserMast.SMS_USER_MAST, com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast.class);
    }

    /**
     * Create a new SmsUserMastDao with an attached configuration
     */
    @Autowired
    public SmsUserMastDao(Configuration configuration) {
        super(SmsUserMast.SMS_USER_MAST, com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast.class, configuration);
    }

    @Override
    public Long getId(com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(SmsUserMast.SMS_USER_MAST.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchById(Long... values) {
        return fetch(SmsUserMast.SMS_USER_MAST.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast fetchOneById(Long value) {
        return fetchOne(SmsUserMast.SMS_USER_MAST.ID, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(SmsUserMast.SMS_USER_MAST.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchByName(String... values) {
        return fetch(SmsUserMast.SMS_USER_MAST.NAME, values);
    }

    /**
     * Fetch records that have <code>category BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchRangeOfCategory(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(SmsUserMast.SMS_USER_MAST.CATEGORY, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>category IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchByCategory(Integer... values) {
        return fetch(SmsUserMast.SMS_USER_MAST.CATEGORY, values);
    }

    /**
     * Fetch records that have <code>customerId BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchRangeOfCustomerid(String lowerInclusive, String upperInclusive) {
        return fetchRange(SmsUserMast.SMS_USER_MAST.CUSTOMERID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>customerId IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchByCustomerid(String... values) {
        return fetch(SmsUserMast.SMS_USER_MAST.CUSTOMERID, values);
    }

    /**
     * Fetch records that have <code>accountNo BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchRangeOfAccountno(String lowerInclusive, String upperInclusive) {
        return fetchRange(SmsUserMast.SMS_USER_MAST.ACCOUNTNO, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>accountNo IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchByAccountno(String... values) {
        return fetch(SmsUserMast.SMS_USER_MAST.ACCOUNTNO, values);
    }

    /**
     * Fetch records that have <code>mobile BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchRangeOfMobile(String lowerInclusive, String upperInclusive) {
        return fetchRange(SmsUserMast.SMS_USER_MAST.MOBILE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>mobile IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchByMobile(String... values) {
        return fetch(SmsUserMast.SMS_USER_MAST.MOBILE, values);
    }

    /**
     * Fetch records that have <code>source BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchRangeOfSource(String lowerInclusive, String upperInclusive) {
        return fetchRange(SmsUserMast.SMS_USER_MAST.SOURCE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>source IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchBySource(String... values) {
        return fetch(SmsUserMast.SMS_USER_MAST.SOURCE, values);
    }

    /**
     * Fetch records that have <code>pinCode BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchRangeOfPincode(String lowerInclusive, String upperInclusive) {
        return fetchRange(SmsUserMast.SMS_USER_MAST.PINCODE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>pinCode IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchByPincode(String... values) {
        return fetch(SmsUserMast.SMS_USER_MAST.PINCODE, values);
    }

    /**
     * Fetch records that have <code>pinCodeDate BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchRangeOfPincodedate(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(SmsUserMast.SMS_USER_MAST.PINCODEDATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>pinCodeDate IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchByPincodedate(LocalDateTime... values) {
        return fetch(SmsUserMast.SMS_USER_MAST.PINCODEDATE, values);
    }

    /**
     * Fetch records that have <code>status BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchRangeOfStatus(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(SmsUserMast.SMS_USER_MAST.STATUS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>status IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchByStatus(Integer... values) {
        return fetch(SmsUserMast.SMS_USER_MAST.STATUS, values);
    }

    /**
     * Fetch records that have <code>deleted BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchRangeOfDeleted(Boolean lowerInclusive, Boolean upperInclusive) {
        return fetchRange(SmsUserMast.SMS_USER_MAST.DELETED, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>deleted IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchByDeleted(Boolean... values) {
        return fetch(SmsUserMast.SMS_USER_MAST.DELETED, values);
    }

    /**
     * Fetch records that have <code>createDate BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchRangeOfCreatedate(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(SmsUserMast.SMS_USER_MAST.CREATEDATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>createDate IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchByCreatedate(LocalDateTime... values) {
        return fetch(SmsUserMast.SMS_USER_MAST.CREATEDATE, values);
    }

    /**
     * Fetch records that have <code>createUser BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchRangeOfCreateuser(String lowerInclusive, String upperInclusive) {
        return fetchRange(SmsUserMast.SMS_USER_MAST.CREATEUSER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>createUser IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchByCreateuser(String... values) {
        return fetch(SmsUserMast.SMS_USER_MAST.CREATEUSER, values);
    }

    /**
     * Fetch records that have <code>createOrg BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchRangeOfCreateorg(String lowerInclusive, String upperInclusive) {
        return fetchRange(SmsUserMast.SMS_USER_MAST.CREATEORG, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>createOrg IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchByCreateorg(String... values) {
        return fetch(SmsUserMast.SMS_USER_MAST.CREATEORG, values);
    }

    /**
     * Fetch records that have <code>updateDate BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchRangeOfUpdatedate(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(SmsUserMast.SMS_USER_MAST.UPDATEDATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>updateDate IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchByUpdatedate(LocalDateTime... values) {
        return fetch(SmsUserMast.SMS_USER_MAST.UPDATEDATE, values);
    }

    /**
     * Fetch records that have <code>updateUser BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchRangeOfUpdateuser(String lowerInclusive, String upperInclusive) {
        return fetchRange(SmsUserMast.SMS_USER_MAST.UPDATEUSER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>updateUser IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchByUpdateuser(String... values) {
        return fetch(SmsUserMast.SMS_USER_MAST.UPDATEUSER, values);
    }

    /**
     * Fetch records that have <code>updateOrg BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchRangeOfUpdateorg(String lowerInclusive, String upperInclusive) {
        return fetchRange(SmsUserMast.SMS_USER_MAST.UPDATEORG, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>updateOrg IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchByUpdateorg(String... values) {
        return fetch(SmsUserMast.SMS_USER_MAST.UPDATEORG, values);
    }

    /**
     * Fetch records that have <code>updateNo BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchRangeOfUpdateno(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(SmsUserMast.SMS_USER_MAST.UPDATENO, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>updateNo IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchByUpdateno(Integer... values) {
        return fetch(SmsUserMast.SMS_USER_MAST.UPDATENO, values);
    }

    /**
     * Fetch records that have <code>entityId BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchRangeOfEntityid(String lowerInclusive, String upperInclusive) {
        return fetchRange(SmsUserMast.SMS_USER_MAST.ENTITYID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>entityId IN (values)</code>
     */
    public List<com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast> fetchByEntityid(String... values) {
        return fetch(SmsUserMast.SMS_USER_MAST.ENTITYID, values);
    }
}
