package com.itheima.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import com.itheima.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

	//注入Mapper接口
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findByName(String name) {
		return userMapper.findByName(name);
	}

	@Override
	public User queryById(Integer id) {
		return null;
	}

	@Override
	public List<User> queryAllByLimit(int offset, int limit) {
		return null;
	}

	@Override
	public User insert(User user) {
		return null;
	}

	@Override
	public User update(User user) {
		return null;
	}

	@Override
	public boolean deleteById(Integer id) {
		return false;
	}

	@Override
	public User findById(Integer id) {
		return userMapper.findById(id);
	}


}
