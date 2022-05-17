package com.boot.example.service;

import com.boot.example.bean.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
public class UserService implements InitializingBean {



//	byType byName
//	@Autowired
	private OrderService orderService;


//	@Autowired
//	private JdbcTemplate jdbcTemplate;


	private User admin;


	@Autowired
	private UserService userService;

	/*public UserService() {
		System.out.println("无参构造");
	}*/

//	public UserService(OrderService orderService) {
//		this.orderService = orderService;
//		System.out.println("有参构造1");
//
//	}


//	前提 OrderService  User 得存在ioc容器中
//	如果是单例bean则先从单例池中找，如果没有，则创建Map<'OrderService',OrderService对象>
	/*
	* 怎么找？
	* 如果对象名不为 orderService 按对象名来找可能会找错
	* 如果按照类型去找，此时会找到3个OrderService类型的对象
	* 所以先byType--->byName，会找到一个或者找不到
	* */
//	@Autowired
//	public UserService(OrderService orderService3,User admin) {
//		this.orderService = orderService;
//		this.admin = admin;
//		System.out.println("有参构造2");
//
//	}

	@Override
	public void afterPropertiesSet() throws Exception {
		//		mysql-->user对象-->this.admin
//		afterPropertiesSet 依赖注入之后 查数据库的时候会用到 UserMapper这样的接口来执行sql
		System.out.println("afterPropertiesSet");

	}

	@PostConstruct
	public void init(){
//		mysql-->user对象-->this.admin
		System.out.println("PostConstruct");

	}


//	@Transactional
	public void test(){
		System.out.println("test");
//		jdbcTemplate.execute("insert into tbl_student_salary values (12,'afa1',10000)");
//		此时是普通对象调用test即不是代理对象执行a(), 所以并不会检查a()方法上是否有@Transactional 注解，即Propagation.NEVER
//		不会抛异常
		/*
		* 解决方法：
		* 1. 新建一个类 a() 写在新建的类中
		* 2. 自己注入自己 userService.a();
		* */
//		方法是private也会失效 cglib动态代理是基于父子类继承的，private方法不能被子类继承
		a();
	}

//	@Transactional(propagation = Propagation.NEVER)
	public void a(){
//		jdbcTemplate.execute("insert into tbl_student_salary values (13,'afa2',10000)");
	}

}
