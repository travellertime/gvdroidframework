package com.gvdroidframework.mybatis.dialect;

/**
 * 支持的数据库方言
 */
public abstract class Dialect {

    public enum Type {
        MYSQL,
        ORACLE,
        SQLSERVER,
        DB2
    }

    public abstract String spellPageSql(String sql, int offset, int limit);
}
