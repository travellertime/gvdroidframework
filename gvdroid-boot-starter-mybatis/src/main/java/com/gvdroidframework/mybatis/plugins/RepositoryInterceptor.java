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
package com.gvdroidframework.mybatis.plugins;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandlerRegistry;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

/**
 * SQL执行过程拦截器
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class RepositoryInterceptor implements Interceptor {

    private static final String PROCESS_REPOSITORY_BEGIN = "Process repository begin...";
    private static final String PROCESS_REPOSITORY_END = "Process repository end.";
    private static final String PROCESS_REPOSITORY_TIME_UNIT = "ms";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        final MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        final Log log = mappedStatement.getStatementLog();
        if (!log.isDebugEnabled() && !log.isDebugEnabled()) {
            return invocation.proceed();
        }

        long startTime = System.currentTimeMillis();
        final Object parameter = invocation.getArgs().length > 1 ? invocation.getArgs()[1] : null;
        final BoundSql boundSql = mappedStatement.getBoundSql(parameter);

        log.debug(PROCESS_REPOSITORY_BEGIN);
        log.debug("execute sql : [ " + getSql(mappedStatement.getConfiguration(), boundSql) + " ]");

        final Object returnValue = invocation.proceed();
        log.debug(PROCESS_REPOSITORY_END + " Elapsed:" + (System.currentTimeMillis() - startTime) + PROCESS_REPOSITORY_TIME_UNIT);

        return returnValue;
    }


    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }


    private String getSql(final Configuration configuration, final BoundSql boundSql) {
        Object parameterObject = boundSql.getParameterObject();
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        String sql = boundSql.getSql().replaceAll("[\\s]+", " ");
        if (parameterMappings.size() > 0 && parameterObject != null) {
            TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
            if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                sql = sql.replaceFirst("\\?", getParameterValue(parameterObject));
            } else {
                MetaObject metaObject = configuration.newMetaObject(parameterObject);
                for (ParameterMapping parameterMapping : parameterMappings) {
                    String propertyName = parameterMapping.getProperty();
                    if (metaObject.hasGetter(propertyName)) {
                        Object obj = metaObject.getValue(propertyName);
                        sql = sql.replaceFirst("\\?", getParameterValue(obj));
                    } else if (boundSql.hasAdditionalParameter(propertyName)) {
                        Object obj = boundSql.getAdditionalParameter(propertyName);
                        sql = sql.replaceFirst("\\?", getParameterValue(obj));
                    }
                }
            }
        }
        return sql;
    }

    private String getParameterValue(final Object obj) {
        String value;
        if (null != obj) {
            if (obj instanceof String) {
                value = "'" + obj.toString() + "'";
            } else if (obj instanceof Date) {
                DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.CHINA);
                value = "'" + formatter.format(new Date()) + "'";
            } else {
                value = obj.toString();
            }
        } else {
            value = "";
        }
        return value;
    }

}
