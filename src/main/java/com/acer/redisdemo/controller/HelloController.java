package com.acer.redisdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {
	@Autowired
	RedisTemplate redisTemplate; 

	@GetMapping("/index")
	public String index() {
		Boolean hasKey = redisTemplate.hasKey("1");
		return "Hello SpringBoot " + hasKey;
	}
	
	



}
