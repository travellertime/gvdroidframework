/*
 * Copyright 2014-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gvdroidframework.mybatis.dialect;


import com.mysql.cj.util.StringUtils;

public class MysqlDialect extends Dialect {

    private final String orderBy;

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
//        buffer.append(" SELECT ROW_.* FROM (").append(sql).append(" limit ").append(offset).append(",").append(limit).append(") ROW_");
        buffer.append(sql).append(" limit ").append(offset).append(",").append(limit);

        return buffer.toString();
    }

}
