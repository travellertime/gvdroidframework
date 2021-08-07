/*
 * Copyright 2014-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gvdroid.simple.complex.controller;

import com.alibaba.fastjson.JSON;
import com.gvdroid.simple.complex.configuration.GDemoProperties;
import com.gvdroid.simple.complex.dto.*;
import com.gvdroidframework.base.component.R;
import com.gvdroidframework.logging.annotation.BusinessLogger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@Api(tags = "NTC01 测试-通知")
@Slf4j
public class NoticeController {

    @Autowired
    GDemoProperties gDemoProperties;

    @PostMapping(value = "/notice")
//    @BusinessLogger(value = "NTC01")
    @ApiOperation(value = "NTC01 测试-通知", httpMethod = "POST")
    public R<NoticeResponseDTO> getNotice(@RequestBody @Valid NoticeRequestDTO request) {
        log.info(JSON.toJSONString(request));

//        gDemoProperties.getList().forEach(System.out::println);
        System.out.println(request.getStartDate());
        NoticeResponseDTO noticeResponseDTO = new NoticeResponseDTO();
        noticeResponseDTO.setDatt(request.getStartDate());

        return R.body(noticeResponseDTO);
    }

    @PostMapping(value = "/colin")
    @ApiOperation(value = "NTC02 测试", httpMethod = "POST")
    public R<ColinResponseDTO> getColin(@RequestBody @Valid ColinRequestDTO requestDTO) {

        Instant instant = requestDTO.getPostDate().toInstant();

        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println(ZoneId.systemDefault());
        System.out.println(localDateTime);



        log.info(JSON.toJSONString(requestDTO));
        ColinResponseDTO responseDTO = new ColinResponseDTO();
        responseDTO.setName("colin");
        responseDTO.setExpiryDate(requestDTO.getPostDate());
        return R.body(responseDTO);
    }

    @PostMapping(value = "/colin/list")
    @ApiOperation(value = "NTC03 测试List拷贝", httpMethod = "POST")
    public R<ColinResponseDTO> getColinListCopy(@RequestBody @Valid ColinRequestDTO requestDTO) {
        Colin2RequestDTO colin2RequestDTO = new Colin2RequestDTO();

        BeanUtils.copyProperties(requestDTO, colin2RequestDTO);

        List<ColinResponseSubDTO> dtoList = new ArrayList<>();



        BeanUtils.copyProperties(requestDTO.getRequestSubList(), dtoList);

        System.out.println(JSON.toJSONString(colin2RequestDTO));

        System.out.println(JSON.toJSONString(dtoList));

        return R.body(null);

    }
}
