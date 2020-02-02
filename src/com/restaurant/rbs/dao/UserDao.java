package com.restaurant.rbs.dao;

import java.util.List;

import com.restaurant.rbs.model.User;

public interface UserDao {

	int createUser(User user);
	int updateUser(User user);
	List<User> getAllUsers();
	void deleteUser(int id);
}
