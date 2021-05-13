package com.gvdroid.simple.complex.dto;

import com.gvdroid.simple.complex.enums.Gender;
import com.gvdroidframework.base.component.XfaceGenericRequestDTO;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class NoticeRequestDTO extends XfaceGenericRequestDTO {


    @NotBlank(message = "id cannot be blank")
    String id;

    Gender gender;

    Date startDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
