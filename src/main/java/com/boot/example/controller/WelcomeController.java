package com.boot.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@RequestMapping(value = {"/","/index.html"})
	public String welcome(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return "index";
	}

	/*
	* 静态资源配置原理
	* springboot启动默认加载 xxxAutoConfiguration(自动配置类)
	* springMVC功能的自动配置类 WebMVCAutoConfiguration，
	*
	* */

	/*
	* 请求映射
	* xxxMapping;
	* Rest风格支持(使用HTTP请求方式动词来表示对资源的操作)
	* 	以前：/getUser 获取用户  /deleteUser 删除用户 /editUser 修改用户 /saveUser 保存用户
	* 	现在：/User GET-获取用户 DELETE-删除用户 PUT-修改用户 POST-保存用户
	* 	核心Filter： HiddenHttpMethodFilter
	* 		用法： 表单method=post,隐藏域 _method=put
	*
	* */

	/*
	* Rest原理(表单提交要使用REST的时候)
	*  	表单提交会带上 _method=PUT
	* 	请求过来被HiddenHttpMethodFilter拦截
	*		请求是否正常，并且是POST
	* 			获取到_method的值
	* 			兼容以下请求：PUT,DELETE,PATCH
	* 			原生request(post)，包装模式requestWrapper重写了getMethod()方法，返回的是传入的_method值
	* 			过滤器链放行的是wrapper，以后的方法调用getMethod是调用的requestWrapper的
	*
	* Rest使用客户端工具，
	* 	如PostMan直接发送Put、Delete等方式请求，无需HiddenHttpMethodFilter来包装
	* */

	@ResponseBody
//	@RequestMapping(value = "/user",method = RequestMethod.GET)
	@GetMapping(value = "/user")
	public String getUser(){
		return "GET";
	}

	@ResponseBody
	@RequestMapping(value = "/user",method = RequestMethod.DELETE)
	public String deleteUser(){
		return "DELETE";
	}

	@ResponseBody
	@RequestMapping(value = "/user",method = RequestMethod.PUT)
	public String putUser(){
		return "PUT";
	}

	@ResponseBody
	@RequestMapping(value = "/user",method = RequestMethod.POST)
	public String saveUser(){
		return "POST";
	}
}
