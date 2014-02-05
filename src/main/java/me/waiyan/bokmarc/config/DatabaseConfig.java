package me.waiyan.bokmarc.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
	/*
	 * Basic DB Information
	 * */
	private static final String DATABASE_DRIVER_NAME="com.mysql.jdbc.Driver";
	private static final String DATABASE_URL="jdbc:mysql://localhost:3306/BookmarkDB";
	private static final String DATABASE_USERNAME="root";
	private static final String DATABASE_PASSWORD="root";
	
	/*
	 * Hibernate Related DB Information
	 * */
	private static final String HIBERNATE_DIALECT="org.hibernate.dialect.MySQLDialect";
	private static final String HIBERNATE_SHOW_SQL="hibernate.show_sql";
	private static final String HIBERNATE_PACKAGES_TO_SCAN="me.waiyan.bokmarc.dao";
	
	@Autowired
	private Environment env;
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		 LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		 sessionFactory.setDataSource(getDataSource());
		 sessionFactory.setPackagesToScan(env.getProperty(HIBERNATE_PACKAGES_TO_SCAN));
		 sessionFactory.setHibernateProperties(getHibernateProperties());
		 
		 return sessionFactory;
	}
	
	@Bean
	public DataSource getDataSource(){
		BasicDataSource dataSource=new BasicDataSource();
		
		dataSource.setDriverClassName(env.getProperty(DATABASE_DRIVER_NAME));
		dataSource.setUrl(env.getProperty(DATABASE_URL));
		dataSource.setUsername(env.getProperty(DATABASE_USERNAME));
		dataSource.setPassword(env.getProperty(DATABASE_PASSWORD));
		
		return dataSource;
	}
	
	private Properties getHibernateProperties(){
		Properties prop=new Properties();
		prop.put(HIBERNATE_DIALECT, env.getProperty(HIBERNATE_DIALECT));
		prop.put(HIBERNATE_SHOW_SQL, env.getProperty(HIBERNATE_SHOW_SQL));
		
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
