package com.gvdroidframework.base.enums;

/**
 * 标准状态
 */
public enum CommonStatusEnum {

    created(1, "已创建"),
    effective(2, "有效"),
    invalid(4, "无效"),

    process_in(8, "审批中"),
    process_edit(16, "审批修改"),
    process_accept(32, "审批通过"),
    process_reject(64, "审批拒绝");

    CommonStatusEnum(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    private Integer value;

    private String description;

    public Integer getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
