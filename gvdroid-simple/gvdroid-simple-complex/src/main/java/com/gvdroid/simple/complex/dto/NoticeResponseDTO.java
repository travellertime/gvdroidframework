package com.gvdroid.simple.complex.dto;


import java.util.Date;

public class NoticeResponseDTO {

    String title;
    String content;
    Date datt;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDatt() {
        return datt;
    }

    public void setDatt(Date datt) {
        this.datt = datt;
    }
}
