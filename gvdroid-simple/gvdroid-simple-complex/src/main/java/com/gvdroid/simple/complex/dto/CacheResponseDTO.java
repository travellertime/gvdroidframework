package com.gvdroid.simple.complex.dto;

import com.gvdroidframework.base.component.Page;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CacheResponseDTO implements Serializable {

    Page page;

    List<CacheResponseSubDTO> dataList;

}
