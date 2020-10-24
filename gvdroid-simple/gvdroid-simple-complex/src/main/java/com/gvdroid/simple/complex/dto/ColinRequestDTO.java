package com.gvdroid.simple.complex.dto;

import javax.validation.constraints.NotBlank;

public class ColinRequestDTO {

    @NotBlank(message = "name cannot be null")
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
