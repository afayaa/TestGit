package com.boot.example.springboot.boot;



import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@MySpringBootApplication

public class MySpringApplication {

	public static ConfigurableApplicationContext run(Class config) {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(config);
		applicationContext.refresh();

		startTomcat(applicationContext);

		return applicationContext;
	}


	private static Tomcat startTomcat(AnnotationConfigWebApplicationContext applicationContext){
		Tomcat tomcat = new Tomcat();

		Server server = tomcat.getServer();
		Service service = server.findService("Tomcat");
		Connector connector = new Connector();
		connector.setPort(8081);

		Engine engine = new StandardEngine();
		engine.setDefaultHost("localhost");

		Host host = new StandardHost();
		host.setName("localhost");

		String contextPath = "";
		Context context = new StandardContext();
		context.setPath(contextPath);
		context.addLifecycleListener(new Tomcat.FixContextListener());

		host.addChild(context);
		engine.addChild(host);

		service.setContainer(engine);
		service.addConnector(connector);


//		从spring 容器中获取
//		applicationContext.getBean(DispatcherServlet.class);

//		springBoot如何选择Tomcat 还是Jetty
		/*
		* pom文件中有tomcat依赖，那么类路径中就会有tomcat相关的类，
		* spring在初始化bean的时候，通过@conditionalOnClass注解来判断，存在相关的类，才注册比如tomcat bean
		* 如果没有找到，或者找到了多个（pom 文件中同时存在 tomcat和jetty依赖）就会报错
		* */


//		@conditionalOnClass如何工作的
		/*
		* 如何判断类上有注解表示这个类是一个bean?
		* 先加载类，再通过反射？
		* 如果有100个类，只有1个类是spring需要的bean，spring扫描的时候就要全部把100个类加载进jvm，但有用的只要1个
		* 其实是通过asm 技术，来判断类上有什么注解，所以@conditionalOnClass注解里面的class条件在不存在的时候不会报错
		* 通过asm，读取到了@conditionalOnClass注解里依赖的几个class条件
		* 然后 applicationContext.getClassLoad().loadClass(""); 通过类加载器，能加载就表示有这个类
		*
		* */
		tomcat.addServlet(contextPath,"dispatcher",new DispatcherServlet(applicationContext));
		context.addServletMappingDecoded("/*","dispatcher");

		try{
			tomcat.start();
		}catch (LifecycleException e){
			e.printStackTrace();
		}

//		Thread thread = new Thread(() -> {
//			tomcat.getServer().await();
//		});
//		thread.setDaemon(false);
//		thread.start();  p23 1:45

		return tomcat;
	}
}
