package com.gvdroid.simple.complex.service.impl;

import com.gvdroid.simple.complex.dto.CacheRequestDTO;
import com.gvdroid.simple.complex.dto.CacheResponseDTO;
import com.gvdroid.simple.complex.dto.CacheResponseSubDTO;
import com.gvdroid.simple.complex.service.CacheService;
import com.gvdroidframework.base.component.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class CacheServiceImpl implements CacheService {


    @Override
    public void cache(CacheRequestDTO requestDTO, CacheResponseDTO responseDTO) {
        CacheResponseDTO cache = this.cache(requestDTO);
        responseDTO.setDataList(cache.getDataList());
    }


    @Override
    @Cacheable(value = "gvdroid:cache", key = "#requestDTO.name")
    public CacheResponseDTO cache(CacheRequestDTO requestDTO) {

        log.info("non cache");

        CacheResponseDTO responseDTO = new CacheResponseDTO();
        List<CacheResponseSubDTO> dataList = Arrays.asList(
                CacheResponseSubDTO.builder().name("aa").age(1).build(),
                CacheResponseSubDTO.builder().name("bb").age(2).build()
        );
        responseDTO.setDataList(dataList);
        responseDTO.setPage(new Page());
        return responseDTO;
    }
}
