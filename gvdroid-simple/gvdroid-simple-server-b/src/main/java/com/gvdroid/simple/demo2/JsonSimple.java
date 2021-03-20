package com.gvdroid.simple.demo2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;

public class JsonSimple {

    public static void main(String[] args) {


//        HomeSimple homeSimple = new HomeSimple();
//        homeSimple.setAddress("双流");
//        homeSimple.setNumberOfPeople(2);
//        homeSimple.setTotalMoney(BigDecimal.valueOf(100000));
//
//        String jsonString = JSON.toJSONString(homeSimple);
//
//        System.out.println(jsonString);

        String jsonString = "{\"address\":null,\"numberOfPeople\":2,\"totalMoney\":100000}";

//        String jsonString = "{\"numberOfPeople\":2,\"totalMoney\":100000}";

        HomeSimple homeSimple = JSONObject.parseObject(jsonString, HomeSimple.class);

        System.out.println(homeSimple.getAddress() + "::::::");
        System.out.println(homeSimple.getNumberOfPeople() + "::::::");
        System.out.println(homeSimple.getTotalMoney() + "::::::");
    }
}
