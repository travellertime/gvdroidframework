package com.gvdroid.simple.complex.service;

import com.gvdroid.simple.complex.dto.CacheRequestDTO;
import com.gvdroid.simple.complex.dto.CacheResponseDTO;

public interface CacheService {

    void cache(CacheRequestDTO requestDTO, CacheResponseDTO responseDTO);

    CacheResponseDTO cache(CacheRequestDTO requestDTO);
}
