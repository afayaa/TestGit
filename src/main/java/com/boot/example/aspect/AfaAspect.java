package com.boot.example.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfaAspect {

	@Before("execution(public void com.boot.example.service.UserService.test())")
	public void afaBefore(JoinPoint joinPoint){
		System.out.println("before");
	}
}
