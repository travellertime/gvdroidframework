package com.gvdroidframework.base.enums;

public enum LanguageEnum {

    zh_CN("zh-CN", "中文"),
    en_US("en-US", "英文"),
    es_ES("es-ES", "西语"),
    it_IT("it-IT", "意大利文");

    LanguageEnum(String value, String description) {
        this.value = value;
        this.description = description;
    }

    private String value;

    private String description;

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

}

