package com.gvdroid.simple.logging.controller;

import com.alibaba.fastjson.JSON;
import com.gvdroid.simple.logging.dto.CustomerGenericRequestDTODTO;
import com.gvdroid.simple.logging.dto.CustomerResponseDTO;
import com.gvdroid.simple.logging.dto.UserGenericRequestDTODTO;
import com.gvdroid.simple.logging.dto.UserResponseDTO;
import com.gvdroidframework.base.component.R;
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
    public R<UserResponseDTO> getUser(@RequestBody UserGenericRequestDTODTO request) {
        String requestString = JSON.toJSONString(request);
        log.info(JSON.toJSONString(request.getContext()));
        log.info(requestString);
        return new R<>(new UserResponseDTO(), new Status());
    }

    @PostMapping(value = "/customer")
    @BusinessLogger(value = "CUST01")
    public R<CustomerResponseDTO> geCustomer(@RequestBody CustomerGenericRequestDTODTO request) {
        String requestString = JSON.toJSONString(request);
        log.info(JSON.toJSONString(request.getContext()));
        log.info(requestString);
        return new R<>(new CustomerResponseDTO(), new Status());
    }
}
