package com.spring.serviceimpl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.dao.UserMapper;
import com.spring.domain.LoginCommand;
import com.spring.domain.User;
import com.spring.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	
	@Override
	public User selectByPrimaryKey(Integer userid) {
//		System.out.println("Before");
		User user = userMapper.selectByPrimaryKey(userid);
//		System.out.println("After");
		return user;
	}

	@Override
	public Boolean hasMatchUser(LoginCommand loginCommand) {
		int count = userMapper.getMatchUser(loginCommand);
		return count>0;
	}

	@Override
	public User selectByName(String name) {
//		System.out.println("Before");
		User user = userMapper.selectByName(name);
//		System.out.println("After");
		return user;
	}

	@Override
	public int insert(User record) {
		return userMapper.insert(record);
	}

	@Override
	public boolean isExistUser(String name) {
		int flag = userMapper.isExistUser(name);
		return flag>0;
	}

	@Override
	public List<User> getAll() {
		return userMapper.getAll();
	}

}
