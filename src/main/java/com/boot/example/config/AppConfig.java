package com.boot.example.config;

import com.boot.example.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@ComponentScan("com.boot.example")
//AppConfig代理对象 proxyBeanMethods = true  Bean设置为单例
@Configuration(proxyBeanMethods = true)
@EnableAspectJAutoProxy
@EnableAsync
//@EnableTransactionManagement
public class AppConfig {


/*
* OrderService是一个单例bean 并不是说jvm中只有一个OrderService类型的对象，和单例模式不是一回事
* */
	/*@Bean
	public OrderService orderService1(){
		return new OrderService();
	}

	@Bean
	public OrderService orderService2(){
		return new OrderService();
	}*/


/*	@Bean
	public JdbcTemplate jdbcTemplate(){
		return new JdbcTemplate(dataSource());
	}


	@Bean
	public PlatformTransactionManager transactionManager(){
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}


	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}*/



}
