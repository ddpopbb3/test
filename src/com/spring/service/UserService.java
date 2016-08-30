package com.spring.service;


import java.util.List;

import com.spring.domain.LoginCommand;
import com.spring.domain.User;

public interface UserService {
	User selectByPrimaryKey(Integer userid);
	
	Boolean hasMatchUser(LoginCommand loginCommand);

	User selectByName(String name);
	
	int insert(User record);
	
	boolean isExistUser(String name);
	
	List<User> getAll();
}
