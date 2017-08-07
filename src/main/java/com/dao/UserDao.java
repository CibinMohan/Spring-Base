package com.dao;

import java.util.List;

public interface UserDao {
	public void persist(Object obj);
	public <T> List<T> getAll(Class<T> clazz);
}
