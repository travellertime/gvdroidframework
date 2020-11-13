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