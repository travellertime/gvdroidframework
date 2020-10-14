package com.gvdroidframework.base.component;

/**
 * 分页对象
 * 使用mybatis plus组件，该类会在后续版本移除。
 *
 * @author Colin
 * @since 1.0.0
 */
public class Page {

    /**
     * 总记录数，自动返回，请勿设置
     */
    private int count;

    /**
     * 一页显示的数据量
     */
    private int pageSize = 0;

    /**
     * 当前处于第几页
     */
    private int pageNum = 0;

    /**
     * 排序字段
     */
    private String orderBy;


    /**
     * 是否需要返回
     */
    private boolean returnCount;

    public void setReturnCount(boolean returnCount) {
        this.returnCount = returnCount;
    }

    public boolean getReturnCount() {
        return returnCount;
    }

    public Page() {
        returnCount = true;
    }

    /**
     * 构造器
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条
     */
    public Page(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        returnCount = true;
    }

    /**
     * 构造器
     *
     * @param pageSize 第几页
     * @param pageNum  每页多少条
     * @param orderBy  例如: name desc
     */
    public Page(int pageNum, int pageSize, String orderBy) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.orderBy = orderBy;
        returnCount = true;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public int getOffset() {
        return (pageNum - 1) * pageSize;
    }

    /**
     * 当前最终的大小
     *
     * @return offset + pageSize
     */
    public int getLimit() {
        return getOffset() + pageSize;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

}
