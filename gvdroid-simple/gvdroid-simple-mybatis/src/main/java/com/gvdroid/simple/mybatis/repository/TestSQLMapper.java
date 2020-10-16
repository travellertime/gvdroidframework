package com.gvdroid.simple.mybatis.repository;

import com.gvdroid.simple.mybatis.entity.Test;
import com.gvdroidframework.base.component.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestSQLMapper {

    List<Test> selectList(@Param("entity") Test entity, @Param("page") Page page);
}
