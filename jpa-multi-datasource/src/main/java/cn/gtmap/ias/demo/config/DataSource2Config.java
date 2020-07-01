package cn.gtmap.ias.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * 数据源2
 * @author zenglihuan
 * @version 1.0.0
 * @since 2020/5/11 16:21
 **/
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactory2",
        transactionManagerRef = "transactionManager2",
        basePackages = "${spring.jpa.jpa2.repositoryPackage}")
public class DataSource2Config {

    @Autowired
    @Qualifier("dataSource2")
    private DataSource dataSource;

    @Autowired
    private JpaProperties jpaProperties;

    @Value("${spring.jpa.jpa2.entityPackage}")
    private String entityPackage;

    @Value("${spring.jpa.jpa2.persistenceUnit}")
    private String persistenceUnit;

    @Bean(name = "entityManager2")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactory(builder).getObject().createEntityManager();
    }

    /**
     * persistenceUnit：持久化单元，相当于持久化工厂名，不同持久化工厂需要不同的持久化单元
     * @param builder
     * @return
     */
    @Bean(name = "entityManagerFactory2")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .properties(getVendorProperties())
                .packages(entityPackage)
                .persistenceUnit(persistenceUnit)
                .build();
    }

    @Bean(name = "transactionManager2")
    public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactory(builder).getObject());
    }

    private Map<String, Object> getVendorProperties() {
        return jpaProperties.getHibernateProperties(new HibernateSettings());
    }

}
