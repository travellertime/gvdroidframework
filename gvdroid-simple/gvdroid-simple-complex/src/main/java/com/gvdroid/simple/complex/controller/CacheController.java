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
