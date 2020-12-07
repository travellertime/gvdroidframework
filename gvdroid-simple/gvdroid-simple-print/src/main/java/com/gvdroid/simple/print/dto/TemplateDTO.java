package com.gvdroid.simple.print.dto;

import com.alibaba.fastjson.JSON;
import com.gvdroid.simple.print.EscPos;
import com.gvdroid.simple.print.params.Goods;
import com.gvdroid.simple.print.params.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TemplateDTO {

    static String params = "{\n" +
            "  \"keys\": {\n" +
            "    \"shopname\": \"黄太吉\",\n" +
            "    \"barCode\": \"6921734976505\",\n" +
            "    \"qrCode\": \"http://www.sublulu.com\",\n" +
            "    \"time\": \"15:35\",\n" +
            "    \"num\": 14,\n" +
            "    \"cash\": 324.5,\n" +
//            "    \"logo\": \"/sdcard/qr.png\",\n" +
            "    \"adv\": \"关注微信，有大大地活动哦\"\n" +
            "  },\n" +
            "  \"goods\": [\n" +
            "    {\n" +
            "      \"name\": \"外婆小炖菜+米饭套餐6.6折，原价36.00\",\n" +
            "      \"num\": 1,\n" +
            "      \"price\": 23.80,\n" +
            "      \"pay\": 23.80\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"筋头巴脑\",\n" +
            "      \"num\": 1,\n" +
            "      \"price\": 48.00,\n" +
            "      \"pay\": 48.00\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"我要加大米饭（小碗菜不带米饭）\",\n" +
            "      \"num\": 1,\n" +
            "      \"price\": 2.00,\n" +
            "      \"pay\": 2.00\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"白灼菜心（现炒小份菜），7.5折，原价7.90\",\n" +
            "      \"num\": 1,\n" +
            "      \"price\": 5.90,\n" +
            "      \"pay\": 5.90\n" +
            "    }\n" +
            "  ],\n" +
            "  \"others\": [\n" +
            "    {\n" +
            "      \"name\": \"打包费\",\n" +
            "      \"pay\": 3.00\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"配送费\",\n" +
            "      \"pay\": 6.00\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"减配送费6.00元\",\n" +
            "      \"pay\": -6.00\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"赠送绿豆汤 1份 x 1\",\n" +
            "      \"pay\": 5.90\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    List<Text> header;
    List<Goods> goods;
    List<Text> otherTitle;
    List<Goods> others;
    List<Text> bill;
    List<Text> footer;

    public List<Text> getHeader() {
        return header;
    }

    public void setHeader(List<Text> header) {
        this.header = header;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public List<Text> getOtherTitle() {
        return otherTitle;
    }

    public void setOtherTitle(List<Text> otherTitle) {
        this.otherTitle = otherTitle;
    }

    public List<Goods> getOthers() {
        return others;
    }

    public void setOthers(List<Goods> others) {
        this.others = others;
    }

    public List<Text> getBill() {
        return bill;
    }

    public void setBill(List<Text> bill) {
        this.bill = bill;
    }

    public List<Text> getFooter() {
        return footer;
    }

    public void setFooter(List<Text> footer) {
        this.footer = footer;
    }

    public static void main(String[] args) {

    }


}
