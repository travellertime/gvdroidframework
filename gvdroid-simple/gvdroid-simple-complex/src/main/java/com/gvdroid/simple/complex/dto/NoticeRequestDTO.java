package com.gvdroid.simple.complex.dto;

import com.gvdroidframework.base.component.XfaceGenericRequestDTO;

import javax.validation.constraints.NotBlank;

public class NoticeRequestDTO extends XfaceGenericRequestDTO {


    @NotBlank(message = "id cannot be blank")
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
