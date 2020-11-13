package com.lorance.ogel.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

@Configuration
public class DBConfiguration {

    @Value("${jdbcUrl}")
    String jdbcUrl;

    @Value("${dataSource.user}")
    String username;

    @Value("${dataSource.password}")
    String password;

    @Value("${dataSourceClassName}")
    String classname;

    @Bean
    public DataSource getDataSource() {

        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(jdbcUrl);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setDriverClassName(classname);

        return ds;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(getDataSource());
    }

}
