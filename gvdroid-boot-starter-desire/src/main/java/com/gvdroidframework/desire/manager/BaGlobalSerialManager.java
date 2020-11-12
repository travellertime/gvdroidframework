package com.gvdroidframework.desire.manager;

import com.gvdroidframework.desire.entity.BaGlobalSerial;
import com.gvdroidframework.desire.entity.BaGlobalSerialExample;
import com.gvdroidframework.desire.repository.BaGlobalSerialMapper;
import com.sun.istack.internal.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.xml.ws.RequestWrapper;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BaGlobalSerialManager {

    final BaGlobalSerialMapper baGlobalSerialMapper;

    public BaGlobalSerial select(@NotNull String key, @NotNull String date) {
        BaGlobalSerialExample example = new BaGlobalSerialExample();
        example.or()
                .andKeyEqualTo(key)
                .andValueDateEqualTo(date);
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

        this.baGlobalSerialMapper.updateByPrimaryKey(entity);
    }
}
