package com.acer.redisdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acer.redisdemo.entity.User;
import com.acer.redisdemo.service.UserService;

@RestController
@RequestMapping("/user")
public class HelloController {
	@Autowired
	UserService userService; 

	@GetMapping("/all")
	public List<User> index() {
		return userService.getAllUsers();
	}
	
	
	
	



}
