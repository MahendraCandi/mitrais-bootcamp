package com.mahendracandi.learnJdbc.config;

import com.mahendracandi.learnJdbc.properties.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.mahendracandi.learnJdbc")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Autowired
    private AppProperties appProperties;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(appProperties.getJdbcDirverClassName());
        dataSource.setUrl(appProperties.getJdbcUrl());
        dataSource.setUsername(appProperties.getJdbcUsername());
        //dataSource.setPassword(appProperties.getJdbcPassword() == null ? "" : appProperties.getJdbcUrl());

        return dataSource;
    }
}
