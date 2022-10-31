package com.acer.redisdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acer.redisdemo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	
}
