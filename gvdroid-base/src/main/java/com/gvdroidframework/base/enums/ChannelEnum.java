package com.gvdroidframework.base.enums;

/**
 * 渠道枚举
 * @author TuJun
 */
public enum ChannelEnum {

    device("device", "充电宝设备"),
    pc("pc", "PC"),
    android("android", "APP-安卓"),
    ios("ios", "APP-IOS"),
    h5("h5", "H5"),
    cash_register("cash-register", "收银机"),
    android_pad("android-pad", "安卓平板"),
    ipad("ipad", "苹果平板");

    ChannelEnum(String value, String description) {
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

