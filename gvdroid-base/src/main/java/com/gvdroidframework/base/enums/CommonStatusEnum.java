/*
 * Copyright 2014-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
