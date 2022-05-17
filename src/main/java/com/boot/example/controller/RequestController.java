package com.boot.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {

	@GetMapping("/goto")
	public String gotoPage(HttpServletRequest request){
		request.setAttribute("msg","成功了...");
		request.setAttribute("code",2000);

//		转发到 /success请求
		return "forward:/success";

	}


	@ResponseBody
	@GetMapping("/success")
	public Map success(@RequestAttribute("msg") String msg,
					   @RequestAttribute("code") String code,
					   HttpServletRequest request){

		Object msg1 = request.getAttribute("msg");
		Object code1 = request.getAttribute("code");

		Map<String,Object> map = new HashMap<>();
		map.put("msg1",msg1);
		map.put("code1",code1);
		map.put("code",code);
		map.put("msg",msg);


		return map;

	}
}
