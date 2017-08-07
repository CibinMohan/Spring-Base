package com.services;

import java.util.List;

import com.domain.User;

public interface UserService {
	
	public void persist(User user);
	public List<User> getAll();

}
