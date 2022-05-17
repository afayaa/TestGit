package com.boot.example.controller;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {

	@GetMapping("/car/{id}/owner/{userName}")
	public Map<String,Object> getCar(@PathVariable("id") Integer id,
									 @PathVariable("userName") String userName,
									 @PathVariable Map<String,String> pv,
									 @RequestHeader("User-Agent") String userAgent,
									 @RequestHeader Map<String,String> headers,
									 @RequestParam("age") Integer age,
									 @RequestParam("inters") List<String> inters,
									 @RequestParam MultiValueMap<String,Object> requestParam,
									 @CookieValue("iplat.theme") String theme,
									 @CookieValue("iplat.theme") Cookie cookie,
									 HttpServletRequest request,
									 @RequestPart("headerImg") MultipartFile headerImg,
									 @RequestPart("photos") MultipartFile[] photos){

//		文件上传
//		headerImg.transferTo();
		Cookie[] cookies = request.getCookies();
		HttpSession session = request.getSession();
		String jsessionid = (String)(session.getAttribute("jsessionid"));
		System.out.println(jsessionid);
		System.out.println("===========");

		for (Cookie cookie1:cookies
			 ) {
			System.out.println(cookie1.getName() + "---" + cookie1.getValue());
			System.out.println(cookie1);
		}

		Map<String,Object> map = new HashMap<>();
//		map.put("id",id);
//		map.put("name",userName);
//		map.put("pv",pv);
//
//		map.put("userAgent",userAgent);
//		map.put("headers",headers);
//
//		map.put("age",age);
//		map.put("inters",inters);
//		map.put("requestParam",requestParam);

		map.put("theme",theme);
		map.put("cookie",cookie);
		System.out.println(cookie);
		System.out.println(cookie.getName());
		return map;
	}


	@PostMapping("/save")
	public Map postMethod(@RequestBody String requestBody){
		Map<String,Object> map = new HashMap<>();
		map.put("requestBody",requestBody);

		return map;
	}


//	语法 /cars/sell;low=34;brand=byd,audi,yd
//	springBoot 默认是禁用了矩阵变量的功能
//	手动开启：原理： 对于路径的处理  urlPathHelper进行解析
//	removeSemicolonContent 移除分号内容
//	矩阵变量必须有url路劲变量才能被解析
	@GetMapping("/cars/{path}")
	public Map carSell(@MatrixVariable("low") Integer low,
					   @MatrixVariable("brand") List brand,
					   @MatrixVariable("jsessionid") String jsessionid,
					   @PathVariable("path") String path,
					   HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setAttribute("jsessionid",jsessionid);


		Map<String,Object> map = new HashMap<>();
		map.put("low",low);
		map.put("brand",brand);
		map.put("path",path);
		map.put("jsessionid",jsessionid);


		return map;
	}


	@GetMapping("/boss/{bossId}/{empId}")
	public Map boss(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
					@MatrixVariable(value = "age",pathVar = "empId") Integer empAge,
					@PathVariable("bossId") String bossId,
					@PathVariable("empId") String empId){

		Map<String,Object> map = new HashMap<>();
		map.put("bossAge",bossAge);
		map.put("empAge",empAge);
		map.put("bossId",bossId);
		map.put("empId",empId);
		return map;
	}
}
