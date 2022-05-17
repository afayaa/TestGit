package com.boot.example.controller;

import bushuai.service.AfaService;
import com.boot.example.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	/*
	* @AutoWired写在变量上的注入要等到类完全加载后，才会将相应的bean注入，而变量是在加载类的时候按照顺序加载的，
	* 所以变量的加载要早于被@AutoWired注解的变量
	* 即下面注释的age 一行会报空指针，可以先声明变量，在后期调用方法的时候去初始化，此时构造函数已经执行完毕，即
	* 已经注入bean。
	* java变量的初始化顺序: 静态变量或静态语句块->实例变量或初始化语句块->构造函数->@AutoWired注入bean
	* */
	private Person person;

//	private int age = person.getAge();

	@RequestMapping("/hello")
	public Person hello(){
		System.out.println(person.getUserName());
		return person;
	}

	/*
	*
	* 只要将静态资源放在类路径下： /static (or /public or
	*	/resources or /META-INF/resources)  访问：当前项目根路径/ + 静态资源名
	* 原理： 静态资源映射 /**
	*	请求进来，先去找Controller看能不能处理，不能处理的所有请求又都交给静态资源处理器，能找到就返回
	*
	* */
	@RequestMapping("/redis.png")
	public String hello1(){

		return "redis";
	}

	@Autowired
	AfaService afaService;


	@GetMapping("/say")
	public String say(){
		return afaService.getWords("wu~");
	}

}
