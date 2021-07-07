package com.gvdroid.simple.demo2;

import com.alibaba.fastjson.JSON;
import com.gvdroidframework.base.component.R;
import com.gvdroidframework.base.constant.ErrorCode;
import com.gvdroidframework.base.exception.BaseException;
import com.gvdroidframework.logging.annotation.BusinessLogger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@Api(tags = "DEMO-2 Demo2")
@Slf4j
public class Server2Controller {

    @Autowired
    Demo1Service demo1Service;

    @BusinessLogger(value = "DEMO-2")
//    @ApiOperation(value = "DEMO-2 Demo2", httpMethod = "POST")
    @PostMapping(value = "/demo/2")
    @ResponseBody
    public R<UserResponseDTO> inquiryUser(@Valid @RequestBody UserRequestDTO requestDTO) {
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setName("service222222--asd");

        R<UserResponseDTO> response = demo1Service.processRequest(requestDTO);



        System.out.println(response.getStatus().isSuccess());

        System.out.println(JSON.toJSONString(response));

        if (!response.getStatus().isSuccess()) {
            throw new BaseException(response.getStatus().getReplyText(), response.getStatus().getReplyCode());
        }

        return new R<>(responseDTO, response.getStatus());
    }
}
