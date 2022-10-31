package com.acer.redisdemo.service.serviceImpl.UserServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acer.redisdemo.dao.UserRepository;
import com.acer.redisdemo.entity.User;
import com.acer.redisdemo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userDao;

	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public User findById(Integer pId) {
		Optional<User>_User = userDao.findById(pId);
		System.out.println("從資料庫查完...");
		return Optional.ofNullable(_User).get().orElse(null);
	}

	@Override
	public void clearAllUserCache() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear(Integer pId) {
		// TODO Auto-generated method stub
		
	}

}
