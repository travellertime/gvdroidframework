package com.gvdroid.simple.mybatis.controller;

import com.alibaba.fastjson.JSON;
import com.gvdroid.simple.mybatis.dto.ColinRequestDTO;
import com.gvdroid.simple.mybatis.dto.ColinResponseDTO;
import com.gvdroid.simple.mybatis.entity.Test;
import com.gvdroid.simple.mybatis.repository.TestMapper;
import com.gvdroidframework.base.component.R;
import com.gvdroidframework.util.IDUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@RestController
@Api(tags = "NTC01 测试-通知")
@Slf4j
@RequiredArgsConstructor
public class NoticeController {

    final TestMapper testMapper;

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


        this.insert(requestDTO.getPostDate());

        return R.body(responseDTO);
    }

    @PostMapping(value = "/colin/get")
    @ApiOperation(value = "NTC03 测试获取", httpMethod = "POST")
    public R<ColinResponseDTO> getColinGet(@RequestBody @Valid ColinRequestDTO requestDTO) {


        System.out.println(requestDTO.getPostDate());

        Test test = this.testMapper.selectByPrimaryKey(requestDTO.getId());
        System.out.println(test.getnDate());

        ColinResponseDTO responseDTO = new ColinResponseDTO();
        responseDTO.setExpiryDate(test.getnDate());
        return R.body(responseDTO);
    }

    private void insert(Date nDate) {
        Test entity = new Test();
        entity.setId(IDUtils.generateOrderId());
        entity.setnDate(nDate);
        this.testMapper.insertSelective(entity);

        Test entity2 = new Test();
        entity2.setId(IDUtils.generateOrderId());
        entity2.setnDate(new Date());
        this.testMapper.insertSelective(entity2);
    }
}
