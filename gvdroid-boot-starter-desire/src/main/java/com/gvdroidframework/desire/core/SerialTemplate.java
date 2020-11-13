package com.gvdroidframework.desire.core;

public interface SerialTemplate {

    Integer serialInquiry(String key, String valueDate);

    Integer serialInquiry(String key, String valueDate, boolean addRequired);
}
