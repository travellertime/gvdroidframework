/*
 * Copyright 2014-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
