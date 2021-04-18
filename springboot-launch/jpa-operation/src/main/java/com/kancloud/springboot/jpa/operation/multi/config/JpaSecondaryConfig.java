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
 * @author xschen
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "secondaryEntityManagerFactoryBean",
        transactionManagerRef = "secondaryTransactionManager",
        basePackages = {"com.kancloud.springboot.jpa.operation.multi.dao.testdb2"}
)
public class JpaSecondaryConfig {

    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    private HibernateProperties hibernateProperties;

    /**
     * 数据源
     * @return
     */
    @Bean(name = "secondaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary") // 使用application.yaml的primary数据源配置
    public DataSource secondaryDatasource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 实体管理器
     * @param builder
     * @return
     */
    @Bean(name = "secondaryEntityManager")
    public EntityManager secondaryEntityManager(EntityManagerFactoryBuilder builder) {
        return secondaryEntityManagerFactoryBean(builder).getObject().createEntityManager();
    }

    /**
     * 实体管理器工厂
     * @param builder
     * @return
     */
    @Bean(name = "secondaryEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
        Map<String, Object> properties = hibernateProperties.determineHibernateProperties(
                jpaProperties.getProperties(),
                new HibernateSettings());

        return builder.dataSource(secondaryDatasource())
                .properties(properties)
                .packages("com.kancloud.springboot.jpa.operation.multi.dao.testdb2")
                .persistenceUnit("secondaryPersistenceUnit")
                .build();
    }

    /**
     * 事务管理器
     * @param builder
     * @return
     */
    @Primary
    @Bean(name = "secondaryTransactionManager")
    public PlatformTransactionManager secondaryTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(secondaryEntityManagerFactoryBean(builder).getObject());
    }
}
