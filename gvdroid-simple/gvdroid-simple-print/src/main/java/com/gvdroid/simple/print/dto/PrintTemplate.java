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

public class PrintTemplate {

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
        PrintTemplate template = new PrintTemplate();

        // 构造Header
        template.setHeader(template.getTemplateHeader());

        // 构造商品 goods
        template.setGoods(template.getTemplateGoods());

        // 构造其它 title
        template.setOtherTitle(template.getTemplateOtherTitle());

        // 构造其它 商品内容
        template.setOthers(template.getTemplateOther());

        // 构造账单 bills
        template.setBill(template.getTemplateBills());

        // 构造尾部 footer
        template.setFooter(template.getTemplateFooter());

        String templateString = JSON.toJSONString(template);

        System.out.println(templateString);

        try {
            EscPos.getInstance("192.168.8.188");
            EscPos.print(templateString, params);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Text> getTemplateFooter() {
        return Arrays.asList(
                new Text(0, 0, 1, "李杰（先生）", 2, true, false),
                new Text(0, 0, 1, "顾客号码：手机尾号 2236", 2, true, false),
                getBlankLine(),
                new Text(1, 1, 1, "{$barCode}",1, false, false ),
                new Text(0, 1, 1, "ID:{$barCode}",1, false, false ),
                new Text(0, 1, 0, "***************",1, false, false ),
                new Text(0, 1, 0, "#0001完",2, false, false ),
                new Text(0, 1, 1, "***************",1, false, false )
        );
    }


    private List<Text> getTemplateBills() {
        return Arrays.asList(
                getStarLineText(),
                new Text(0, 2, 1, "原价：93.00元", 1, false, false),
                new Text(0, 1, 0, "（用户在线支付）", 1, false, false),
                new Text(0, 2, 1, "74000.80元", 2, true, false),
                getCutLine()
        );
    }

    private List<Goods> getTemplateOther() {
        return Arrays.asList(
                new Goods("商品名", 0, 40, "name"),
                new Goods("金额", 2, 8, "pay")
        );
    }

    private List<Text> getTemplateOtherTitle() {
        return Collections.singletonList(
                new Text(0, 1, 1, "-------------------- 其它 --------------------", 1, false, false));
    }

    private List<Goods> getTemplateGoods() {
        return Arrays.asList(
                new Goods("商品名", 0, 24, "name"),
                new Goods("数量", 1, 8, "num"),
                new Goods("单价", 2, 8, "price"),
                new Goods("金额", 2, 8, "pay")
        );
    }

    private List<Text> getTemplateHeader() {
        List<Text> headers = new ArrayList<>();
        headers.add(getTitle("商家小票"));
        headers.add(getCutLine());
        headers.add(getPlatformName("**#00留一手外卖**"));
        headers.add(getStoreName("* 留一手火锅 *"));
        headers.add(getOrderSubmitTime("下单时间：2020-12-06 21:57:56"));
        headers.add(getCutLine());
        headers.add(getRemarks("顾客需要餐具，还需要两个辣椒和一个洋葱"));
        headers.add(getStarLineText());
        headers.add(getPocketName("------------------ 一号口袋 ------------------"));
        return headers;
    }

    private Text getPocketName(String pocketName) {
        Text header = new Text();
        header.setText(pocketName);
        header.setFormat(1);
        header.setSize(1);
        header.setBold(false);
        header.setLine(2);
        header.setType(0);
        return header;
    }

    private Text getRemarks(String remarks) {
        Text header = new Text();
        header.setText("备注：" + remarks);
        header.setFormat(0);
        header.setSize(2);
        header.setBold(true);
        header.setLine(2);
        header.setType(0);
        return header;
    }

    private Text getOrderSubmitTime(String orderSubmitTime) {
        Text header = new Text();
        header.setText(orderSubmitTime);
        header.setFormat(0);
        header.setSize(1);
        header.setBold(false);
        header.setLine(1);
        header.setType(0);
        return header;
    }

    private Text getStoreName(String storeName) {
        Text header = new Text();
        header.setText(storeName);
        header.setFormat(1);
        header.setSize(1);
        header.setBold(false);
        header.setLine(2);
        header.setType(0);
        return header;
    }

    private Text getPlatformName(String platformName) {
        Text header = new Text();
        header.setText(platformName);
        header.setFormat(1);
        header.setSize(2);
        header.setBold(true);
        header.setLine(1);
        header.setType(0);
        return header;
    }

    private Text getStarLineText() {
        Text starLine = new Text();
        starLine.setText("************************************************");
        starLine.setFormat(0);
        starLine.setSize(1);
        starLine.setBold(false);
        starLine.setLine(1);
        starLine.setType(0);
        return starLine;
    }

    private Text getCutLine() {
        Text header = new Text();
        header.setText("------------------------------------------------");
        header.setFormat(0);
        header.setSize(1);
        header.setBold(false);
        header.setLine(1);
        header.setType(0);
        return header;

    }

    private Text getBlankLine() {
        Text blankLine = new Text();
        blankLine.setText("");
        blankLine.setFormat(0);
        blankLine.setSize(1);
        blankLine.setBold(true);
        blankLine.setLine(1);
        blankLine.setType(0);
        return blankLine;
    }

    private Text getTitle(String title) {
        Text header = new Text();
        header.setText(title);
        header.setFormat(0);
        header.setSize(2);
        header.setBold(true);
        header.setLine(1);
        header.setType(0);
        return header;
    }
}
