package com.acer.redisdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acer.redisdemo.entity.User;
import com.acer.redisdemo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService; 

	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{userId}")
	public User getUser(@PathVariable String userId) {
		Integer Id;
		if ("patrick".equals(userId)) {
			Id = 1;
		} else if ("charles".equals(userId)) {
			Id = 2;
		} else {
			Id = 3;
		}
		
		return userService.findById(Id);
	}
	
	@GetMapping("/clearAllUsers")
	public String clearAllUsersCache () {
		userService.clearAllUserCache();
		return "success";
	}
	
	@GetMapping("/clear/{userId}")
	public String clearSingelUserCache( @PathVariable String userId) {
		if ("patrick".equals(userId)) {
			userService.clear(1);
		} else if ("charles".equals(userId)) {
			userService.clear(2);
		} else {
			userService.clear(3);
		}
		return "success";
		
	}
	
	
	
	
	
	



}
