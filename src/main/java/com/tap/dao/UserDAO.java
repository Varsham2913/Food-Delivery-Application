package com.tap.dao;

import java.sql.Timestamp;
import java.util.List;

import com.tap.model.User;

public interface UserDAO {
	void addUser(User user);
	User getUser(int userId);
	void updateUser(User user);
	void deleteUser(int userId);
	List<User>getAllUsers();
	User getUserByEmail(String email);
	boolean updateLastLoginDate(int userId, Timestamp lastLoginDate);
	
}
