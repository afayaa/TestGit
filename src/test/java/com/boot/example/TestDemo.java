package com.boot.example;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("单元测试类")
public class TestDemo {

	@Test
	@DisplayName("测试方法1")
	void test1(){
		System.out.println(1);
	}
}
