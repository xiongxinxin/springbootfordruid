package com.xxx.springbootfordruid.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.xxx.springbootfordruid.dao.UserMapper;
import com.xxx.springbootfordruid.model.User;
import com.xxx.springbootfordruid.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	@Cacheable( cacheNames="adminInfo", key = "#p0")
	public User getUserById(String userId) {
		User user = userMapper.selectByPrimaryKey(Long.parseLong(userId));

		return user;
	}

}
