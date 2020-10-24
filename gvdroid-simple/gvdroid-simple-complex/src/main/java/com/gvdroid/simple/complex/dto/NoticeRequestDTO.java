package com.gvdroid.simple.complex.dto;

import javax.validation.constraints.NotBlank;

public class NoticeRequestDTO {


    @NotBlank(message = "id cannot be blank")
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
