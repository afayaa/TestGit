package com.boot.example.springboot;

import com.boot.example.springboot.boot.MySpringApplication;
import com.boot.example.springboot.boot.MySpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

@MySpringBootApplication
public class Test {

	@Bean
	public DispatcherServlet dispatcherServlet(){
		DispatcherServlet dispatcherServlet = new DispatcherServlet();
		return dispatcherServlet;
	}

	public static void main(String[] args){
		MySpringApplication.run(Test.class);
	}
}
