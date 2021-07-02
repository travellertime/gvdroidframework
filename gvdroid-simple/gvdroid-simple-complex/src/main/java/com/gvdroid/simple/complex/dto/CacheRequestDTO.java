package com.gvdroid.simple.complex.dto;

import com.gvdroidframework.base.component.Page;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CacheRequestDTO implements Serializable {

    Page page;
    String name;
    Integer id;
}
