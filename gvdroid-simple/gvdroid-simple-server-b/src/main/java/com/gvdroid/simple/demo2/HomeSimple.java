package com.gvdroid.simple.demo2;

import java.io.Serializable;
import java.math.BigDecimal;

public class HomeSimple implements Serializable {

    private Integer numberOfPeople;
    private String address;
    private BigDecimal totalMoney;

    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }
}
