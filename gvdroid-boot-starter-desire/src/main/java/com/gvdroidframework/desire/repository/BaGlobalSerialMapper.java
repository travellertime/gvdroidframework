package com.gvdroidframework.desire.repository;

import com.gvdroidframework.desire.entity.BaGlobalSerial;
import com.gvdroidframework.desire.entity.BaGlobalSerialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaGlobalSerialMapper {
    long countByExample(BaGlobalSerialExample example);

    int deleteByExample(BaGlobalSerialExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaGlobalSerial record);

    int insertSelective(BaGlobalSerial record);

    List<BaGlobalSerial> selectByExample(BaGlobalSerialExample example);

    BaGlobalSerial selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaGlobalSerial record, @Param("example") BaGlobalSerialExample example);

    int updateByExample(@Param("record") BaGlobalSerial record, @Param("example") BaGlobalSerialExample example);

    int updateByPrimaryKeySelective(BaGlobalSerial record);

    int updateByPrimaryKey(BaGlobalSerial record);
}