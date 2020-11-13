package com.gvdroidframework.desire.core;

/**
 * 序号服务
 */
public interface SerialTemplate {

    /**
     * 根据传入的主键获取序号，每查询一次序号自动加一
     *
     * @param key       主键
     * @param valueDate 日期 format: 20201111
     * @return 序号
     */
    Integer serialInquiry(String key, String valueDate);

    /**
     * 根据传入的主键获取序号，当addRequired为true时，每查询一次序号自动加一
     *
     * @param key         主键
     * @param valueDate   日期 format: 20201111
     * @param addRequired 序号是否需要加一
     * @return 序号
     */
    Integer serialInquiry(String key, String valueDate, boolean addRequired);
}
