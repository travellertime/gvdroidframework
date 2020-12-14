package com.gvdroidframework.redis;


import java.io.Serializable;


/***
 *
 * 商品缓存子对象
 *
 * @author TuJun
 */
public class ItemsCacheSubDTO implements Serializable {

    private static final long serialVersionUID = 1419458647573945030L;

    /**
     * 语言
     */
    String language;

    /**
     * 商品列表MD5
     */
    String itemsMd5;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getItemsMd5() {
        return itemsMd5;
    }

    public void setItemsMd5(String itemsMd5) {
        this.itemsMd5 = itemsMd5;
    }

    @Override
    public String toString() {
        return "ItemsCacheSubDTO{" +
                "language='" + language + '\'' +
                ", itemsMd5='" + itemsMd5 + '\'' +
                '}';
    }
}
