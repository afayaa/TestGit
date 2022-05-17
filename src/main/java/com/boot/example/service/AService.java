package com.boot.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AService {


	@Autowired
	private BService bService;



	/*@Autowired
	public void setcService(CService cService) {
		this.cService = cService;
	}


	private CService cService;*/



	public void test(){
		System.out.println("---------" + bService);
//		System.out.println(cService);
	}
}
