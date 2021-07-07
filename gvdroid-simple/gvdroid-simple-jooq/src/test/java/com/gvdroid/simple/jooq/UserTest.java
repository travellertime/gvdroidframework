package com.gvdroid.simple.jooq;

import com.gvdroid.simple.jooq.code.sms.tables.daos.SmsUserMastDao;
import com.gvdroid.simple.jooq.code.sms.tables.pojos.SmsUserMast;
import com.gvdroid.simple.jooq.code.sms.tables.records.SmsUserMastRecord;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.SelectConditionStep;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.gvdroid.simple.jooq.code.sms.Tables.SMS_USER_MAST;

@SpringBootTest
@Slf4j
@RequiredArgsConstructor
public class UserTest {

    @Autowired
    SmsUserMastDao smsUserMastDao;

    @Autowired
    DSLContext dslContext;

    @Test
    public void insert() throws Exception {
        SmsUserMast entity = new SmsUserMast();
        entity.setId(1L);
        entity.setName("111");
        entity.setCategory(1);
        this.smsUserMastDao.insert(entity);

        this.smsUserMastDao.delete(entity);
    }

//    @Test
//    public void select() {
//        List<SmsUserMast> smsUserMasts = this.smsUserMastDao.fetchById(1L);
//        System.out.println(smsUserMasts);
//        log.info("test completed");
//    }

    @Test
    public void delete() {
        SmsUserMast smsUserMast = new SmsUserMast();
        smsUserMast.setId(1L);
        this.smsUserMastDao.delete(smsUserMast);
    }

    @Test
    public void test() {

        Result<SmsUserMastRecord> result = this.dslContext.selectFrom(SMS_USER_MAST).where(SMS_USER_MAST.ID.eq(1L)).fetch();
        for (SmsUserMastRecord record : result) {
            System.out.println(record);
        }


        Result<Record1<String>> fetch = this.dslContext.select(SMS_USER_MAST.NAME).from(SMS_USER_MAST).where(SMS_USER_MAST.ID.eq(1L)).fetch();
        for (Record1<String> stringRecord1 : fetch) {
            String value = stringRecord1.getValue(SMS_USER_MAST.NAME);
            System.out.println(value);
        }

    }
}
