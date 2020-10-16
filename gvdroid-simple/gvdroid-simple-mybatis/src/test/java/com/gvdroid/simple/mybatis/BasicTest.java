package com.gvdroid.simple.mybatis;

import com.gvdroid.simple.mybatis.repository.TestSQLMapper;
import com.gvdroidframework.base.component.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicTest {

    @Resource
    TestSQLMapper testSQLMapper;

    @Test
    public void run() {

//        Long id = 100L;
//
//        TestExample example = new TestExample();
//        example.or()
//                .andIdEqualTo(id);
//
        Page page = new Page(1, 2);
//        List<com.gvdroid.cloud.mysql.test.entity.Test> dataList = testMapper.selectByExample(example, page);
        com.gvdroid.simple.mybatis.entity.Test t = new com.gvdroid.simple.mybatis.entity.Test();
        t.setEntityId("1");
        List<com.gvdroid.simple.mybatis.entity.Test> dataList = testSQLMapper.selectList(t, page);
        dataList.forEach(System.out::println);
    }
}
