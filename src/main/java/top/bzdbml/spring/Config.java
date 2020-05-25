package top.bzdbml.spring;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(value = "top.bzdbml")
public class Config {

    @Bean
    public DriverManagerDataSource getDriverManagerDataSource() {
        DriverManagerDataSource source = new DriverManagerDataSource();

        source.setDriverClassName("com.mysql.cj.jdbc.Driver");
        source.setPassword("zhuxiang");
        source.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC");
        source.setUsername("root");

        return source;
    }

    @Bean
    public SqlSessionFactoryBean getSqlSession() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setTypeAliasesPackage("top.bzdbml.entity");
        bean.setDataSource(getDriverManagerDataSource());
        return bean;
    }

    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("top.bzdbml.mybatis");
        return configurer;
    }


}
