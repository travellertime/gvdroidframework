package com.gvdroidframework.redis;

import com.gvdroidframework.redis.utils.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApplication.class)
public class RedisTest {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Autowired
    RedisUtils redisUtils;

    @Test
    public void simple() {
        redisTemplate.opsForValue().set("1","1", Duration.ofSeconds(10));
        String s = redisTemplate.opsForValue().get("1");
        System.out.println(s);
    }

    @Test
    public void simple2() {
//        List<ItemsCacheSubDTO> subDTOList = new ArrayList<>();
//        ItemsCacheSubDTO subDTO = new ItemsCacheSubDTO();
//        subDTO.setLanguage("zh-CN");
//        subDTO.setItemsMd5("2323232");
//        subDTOList.add(subDTO);
//
//        HashMap map = new HashMap<String, Object>();
//        map.put("7800",subDTOList);
//        redisUtils.hMset("storeId2", map);
//
//        System.out.println(redisUtils.hGetAll("storeId2"));
//
//
//        ItemsCacheSubDTO subDTO2 = new ItemsCacheSubDTO();
//        subDTO2.setLanguage("en-US");
//        subDTO2.setItemsMd5("4444444");
//        subDTOList.add(subDTO2);
//
//        HashMap map2 = new HashMap<String, Object>();
//        map2.put("8801",subDTOList);
//        redisUtils.hMset("storeId2", map2);
//
//        System.out.println(redisUtils.hGetAll("storeId2"));
//
//        ItemsCacheSubDTO subDTO3 = new ItemsCacheSubDTO();
//        subDTO2.setLanguage("en-US");
//        subDTO2.setItemsMd5("5555555");
//        subDTOList.add(subDTO2);
//
        List<ItemsCacheSubDTO> subDTOList = new ArrayList<>();
        ItemsCacheSubDTO subDTO = new ItemsCacheSubDTO();
        subDTO.setLanguage("en-US");
        subDTO.setItemsMd5("666666");
        subDTOList.add(subDTO);
        HashMap map3 = new HashMap<String, Object>();
        map3.put("8801",subDTOList);
        redisUtils.hMset("storeId2", map3);

        System.out.println(redisUtils.hGetAll("storeId2"));

    }

}
