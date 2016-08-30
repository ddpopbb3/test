package com.spring.dao;

import java.util.List;

import com.spring.domain.LoginCommand;
import com.spring.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    int getMatchUser(LoginCommand loginCommand);

	User selectByName(String name);

	int isExistUser(String name);
	
	List<User> getAll();
}