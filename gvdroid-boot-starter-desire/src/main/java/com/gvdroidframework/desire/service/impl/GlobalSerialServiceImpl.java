package com.gvdroidframework.desire.service.impl;

import com.gvdroidframework.desire.entity.BaGlobalSerial;
import com.gvdroidframework.desire.manager.BaGlobalSerialManager;
import com.gvdroidframework.desire.service.GlobalSerialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GlobalSerialServiceImpl implements GlobalSerialService {

    final BaGlobalSerialManager baGlobalSerialManager;

    @Override
    @Transactional
    public Integer doSerialInquiry(String key, String valueDate) {

       return serialInquiry(key, valueDate);
    }

    private Integer serialInquiry(String key, String valueDate) {
        // 查询
        BaGlobalSerial serial = this.baGlobalSerialManager.select(key, valueDate);

        // 如果没有则创建
        if (null == serial) {
            this.serialAddition(key, valueDate);
            return 1;
        }

        return this.serialUpdate(serial);
    }

    private void serialAddition(String key, String valueDate) {
        BaGlobalSerial entity = new BaGlobalSerial();
        entity.setKey(key);
        entity.setValueDate(valueDate);
        entity.setValue(1);
        this.baGlobalSerialManager.insert(entity);
    }

    private Integer serialUpdate(BaGlobalSerial serial) {
        // 如果有则+1
        BaGlobalSerial entity = new BaGlobalSerial();
        entity.setId(serial.getId());
        entity.setValue(serial.getValue() + 1);
        this.baGlobalSerialManager.update(entity);
        return entity.getValue();
    }




    @Override
    public Integer doSerialInquiry(String key, String valueDate, boolean addRequired) {

        if (!addRequired) {
            BaGlobalSerial serial = this.baGlobalSerialManager.select(key, valueDate);
            return serial.getValue();
        }
         return this.serialInquiry(key, valueDate);
    }
}
