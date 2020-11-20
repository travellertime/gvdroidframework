package com.gvdroid.simple.demo1;

import com.gvdroidframework.base.component.R;
import com.gvdroidframework.logging.annotation.BusinessLogger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(tags = "DEMO-1 Demo1")
@Slf4j
public class Server1Controller {

    @BusinessLogger(value = "DEMO-1")
    @ApiOperation(value = "DEMO-1 Demo1", httpMethod = "POST")
    @PostMapping(value = "/demo/1")
    @ResponseBody
    public R<UserResponseDTO> inquiryUser(@Valid @RequestBody UserRequestDTO requestDTO) {
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setName("serviceA--asd");
        return new R<>(responseDTO);
    }
}