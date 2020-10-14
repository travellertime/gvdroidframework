package com.gvdroidframework.helper.core;

public interface RepeatAvoidTemplate {

    void avoid(String keyword, long duration);

    void avoid(String keyword, long duration, int times);
}
