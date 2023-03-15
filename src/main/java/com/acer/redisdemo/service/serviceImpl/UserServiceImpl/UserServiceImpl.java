package com.acer.redisdemo.service.serviceImpl.UserServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.acer.redisdemo.dao.UserRepository;
import com.acer.redisdemo.entity.User;
import com.acer.redisdemo.service.UserService;

@Service
@CacheConfig(cacheNames = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userDao;

	@Override
	@Cacheable(value = "AllUsers")
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	@CacheEvict(value = "AllUsers", allEntries = true)
	public void clearAllUserCache() {

	}

	@Override
	@Cacheable(value = "user", key ="#p0")
	public User findById(Integer pId) {
		Optional<User> _User = userDao.findById(pId);
		System.out.println("從資料庫查找完.....");
		return Optional.ofNullable(_User).get().orElse(null);
	}

	@CacheEvict(value = "user", key = "#p0")
	public void clear(Integer pId) {

	}
}
