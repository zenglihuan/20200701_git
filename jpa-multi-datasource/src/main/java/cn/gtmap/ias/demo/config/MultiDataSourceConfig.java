package cn.gtmap.ias.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 配置多数据源
 * @author zenglihuan
 * @version 1.0.0
 * @since 2020/5/11 16:21
 **/
@Configuration
public class MultiDataSourceConfig {

    @Primary
    @Bean(name = "dataSource1")
    @Qualifier("dataSource1")
    public DataSource dataSource1() {
        return dataSource1Properties().initializeDataSourceBuilder().build();
    }

    @Bean(name = "dataSource2")
    @Qualifier("dataSource2")
    public DataSource dataSource2() {
        return dataSource2Properties().initializeDataSourceBuilder().build();
    }

    /**
     * 重新创建DataSourceProperties，是为了防止读取spring.datasource数据源配置
     * @return
     */
    @Primary
    @Bean(name = "dataSource1Properties")
    @Qualifier("dataSource1Properties")
    @ConfigurationProperties(prefix = "spring.datasource.datasource1")
    public DataSourceProperties dataSource1Properties(){
        return new DataSourceProperties();
    }

    @Bean(name = "dataSource2Properties")
    @Qualifier("dataSource2Properties")
    @ConfigurationProperties(prefix = "spring.datasource.datasource2")
    public DataSourceProperties dataSource2Properties(){
        return new DataSourceProperties();
    }

}
