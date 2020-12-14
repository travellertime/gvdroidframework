package com.gvdroid.simple.print.core;

import com.alibaba.fastjson.JSON;
import com.gvdroid.simple.print.dto.TemplateDTO;
import com.gvdroid.simple.print.params.Goods;
import com.gvdroid.simple.print.params.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Template56Builder implements TemplateService{

    @Override
    public String buildTemplate() {
        TemplateDTO template = new TemplateDTO();

        // 构造Header
        template.setHeader(this.getTemplateHeader());

        // 构造商品 goods
        template.setGoods(this.getTemplateGoods());

        // 构造其它 title
        template.setOtherTitle(this.getTemplateOtherTitle());

        // 构造其它 商品内容
        template.setOthers(this.getTemplateOther());

        // 构造账单 bills
        template.setBill(this.getTemplateBills());

        // 构造尾部 footer
        template.setFooter(this.getTemplateFooter());

        return JSON.toJSONString(template);
    }

    public List<Text> getTemplateHeader() {
        List<Text> headers = new ArrayList<>();
        headers.add(new Text(0, 0, 1, "{$billTitle}", 2, true, false));
        headers.add(getCutLine());
        headers.add(new Text(0, 1, 0, "**", 1, false, false));
        headers.add(new Text(0, 1, 0, "#{$orderSerialNo}{$orderTitle}", 2, false, false));
        headers.add(new Text(0, 1, 1, "**", 1, false, false));
        headers.add(new Text(0, 1, 2, "*{$storeName}*", 1, false, false));
        headers.add(new Text(0, 0, 1, "{$orderSubmitDatetime}", 1, false, false));
        headers.add(getCutLine());
        headers.add(new Text(0, 0, 2, "{$orderMemo}", 2, true, false));
        headers.add(getStarLineText());
        headers.add(new Text(0, 1, 2, "----------- {$pocketName} -----------", 1, true, false));
        return headers;
    }

    public List<Goods> getTemplateGoods() {
        // 以下部分商品名、数量、单价、金额是列名，没有打印出来
        return Arrays.asList(
                new Goods("商品名", 0, 16, "name"),
                new Goods("数量", 2, 4, "num"),
                new Goods("单价", 2, 6, "price"),
                new Goods("金额", 2, 6, "pay")
        );
    }

    public List<Text> getTemplateOtherTitle() {
        return Collections.singletonList(
                new Text(0, 1, 1, "------------- {$otherName} -------------", 1, false, false));
    }

    public List<Goods> getTemplateOther() {
        // 以下部分商品名和金额是列名，没有打印出来
        return Arrays.asList(
                new Goods("商品名", 0, 26, "name"),
                new Goods("金额", 2, 6, "pay")
        );
    }

    public List<Text> getTemplateBills() {
        return Arrays.asList(
                new Text(0, 1, 2, "********************************", 1, false, false),
                new Text(0, 2, 1, "{$originPrice}", 1, false, false),
                new Text(0, 1, 0, "{$paymentMethod}", 1, false, false),
                new Text(0, 2, 1, "{$paymentPrice}", 2, true, false),
                getCutLine()
        );
    }

    public List<Text> getTemplateFooter() {
        return Arrays.asList(

                new Text(0, 0, 1, "{$customer}", 2, true, false),
                new Text(0, 0, 1, "{$customerContact}", 2, true, false),
                new Text(2, 1, 1, "{$qrCode}", 1, false, false),
                new Text(1, 1, 1, "{$barCode}", 1, false, false),
                new Text(0, 1, 0, "**********", 1, false, false),
                new Text(0, 1, 0, "#{$orderSerialNo}{$completedText}", 2, false, false),
                new Text(0, 1, 1, "**********", 1, false, false)
        );
    }


    public Text getStarLineText() {
        Text text = new Text();
        text.setText("********************************");
        text.setFormat(0);
        text.setSize(1);
        text.setBold(false);
        text.setLine(1);
        text.setType(0);
        return text;
    }

    public Text getCutLine() {
        Text text = new Text();
        text.setText("--------------------------------");
        text.setFormat(0);
        text.setSize(1);
        text.setBold(false);
        text.setLine(1);
        text.setType(0);
        return text;

    }


}
