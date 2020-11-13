package com.gvdroid.simple.complex.dto;

import com.gvdroidframework.validation.Decimal;

import javax.validation.constraints.NotBlank;

public class ColinRequestDTO {

    @NotBlank(message = "name cannot be null")
            @Decimal(scale = 16, precision = 1)
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
