package com.sang.java.spring.app.user.service;

import java.util.List;

import com.sang.java.spring.app.user.model.User;

public interface UserService {

	User findById(Integer id);

	List<User> findAll();

	void saveOrUpdate(User user);

	void delete(int id);
}
