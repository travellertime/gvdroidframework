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

    /**
     * 执行查询，该查询会自动将计数器进行累加
     *
     * @param key       关键字
     * @param valueDate 日期
     * @return 查询结果
     */
    @Override
    @Transactional
    public Integer doSerialInquiry(String key, String valueDate) {

        return serialInquiry(key, valueDate);
    }

    /**
     * 执行查询的具体方法
     *
     * @param key       关键字
     * @param valueDate 日期
     * @return 增加后的序号
     */
    private Integer serialInquiry(String key, String valueDate) {
        // 查询
        BaGlobalSerial globalSerial = this.baGlobalSerialManager.select(key, valueDate);

        // 如果没有则创建
        if (null == globalSerial) {
            this.serialAddition(key, valueDate);
            return 1;
        }

        return this.serialUpdate(globalSerial);
    }

    /**
     * 新增
     *
     * @param key       关键字
     * @param valueDate 日期
     */
    private void serialAddition(String key, String valueDate) {
        BaGlobalSerial globalSerial = new BaGlobalSerial();
        globalSerial.setSequenceKey(key);
        globalSerial.setSequenceValue(1);
        globalSerial.setSequenceDate(valueDate);
        this.baGlobalSerialManager.insert(globalSerial);
    }

    /**
     * 更新
     *
     * @param serialEntity 实体
     * @return 更新后的序号值
     */
    private Integer serialUpdate(BaGlobalSerial serialEntity) {
        // 如果有则+1
        BaGlobalSerial globalSerial = new BaGlobalSerial();
        globalSerial.setId(serialEntity.getId());
        globalSerial.setSequenceValue(serialEntity.getSequenceValue() + 1);
        this.baGlobalSerialManager.update(globalSerial);
        return globalSerial.getSequenceValue();
    }

    /**
     * 执行查询，如果不需要累加则将addRequired设置为false
     *
     * @param key         关键字
     * @param valueDate   日期
     * @param addRequired 是否需要累加
     * @return 查询结果
     */
    @Override
    @Transactional
    public Integer doSerialInquiry(String key, String valueDate, boolean addRequired) {

        if (!addRequired) {
            BaGlobalSerial globalSerial = this.baGlobalSerialManager.select(key, valueDate);
            return globalSerial.getSequenceValue();
        }
        return this.serialInquiry(key, valueDate);
    }
}
