package com.gvdroid.simple.demo1;

import com.gvdroidframework.base.component.R;
import com.gvdroidframework.logging.annotation.BusinessLogger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.TimeUnit;

@RestController
@Api(tags = "DEMO-1 Demo1")
@Slf4j
public class Server1Controller {

    @Autowired
    GDemoProperties gDemoProperties;

    @RefreshScope
    public GDemoProperties get() {
        return this.gDemoProperties;
    }

    @BusinessLogger(value = "DEMO-1")
    @ApiOperation(value = "DEMO-1 Demo1", httpMethod = "POST")
    @PostMapping(value = "/demo/1")
    @ResponseBody
    @SneakyThrows
    public R<UserResponseDTO> inquiryUser(@Valid @RequestBody UserRequestDTO requestDTO) {

        TimeUnit.SECONDS.sleep(10L);
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setName(this.gDemoProperties.getBbb());
        responseDTO.setDataList(this.gDemoProperties.getList());
        return new R<>(responseDTO);
    }
}
