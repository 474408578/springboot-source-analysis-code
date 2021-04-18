package com.kancloud.springboot.jpa.operation.multi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * Jpa 数据持久层配置
 * @author xschen
 * @see DataSource
 * @see JpaProperties
 * @see HibernateProperties
 * @see EntityManager
 * @see LocalContainerEntityManagerFactoryBean
 * @see PlatformTransactionManager
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "primaryEntityManagerFactoryBean",
        transactionManagerRef = "primaryTransactionManager",
        basePackages = {"com.kancloud.springboot.jpa.operation.multi.dao.testdb"}
)
public class JpaPrimaryConfig {

    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    private HibernateProperties hibernateProperties;


    /**
     * 数据源
     * @return
     */
    @Primary
    @Bean(name = "primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary") // 使用application.yaml的primary数据源配置
    public DataSource primaryDatasource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 实体管理器
     * @param builder
     * @return
     */
    @Primary
    @Bean(name = "primaryEntityManager")
    public EntityManager primaryEntityManager(EntityManagerFactoryBuilder builder) {
        return primaryEntityManagerFactoryBean(builder).getObject().createEntityManager();
    }

    /**
     * 实体管理器工厂
     * @param builder
     * @return
     */
    @Primary
    @Bean(name = "primaryEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
        Map<String, Object> properties = hibernateProperties.determineHibernateProperties(
                jpaProperties.getProperties(),
                new HibernateSettings());

        return builder.dataSource(primaryDatasource())
                .properties(properties)
                .packages("com.kancloud.springboot.jpa.operation.multi.dao.testdb")
                .persistenceUnit("primaryPersistenceUnit")
                .build();
    }

    /**
     * 事务管理器
     * @param builder
     * @return
     */
    @Primary
    @Bean(name = "primaryTransactionManager")
    public PlatformTransactionManager primaryTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(primaryEntityManagerFactoryBean(builder).getObject());
    }



}
