package com.gvdroid.simple.print.params;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * 模板配置参数
 *
 * @author SubLuLu
 */
public class PosTpl {

    private List<JSONObject> header;

    private List<Goods> goods;

    private List<JSONObject> otherTitle;

    private List<Goods> others;

    private List<JSONObject> bill;

    private List<JSONObject> footer;

    public List<JSONObject> getHeader() {
        return header;
    }

    public void setHeader(List<JSONObject> header) {
        this.header = header;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public List<JSONObject> getOtherTitle() {
        return otherTitle;
    }

    public void setOtherTitle(List<JSONObject> otherTitle) {
        this.otherTitle = otherTitle;
    }

    public List<Goods> getOthers() {
        return others;
    }

    public void setOthers(List<Goods> others) {
        this.others = others;
    }

    public List<JSONObject> getBill() {
        return bill;
    }

    public void setBill(List<JSONObject> bill) {
        this.bill = bill;
    }

    public List<JSONObject> getFooter() {
        return footer;
    }

    public void setFooter(List<JSONObject> footer) {
        this.footer = footer;
    }

}
