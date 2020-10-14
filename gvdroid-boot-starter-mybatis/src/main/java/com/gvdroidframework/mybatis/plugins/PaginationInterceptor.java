package com.gvdroidframework.mybatis.plugins;

import com.gvdroidframework.mybatis.dialect.Dialect;
import com.gvdroidframework.mybatis.dialect.MysqlDialect;
import com.gvdroidframework.util.ClassUtils;
import com.gvdroidframework.base.component.Page;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * 分页拦截器
 *
 * @author Colin
 * @since 1.0.0
 */
@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})
public class PaginationInterceptor implements Interceptor {

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
        StatementHandler delegate = (StatementHandler) ClassUtils.getFieldValue(handler, "delegate");
        BoundSql boundSql = delegate.getBoundSql();
        Object parameterObject = boundSql.getParameterObject();
        if (parameterObject instanceof MapperMethod.ParamMap) {
            MapperMethod.ParamMap<Object> paramMap = (MapperMethod.ParamMap) parameterObject;
            if (paramMap.containsKey("page") && paramMap.get("page") != null) {
                Page page = (Page) paramMap.get("page");
                if (page.getReturnCount()) {
                    MappedStatement mappedStatement = (MappedStatement) ClassUtils.getFieldValue(delegate, "mappedStatement");
                    Connection connection = (Connection) invocation.getArgs()[0];
                    totalCount(connection, boundSql, mappedStatement, page);
                }
                final int pageSize = page.getPageSize() > 0 ? page.getPageSize() : 10;
                final int offset = pageSize * (page.getPageNum() >= 1 ? page.getPageNum() - 1 : 0);

//                ClassUtils.setFieldValue(boundSql, "sql", MessageFormat.format("{0} LIMIT {1},{2}", boundSql.getSql(), offset, pageSize));
                ClassUtils.setFieldValue(boundSql, "sql", searchDialectByDbTypeEnum(page).spellPageSql(boundSql.getSql(), offset, pageSize));
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void totalCount(Connection conn, BoundSql boundSql, MappedStatement mappedStatement, Page page) throws SQLException {

        String sql = boundSql.getSql().toLowerCase();
        String countSpellSql = getCountSql(sql);

        Configuration configuration = mappedStatement.getConfiguration();

        PreparedStatement preparedStatement = conn.prepareStatement(countSpellSql);
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        Object parameterObject = boundSql.getParameterObject();
        new BoundSql(configuration, countSpellSql, parameterMappings, parameterObject);

        ErrorContext.instance().activity("setting parameters").object(mappedStatement.getParameterMap().getId());
        if (null != parameterMappings) {
            TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
            MetaObject metaObject = parameterObject == null ? null : configuration.newMetaObject(parameterObject);
            for (int i = 0; i < parameterMappings.size(); i++) {
                ParameterMapping parameterMapping = parameterMappings.get(i);
                if (parameterMapping.getMode() != ParameterMode.OUT) {
                    String propertyName = parameterMapping.getProperty();
                    PropertyTokenizer prop = new PropertyTokenizer(propertyName);
                    Object propValue;
                    if (parameterObject == null) {
                        propValue = null;
                    } else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                        propValue = parameterObject;
                    } else if (boundSql.hasAdditionalParameter(propertyName)) {
                        propValue = boundSql.getAdditionalParameter(propertyName);
                    } else if (propertyName.startsWith(ForEachSqlNode.ITEM_PREFIX) && boundSql.hasAdditionalParameter(prop.getName())) {
                        propValue = boundSql.getAdditionalParameter(prop.getName());
                        if (propValue != null) {
                            propValue = configuration.newMetaObject(propValue).getValue(propertyName.substring(prop.getName().length()));
                        }
                    } else {
                        propValue = metaObject == null ? null : metaObject.getValue(propertyName);
                    }

                    TypeHandler typeHandler = parameterMapping.getTypeHandler();
                    if (typeHandler == null) {
                        throw new ExecutorException("There was no TypeHandler found for parameter " + propertyName + " of statement " + mappedStatement.getId());
                    }
                    typeHandler.setParameter(preparedStatement, i + 1, propValue, parameterMapping.getJdbcType());
                }
            }
        }

        ResultSet rs = preparedStatement.executeQuery();
        int totalCount = 0;
        try {
            if (rs.next()) {
                totalCount = rs.getInt(1);
            }
        } finally {
            if (!rs.isClosed())
                rs.close();
        }
        page.setCount(totalCount);
    }


    /**
     * 获取总数
     *
     * @param sql 可执行SQL
     * @return 获取总数的可执行SQL
     */
    public String getCountSql(String sql) {
        return "SELECT COUNT(0) FROM (" + sql + ") TEMP";
    }

    /**
     * 获取方言对象
     *
     * @param page Page
     * @return 方言对象
     */
    private Dialect searchDialectByDbTypeEnum(Page page) {
        return new MysqlDialect(page.getOrderBy());
    }
}
