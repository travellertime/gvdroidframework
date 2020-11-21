package com.gvdroidframework.base.enums;

public enum CurrencyEnum {

    CNY("CNY", "人民币"),
    EUR("EUR", "欧元"),
    USD("USD", "美元"),
    GBP("GBP", "英镑");

    CurrencyEnum(String value, String description) {
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

