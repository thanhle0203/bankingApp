package com.thanhle.service;

import java.util.List;

import com.thanhle.domain.User;

public interface UserService {
	//public User saveUser(User user);
	public User getUserById(Long userId);
	public User updateUser(Long userId, User userUpdates);
	public void deleteUser(Long userId);
	public List<User> getAllUsers();
	User saveUser(User user, String role);
	
}
