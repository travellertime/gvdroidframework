package com.gvdroid.simple.print.dto;

import java.util.List;

public class ParamDTO {
    private ParamKeysDTO keys;
    private List<ParamGoodsDTO> goods;
    private List<ParamOtherDTO> others;

    public ParamKeysDTO getKeys() {
        return keys;
    }

    public void setKeys(ParamKeysDTO keys) {
        this.keys = keys;
    }

    public List<ParamGoodsDTO> getGoods() {
        return goods;
    }

    public void setGoods(List<ParamGoodsDTO> goods) {
        this.goods = goods;
    }

    public List<ParamOtherDTO> getOthers() {
        return others;
    }

    public void setOthers(List<ParamOtherDTO> others) {
        this.others = others;
    }
}
