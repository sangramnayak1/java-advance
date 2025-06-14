package com.sang.java.spring.app.user.dao;

import java.util.List;

import com.sang.java.spring.app.user.model.User;

public interface UserDao {

	User findById(Integer id);

	List<User> findAll();

	void save(User user);

	void update(User user);

	void delete(Integer id);
}
