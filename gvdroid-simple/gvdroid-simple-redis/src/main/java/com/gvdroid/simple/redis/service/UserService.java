package com.gvdroid.simple.redis.service;

import com.gvdroid.simple.redis.dto.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Cacheable(cacheNames = "user", key = "#id")
    public List<User> getUser(String id) {
        System.out.println("set cache");
        User user = new User();
        user.setId(id);
        user.setName(id + "-" + "name");
        List<User> dataList = new ArrayList<>();
        dataList.add(user);
        return dataList;
    }

    @CachePut(cacheNames = "user", key = "#id")
    public User updateUser(String id) {
        System.out.println("update cache");
        User user = new User();
        user.setId(id);
        user.setName(id + "-" + "name");
        return user;
    }

    @CacheEvict(cacheNames = "user", key = "#id")
    public void deleteUser(String id) {
        System.out.println("delete cache");
    }
}
