package com.gvdroid.simple.redis.controller;

import com.alibaba.fastjson.JSON;
import com.gvdroid.simple.redis.dto.User;
import com.gvdroid.simple.redis.service.UserService;
import com.gvdroidframework.redis.utils.RedisUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisDemoController {

    @Resource
    private RedisUtils redisUtils;

    private final UserService userService;
    public RedisDemoController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/redis/get/{id}")
    public String getValue(@PathVariable("id") String id) {
        User user = this.userService.getUser(id);

        return JSON.toJSONString(user);
    }

    @GetMapping(value = "redis/delete/{id}")
    public String deleteValue(@PathVariable("id") String id) {
        this.userService.deleteUser(id);
        return "value be deleted";
    }

    @GetMapping(value = "redis/update/{id}")
    public String updateValue(@PathVariable("id") String id) {
        this.userService.updateUser(id);
        return "value be updated";
    }
}
