package com.gvdroid.simple.complex.dto;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

public class Colin2RequestDTO {

    String name;

    Date postDate;

    String postDate2;

    List<ColinRequestSubDTO> requestSubList;

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

    public List<ColinRequestSubDTO> getRequestSubList() {
        return requestSubList;
    }

    public void setRequestSubList(List<ColinRequestSubDTO> requestSubList) {
        this.requestSubList = requestSubList;
    }
}
