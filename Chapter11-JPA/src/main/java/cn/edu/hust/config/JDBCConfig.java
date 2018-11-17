package cn.edu.hust.config;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 *  使用注解的方式配置Hibernate的FactoryBean
 */
@Configuration
public class JDBCConfig {
    //需要使用hibernate时去除注解
    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(DataSource dataSource)
    {
        LocalSessionFactoryBean localSessionFactoryBean=new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.setPackagesToScan(new String[] {"cn.edu.hust.bean"});
        Properties properties=new Properties();
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        localSessionFactoryBean.setHibernateProperties(properties);
        return localSessionFactoryBean;
    }

    @Bean
    public BeanPostProcessor beanPostProcessor()
    {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
