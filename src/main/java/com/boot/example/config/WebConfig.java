package com.boot.example.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

@Configuration(proxyBeanMethods = false)
public class WebConfig /*implements WebMvcConfigurer*/ {


//	改变默认的method
	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
		HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
		hiddenHttpMethodFilter.setMethodParam("_m");
		return hiddenHttpMethodFilter;
	}

	/*@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		UrlPathHelper urlPathHelper = new UrlPathHelper();
//		不移除; 后内容  矩阵变量可以生效
		urlPathHelper.setRemoveSemicolonContent(false);

		configurer.setUrlPathHelper(urlPathHelper);
	}*/


	@Bean
	public WebMvcConfigurer webMvcConfigurer(){
		return new WebMvcConfigurer(){
			@Override
			public void configurePathMatch(PathMatchConfigurer configurer){
				UrlPathHelper urlPathHelper = new UrlPathHelper();
				urlPathHelper.setRemoveSemicolonContent(false);
				configurer.setUrlPathHelper(urlPathHelper);
			}
		};
	}
}
