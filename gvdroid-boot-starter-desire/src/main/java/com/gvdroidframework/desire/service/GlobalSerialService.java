package com.gvdroidframework.desire.service;

public interface GlobalSerialService {

    Integer doSerialInquiry(String key, String valueDate);

    Integer doSerialInquiry(String key, String valueDate, boolean addRequired);
}
