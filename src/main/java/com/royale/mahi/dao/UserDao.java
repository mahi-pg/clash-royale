package com.royale.mahi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.royale.mahi.client.UserMapper;
import com.royale.mahi.model.User;

@Repository
public class UserDao {

	@Autowired
	UserMapper mapper;
	
	public User getUserByPrimary(String userId) {
		return mapper.selectByPrimaryKey(userId);
	}
}
