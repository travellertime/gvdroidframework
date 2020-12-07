package com.gvdroid.simple.print.core;

import com.alibaba.fastjson.JSON;
import com.gvdroid.simple.print.dto.TemplateDTO;
import com.gvdroid.simple.print.params.Goods;
import com.gvdroid.simple.print.params.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TemplateBuilder {

    public String buildTemplate() {
        TemplateDTO template = new TemplateDTO();
        TemplateBuilder templateBuilder = new TemplateBuilder();
        // 构造Header
        template.setHeader(templateBuilder.getTemplateHeader());

        // 构造商品 goods
        template.setGoods(templateBuilder.getTemplateGoods());

        // 构造其它 title
        template.setOtherTitle(templateBuilder.getTemplateOtherTitle());

        // 构造其它 商品内容
        template.setOthers(templateBuilder.getTemplateOther());

        // 构造账单 bills
        template.setBill(templateBuilder.getTemplateBills());

        // 构造尾部 footer
        template.setFooter(templateBuilder.getTemplateFooter());

        return JSON.toJSONString(template);
    }

    public List<Text> getTemplateFooter() {
        return Arrays.asList(

                new Text(0, 0, 1, "{$customer}", 2, true, false),
                new Text(0, 0, 1, "{$customerContact}", 2, true, false),
//                getBlankLine(),
                new Text(2, 1, 0, "{$qrCode}", 1, false, false),
                new Text(0, 1, 0, "***************",1, false, false ),
                new Text(0, 1, 0, "#{$orderSerialNo}{$completedText}",2, false, false ),
                new Text(0, 1, 1, "***************",1, false, false )
        );
    }


    public List<Text> getTemplateBills() {
        return Arrays.asList(
                new Text(0, 1, 2, "************************************************", 1, false, false),
                new Text(0, 2, 1, "{$originPrice}", 1, false, false),
                new Text(0, 1, 0, "{$paymentMethod}", 1, false, false),
                new Text(0, 2, 1, "{$paymentPrice}", 2, true, false),
                getCutLine()
        );
    }

    public List<Goods> getTemplateOther() {
        // 以下部分商品名和金额是列名，没有打印出来
        return Arrays.asList(
                new Goods("商品名", 0, 40, "name"),
                new Goods("金额", 2, 8, "pay")
        );
    }

    public List<Text> getTemplateOtherTitle() {
        return Collections.singletonList(
                new Text(0, 1, 1, "--------------------- 其它 ---------------------", 1, false, false));
    }

    public List<Goods> getTemplateGoods() {
        // 以下部分商品名、数量、单价、金额是列名，没有打印出来
        return Arrays.asList(
                new Goods("商品名", 0, 24, "name"),
                new Goods("数量", 2, 8, "num"),
                new Goods("单价", 2, 8, "price"),
                new Goods("金额", 2, 8, "pay")
        );
    }

    public List<Text> getTemplateHeader() {
        List<Text> headers = new ArrayList<>();
        headers.add(getTitle("{$billTitle}"));
        headers.add(getCutLine());
        headers.add(new Text(0, 1, 0, "****", 1, false, false));
        headers.add(new Text(0, 1, 0, "#{$orderSerialNo}{$orderTitle}", 2, false, false));
        headers.add(new Text(0, 1, 1, "****", 1, false, false));
        headers.add(new Text(0, 1, 2, "*{$storeName}*", 1, false, false));
        headers.add(new Text(0, 0, 1, "{$orderSubmitDatetime}", 1, false, false));
        headers.add(getCutLine());
        headers.add(new Text(0, 0, 2, "{$orderMemo}", 2, true, false));
        headers.add(getStarLineText());
        headers.add(new Text(0, 1, 2, "------------------- 一号口袋 -------------------", 1, true, false));
        return headers;
    }

    public Text getPocketName(String pocketName) {
        Text header = new Text();
        header.setText(pocketName);
        header.setFormat(1);
        header.setSize(1);
        header.setBold(false);
        header.setLine(2);
        header.setType(0);
        return header;
    }

//    public Text getRemarks(String remarks) {
//        Text header = new Text();
//        header.setText("备注：" + remarks);
//        header.setFormat(0);
//        header.setSize(2);
//        header.setBold(true);
//        header.setLine(2);
//        header.setType(0);
//        return header;
//    }

//    public Text getOrderSubmitTime(String orderSubmitTime) {
//        Text header = new Text();
//        header.setText(orderSubmitTime);
//        header.setFormat(0);
//        header.setSize(1);
//        header.setBold(false);
//        header.setLine(1);
//        header.setType(0);
//        return header;
//    }

//    public Text getStoreName(String storeName) {
//        Text header = new Text();
//        header.setText(storeName);
//        header.setFormat(1);
//        header.setSize(1);
//        header.setBold(false);
//        header.setLine(2);
//        header.setType(0);
//        return header;
//    }

    public Text getStarLineText() {
        Text starLine = new Text();
        starLine.setText("************************************************");
        starLine.setFormat(0);
        starLine.setSize(1);
        starLine.setBold(false);
        starLine.setLine(1);
        starLine.setType(0);
        return starLine;
    }

    public Text getCutLine() {
        Text header = new Text();
        header.setText("------------------------------------------------");
        header.setFormat(0);
        header.setSize(1);
        header.setBold(false);
        header.setLine(1);
        header.setType(0);
        return header;

    }

    public Text getBlankLine() {
        Text blankLine = new Text();
        blankLine.setText("");
        blankLine.setFormat(0);
        blankLine.setSize(1);
        blankLine.setBold(true);
        blankLine.setLine(1);
        blankLine.setType(0);
        return blankLine;
    }

    public Text getTitle(String title) {
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
