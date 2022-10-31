package com.acer.redisdemo.service;

import java.util.List;

import com.acer.redisdemo.entity.User;


public interface UserService {
	List<User> getAllUsers();

    User findById(Integer pId);
    
    void clearAllUserCache();
    
    void clear(Integer pId);
}
