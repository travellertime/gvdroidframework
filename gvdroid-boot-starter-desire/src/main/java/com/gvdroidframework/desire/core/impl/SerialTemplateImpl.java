package com.gvdroidframework.desire.core.impl;

import com.gvdroidframework.desire.core.SerialTemplate;
import com.gvdroidframework.desire.service.GlobalSerialService;
import lombok.RequiredArgsConstructor;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.Lock;

import static java.util.concurrent.TimeUnit.SECONDS;

@Service
@RequiredArgsConstructor
public class SerialTemplateImpl implements SerialTemplate {

    final GlobalSerialService globalSerialService;
    final RedisLockRegistry lockRegistry;

    @Override
    public Integer serialInquiry(String key, String valueDate) {
        return this.serialInquiry(key, valueDate, true);
    }

//    @Override
//    public Integer serialInquiry(String key, String valueDate) {
//        return this.globalSerialService.doSerialInquiry(key, valueDate);
//    }

    @Override
    public Integer serialInquiry(String key, String valueDate, boolean addRequired) {
        if (!addRequired) {
            return this.globalSerialService.doSerialInquiry(key, valueDate, false);
        }

        Integer serialNo = 0;
        Lock lock = lockRegistry.obtain(key);
        try {
            boolean lockAcquired = lock.tryLock(10, SECONDS);
            if (lockAcquired) {
                try {
                    serialNo = this.globalSerialService.doSerialInquiry(key, valueDate);
//                    SECONDS.sleep(2);
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serialNo;

    }
}
