package com.gvdroidframework.mybatis.dialect;


import com.mysql.cj.util.StringUtils;

public class MysqlDialect extends Dialect {

    private String orderBy;

    /**
     * 构造方法
     *
     * @param orderBy 类似 column1 desc , column2 asc
     */
    public MysqlDialect(String orderBy) {
        this.orderBy = orderBy;
    }

    @Override
    public String spellPageSql(String sql, int offset, int limit) {
        sql = sql.trim();
        StringBuilder buffer = new StringBuilder(sql.length() + 100);
        if (!StringUtils.isNullOrEmpty(orderBy)) {
            sql += " order by " + orderBy;
        }
        buffer.append(" SELECT ROW_.* FROM (").append(sql).append(" limit ").append(offset).append(",").append(limit).append(") ROW_");
        return buffer.toString();
    }

}
