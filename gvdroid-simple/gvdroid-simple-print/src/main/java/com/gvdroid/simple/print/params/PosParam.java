package com.gvdroid.simple.print.params;

import java.util.List;
import java.util.Map;

/**
 * 需要打印的参数
 *
 * @author SubLuLu
 */
public class PosParam {

    // 替换模板中占位符的参数
    private Map<String, Object> keys;
    // 商品信息参数集合
    private List<Map<String, Object>> goods;

    private List<Map<String, Object>> others;

    public Map<String, Object> getKeys() {
        return keys;
    }

    public void setKeys(Map<String, Object> keys) {
        this.keys = keys;
    }

    public List<Map<String, Object>> getGoods() {
        return goods;
    }

    public void setGoods(List<Map<String, Object>> goods) {
        this.goods = goods;
    }

    public List<Map<String, Object>> getOthers() {
        return others;
    }

    public void setOthers(List<Map<String, Object>> others) {
        this.others = others;
    }
}
