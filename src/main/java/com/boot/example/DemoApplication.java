package com.boot.example;


import com.boot.example.service.AService;
import com.boot.example.service.OrderService;
import com.boot.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);

//		Bean的实例化 就是新建一个对象，Bean的初始化就是执行afterPropertiesSet
//		Bean的生命周期: Bean创建的生命周期 和 Bean销毁的生命周期
//		Spring如何创建一个Bean对象(Bean创建的生命周期)
		/*
		* UserService类-->
		* (推断构造方法)无参构造方法(如果只有一个构造方法，则调用；如果有多个同时有无参构造，则调用无参，其他则报错(除非用@AutoWired指定使用哪个))-->
		* 普通对象-->
		* 依赖注入-->判断属性上是否有@Autowired注解 要给对象中的哪些属性赋值
		* 初始化前(@PostConstruct)-->
		* 初始化(InitializingBean调用afterPropertiesSet())-->
		* 初始化后(AOP)-->
		* 代理对象-->此之后spring并没有再给代理对象依赖注入，所以UserService类中的属性在代理对象中是空的
		* 放入单例池Map(代理对象)-->
		* Bean
		* 1:24:59
		*
		* */


//		单例池本质上是一个Map
		/*UserService userService = (UserService)run.getBean("userService");  //Map<beanName,Bean对象>
		UserService userService2 = (UserService)run.getBean("userService");
		UserService userService3 = (UserService)run.getBean("userService");
		userService.test();*/

		/*OrderService orderService = (OrderService)run.getBean("orderService");
		OrderService orderService1 = (OrderService)run.getBean("orderService1");
		OrderService orderService2 = (OrderService)run.getBean("orderService2");

		System.out.println(orderService);
		System.out.println(orderService1);
		System.out.println(orderService2);*/


//		依赖注入步骤  判断属性上是否有@Autowired注解 要给对象中的哪些属性赋值
		/*UserService userService1 = new UserService();
		for (Field field:userService1.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(Autowired.class)){
				field.set(userService1,new Object());
			}
		}*/

//		初始化前步骤 判断方法上是否有@PostConstruct注解
		/*for (Method method:userService1.getClass().getDeclaredMethods()) {
			if (method.isAnnotationPresent(PostConstruct.class)){
				method.invoke(userService1, (Object) null);
			}
		}*/

//		初始化步骤 判断是否实现的某个接口(InitializingBean)  bean instanceof InitializingBean

		/*
		* 代理对象步骤
		* UserServiceProxy对象 即是 UserService的代理对象----> UserService target = 普通对象
		*
		* class UserServiceProxy extends UserService {
		*
		* 	UserService target;
		*
		* 	public void test(){
		* 		// @Before切面逻辑
		*		// target.test()
		*
		* 		//@Transactional注解
		* 		//1.事务管理器新建一个数据库连接conn  放进 ThreadLocal<Map<DataSource,conn>>中
		* 		//2.conn.autoCommit = false
		* 		// target.test()  jdbcTemplate中的dataSource 在 事务管理器中的ThreadLocal里存在
		* 		// 则拿到并执行 sql1,sql2,拿不到就会自己新建连接，新建的连接autoCommit = true，事务失效
		* 		// 抛了异常(默认是RuntimeException  和Error) conn.rollback,没有则 conn.commit
		* 	}
		* }
		* */


//		如果前两个字母都是大写，就不会进行首字母小写
		AService aService = (AService) run.getBean("AService");
		aService.test();

	}

}
