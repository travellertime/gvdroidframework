package com.gvdroidframework.helper.core;

public interface RepeatAvoidTemplate {

    /**
     * 防止重复提交
     * @param keyword 关键词
     * @param duration 多长时间内不允许再次提交（毫秒）
     */
    void avoid(String keyword, long duration);

    /**
     * 防止重复提交
     * @param keyword 关键词
     * @param duration 多长时间内不允许再次提交（毫秒）
     * @param times 多长时间内允许提交的次数
     */
    void avoid(String keyword, long duration, int times);
}
