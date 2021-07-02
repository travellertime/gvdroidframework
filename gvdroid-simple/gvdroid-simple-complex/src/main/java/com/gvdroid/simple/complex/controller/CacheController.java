package com.gvdroid.simple.complex.controller;

import com.gvdroid.simple.complex.dto.CacheRequestDTO;
import com.gvdroid.simple.complex.dto.CacheResponseDTO;
import com.gvdroid.simple.complex.service.CacheService;
import com.gvdroidframework.base.component.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "CACHE 缓存")
@RestController
@RequiredArgsConstructor
public class CacheController {

    final CacheService cacheService;

    @PostMapping(value = "/cache")
    @ApiOperation(value = "CACHE 读取测试", httpMethod = "POST")
    public R<CacheResponseDTO> cache(@Valid @RequestBody CacheRequestDTO requestDTO) {
//        CacheResponseDTO responseDTO = new CacheResponseDTO();
//        this.cacheService.cache(requestDTO, responseDTO);
        return R.body(this.cacheService.cache(requestDTO));
    }
}
