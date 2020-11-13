package com.gvdroidframework.desire.manager;

import com.gvdroidframework.desire.entity.BaGlobalSerial;
import com.gvdroidframework.desire.entity.BaGlobalSerialExample;
import com.gvdroidframework.desire.repository.BaGlobalSerialMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BaGlobalSerialManager {

    final BaGlobalSerialMapper baGlobalSerialMapper;

    public BaGlobalSerial select(String key, String date) {
        BaGlobalSerialExample example = new BaGlobalSerialExample();
        example.or()
                .andSequenceKeyEqualTo(key)
                .andSequenceDateEqualTo(date);
        List<BaGlobalSerial> dataList = this.baGlobalSerialMapper.selectByExample(example);
        if (!dataList.isEmpty()) {
            return dataList.get(0);
        }
        return null;
    }

    public void insert(BaGlobalSerial entity) {
        this.baGlobalSerialMapper.insert(entity);
    }

    public void update(BaGlobalSerial entity) {

        this.baGlobalSerialMapper.updateByPrimaryKeySelective(entity);
    }
}
