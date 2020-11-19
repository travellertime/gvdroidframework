package com.gvdroid.simple.helper;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DxService {
    @Cacheable(cacheNames = "getCache", key = "#id2")
    public String getA(String id2) {
        System.out.println("asd2222");
        return "sssss";
    }

    @Cacheable(cacheNames = "getCacheList", key = "#id")
    public List<String> getList(String id) {
        List<String> dataList = new ArrayList<>();
        dataList.add("123");
        dataList.add("222");
        dataList.add("444");
        return dataList;
    }

    @Cacheable(cacheNames = "getCacheUserList", key = "#id")
    public List<UserDTO> getUserList(String id) {
        System.out.println(id);
        List<UserDTO> dataList = new ArrayList<>();
        dataList.add(new UserDTO("1", "1", new UserSubDTO(11, "11"), Arrays.asList(new UserSubDTO(11, "11"), new UserSubDTO(11, "11"))));
        dataList.add(new UserDTO("2", "2", new UserSubDTO(22, "22"), Arrays.asList(new UserSubDTO(222, "222"), new UserSubDTO(222, "222"))));
        return dataList;
    }
}
