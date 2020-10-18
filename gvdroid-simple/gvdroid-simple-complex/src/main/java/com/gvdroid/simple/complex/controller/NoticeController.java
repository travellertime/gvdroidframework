package com.gvdroid.simple.complex.controller;

import com.alibaba.fastjson.JSON;
import com.gvdroid.simple.complex.dto.NoticeRequestDTO;
import com.gvdroid.simple.complex.dto.NoticeResponseDTO;
import com.gvdroidframework.base.component.Request;
import com.gvdroidframework.base.component.Response;
import com.gvdroidframework.base.component.Status;
import com.gvdroidframework.logging.annotation.BusinessLogger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "NTC01 测试-通知")
@Slf4j
public class NoticeController {

    @PostMapping(value = "/notice")
    @BusinessLogger(value = "NTC01")
    @ApiOperation(value = "NTC01 测试-通知", httpMethod = "POST")
    public Response<NoticeResponseDTO> getNotice(@RequestBody Request<NoticeRequestDTO> request) {
        log.info(JSON.toJSONString(request));
        return new Response<>(new NoticeResponseDTO(), new Status());
    }
}
