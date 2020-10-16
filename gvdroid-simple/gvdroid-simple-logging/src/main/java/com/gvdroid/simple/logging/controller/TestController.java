package com.gvdroid.simple.logging.controller;

import com.alibaba.fastjson.JSON;
import com.gvdroid.simple.logging.dto.UserRequestDTO;
import com.gvdroid.simple.logging.dto.UserResponseDTO;
import com.gvdroidframework.base.component.Request;
import com.gvdroidframework.base.component.Response;
import com.gvdroidframework.base.component.Status;
import com.gvdroidframework.logging.annotation.BusinessLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    Logger log = LoggerFactory.getLogger(TestController.class);

    @PostMapping(value = "/user")
    @BusinessLogger(value = "USR001")
    public Response<UserResponseDTO> getUser(@RequestBody Request<UserRequestDTO> request) {
        String requestString = JSON.toJSONString(request);
        log.info(JSON.toJSONString(request.getContext()));
        log.info(requestString);
        return new Response<>(new UserResponseDTO(), new Status());
    }
}
