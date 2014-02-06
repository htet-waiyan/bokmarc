package me.waiyan.bokmarc.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:jdbc.properties" })
@ComponentScan({"me.waiyan.bokmarc.dao"})
public class DatabaseConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		
		 LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		 sessionFactory.setDataSource(getDataSource());
		 sessionFactory.setPackagesToScan(new String[]{"me.waiyan.bokmarc.model"});
		 sessionFactory.setHibernateProperties(getHibernateProperties());
		 
		 return sessionFactory;
	}
	
	@Bean
	public DataSource getDataSource(){
		BasicDataSource dataSource=new BasicDataSource();
		
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.pass"));
		
		return dataSource;
	}
	
	private Properties getHibernateProperties(){
		Properties prop=new Properties();
		prop.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		prop.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		prop.put("hibernate.globally_quoted_identifiers", "true");
		
		return prop;
	}
	
	public HibernateTransactionManager getTransactionManager(){
		HibernateTransactionManager txManager=new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory().getObject());
		
		return txManager;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslator(){
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
