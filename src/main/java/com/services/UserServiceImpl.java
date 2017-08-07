package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.domain.User;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Transactional
	public void persist(User user) {
		userDao.persist(user);
		
	}

	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAll(User.class);
	}

}
