package com.webstack.configuration;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.webstack.bean.HelloBean;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.webstack.bean,com.webstack.repository")
@PropertySource("classpath:db.properties")
public class AppConfig {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private DataSource dataSource;

	@Bean("helloBean")
	@Lazy
	public HelloBean getHelloBean() {		
		return new HelloBean("Hello Radhe Krishna...");
	}
	
	@Bean("datasource")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setDriverClassName(env.getProperty("db.driverClassName"));
		dataSource.setUsername(env.getProperty("db.userName"));
		dataSource.setPassword(env.getProperty("db.password"));
		
		return dataSource;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource);		
	}
	
	
	@Bean
	public PlatformTransactionManager transactionManager() {
	      DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
	      transactionManager.setDataSource(dataSource);
	      return transactionManager;
	}
	
}
