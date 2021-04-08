package com.kancloud.springboot.rdbms.operation.jdbc.multidatasource.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author xschen
 */

@Configuration
public class DataSourceConfig {

    @Bean(name = "primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary") // testdb
    public DataSource primaryDataSource() {
        return null;
    }
}
