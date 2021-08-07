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
package com.gvdroidframework.desire.entity;

public class BaGlobalSerial {
    private Long id;

    private String sequenceKey;

    private Integer sequenceValue;

    private String sequenceDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSequenceKey() {
        return sequenceKey;
    }

    public void setSequenceKey(String sequenceKey) {
        this.sequenceKey = sequenceKey == null ? null : sequenceKey.trim();
    }

    public Integer getSequenceValue() {
        return sequenceValue;
    }

    public void setSequenceValue(Integer sequenceValue) {
        this.sequenceValue = sequenceValue;
    }

    public String getSequenceDate() {
        return sequenceDate;
    }

    public void setSequenceDate(String sequenceDate) {
        this.sequenceDate = sequenceDate == null ? null : sequenceDate.trim();
    }
}