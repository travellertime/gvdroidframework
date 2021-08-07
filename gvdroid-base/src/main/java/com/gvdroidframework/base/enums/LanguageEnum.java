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

