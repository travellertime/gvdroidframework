package com.gvdroid.simple.print.params;

/**
 * 商品属性配置参数
 *
 * @author SubLuLu
 */
public class Goods {

    public Goods() {}
    public Goods(String name, int format, int width, String variable) {
        this.name = name;
        this.format = format;
        this.width = width;
        this.variable = variable;
    }

    // 属性名称
    private String name;
    // 对齐方式 居左、居中、居右
    private int format;
    // 占半角字符宽度 58mm 每行32 80mm 每行48
    private int width;
    // 占位符 格式${time}
    private String variable;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFormat() {
        return format;
    }

    public void setFormat(int format) {
        this.format = format;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }
}
