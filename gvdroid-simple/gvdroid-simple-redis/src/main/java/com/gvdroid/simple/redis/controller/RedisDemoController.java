package com.gvdroid.simple.redis.controller;

import com.alibaba.fastjson.JSON;
import com.gvdroid.simple.redis.dto.User;
import com.gvdroid.simple.redis.service.UserService;
import com.gvdroidframework.base.component.R;
import com.gvdroidframework.redis.utils.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(tags = "NTC01 测试-通知")
public class RedisDemoController {

    @Resource
    private RedisUtils redisUtils;

    private final UserService userService;
    public RedisDemoController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/redis/get/{id}")
    @ApiOperation(value = "NTC01 测试-通知", httpMethod = "POST")
    public R<List<User>> getValue(@RequestBody User user) {
        return R.body(this.userService.getUser(user.getId()));
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
