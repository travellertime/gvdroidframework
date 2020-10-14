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

//    /**
//     * 获取总数
//     *
//     * @param sql
//     * @return
//     */
//    public String getCountSql(String sql) {
//        //将sql语句中的两个字段中间的值替换
////        String tempsql = sql.toLowerCase();
////        int begingIndex = tempsql.indexOf("select") + 6, endIndex = tempsql.indexOf("from");
////        if (begingIndex > -1 && endIndex > -1)
////            sql = sql.replace(sql.substring(begingIndex, endIndex), " COUNT(0) ");
////        return "SELECT TEMP.* FROM (" + sql + ") TEMP";
//
//        return "SELECT COUNT(0) FROM (" + sql + ") TEMP";
//    }


}
