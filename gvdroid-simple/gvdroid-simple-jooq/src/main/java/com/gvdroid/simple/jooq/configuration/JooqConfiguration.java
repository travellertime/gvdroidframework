package com.gvdroid.simple.jooq.configuration;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

@Configuration
public class JooqConfiguration {

    @Bean
    public DSLContext dslContext(org.jooq.Configuration configuration) {
        return DSL.using(configuration);
    }

    @Bean
    public org.jooq.Configuration configuration(DataSource dataSource) {
        TransactionAwareDataSourceProxy dataSourceProxy = new TransactionAwareDataSourceProxy(dataSource);
        DataSourceConnectionProvider connectionProvider = new DataSourceConnectionProvider(dataSourceProxy);
        org.jooq.Configuration configuration = new DefaultConfiguration();
        configuration.set(dataSource);
        configuration.set(SQLDialect.MYSQL);
        configuration.set(connectionProvider);
        return configuration;
    }

}
