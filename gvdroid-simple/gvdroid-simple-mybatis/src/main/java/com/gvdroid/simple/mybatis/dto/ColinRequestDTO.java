package com.gvdroid.simple.mybatis.dto;

import com.gvdroidframework.base.component.XfaceGenericRequestDTO;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class ColinRequestDTO extends XfaceGenericRequestDTO {

    Long id;

    @NotBlank(message = "name cannot be null")
    String name;

    Date postDate;

    String postDate2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getPostDate2() {
        return postDate2;
    }

    public void setPostDate2(String postDate2) {
        this.postDate2 = postDate2;
    }
}
