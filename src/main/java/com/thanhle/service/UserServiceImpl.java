package com.thanhle.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanhle.domain.Role;
import com.thanhle.domain.User;
import com.thanhle.repository.RoleRepository;
import com.thanhle.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired UserRepository userRepository;
	@Autowired RoleRepository roleRepository;

	@Override
	public User saveUser(User user, String role) {
		Role selectedRole = roleRepository.findById(role.equals("ADMIN") ? 1L : 2L)
			.orElseThrow(() -> new IllegalArgumentException("Invalid role selected: " + role));
		user.setRoles(Collections.singletonList(selectedRole));
		
		if (user.getUserId() != null && userRepository.existsById(user.getUserId())) {
			throw new IllegalArgumentException("User ID already exists");
		}
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long userId) {
		
		return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User ID not found"));
	}

	@Override
	public User updateUser(Long userId, User userUpdates) {
		Optional<User> existingUserOptional = userRepository.findById(userId);
		
		if (existingUserOptional.isPresent()) {
			User existingUser = existingUserOptional.get();
			// Update fields of the existing user as necessary
			existingUser.setUserName(userUpdates.getUserName());
			existingUser.setPassword(userUpdates.getPassword());
			//existingUser.setRoles(userUpdates.getRoles());
			
			// Fetch roles from userUpdades
			List<Role> updatedRoles = userUpdates.getRoles();
			List<Role> rolesToSet = new ArrayList<>();
			
			for (Role updatedRole : updatedRoles) {
				Optional<Role> existingRole = roleRepository.findById(updatedRole.getRoleId());
				
				if (existingRole.isPresent()) {
					rolesToSet.add(existingRole.get());
				}
			}
			
			// Set the updated roles
			existingUser.setRoles(rolesToSet);
			
			return userRepository.save(existingUser);
		
			
		} else {
			throw new IllegalArgumentException("User ID not found");
		}	
		
	}

	@Override
	public void deleteUser(Long userId) {
		if (!userRepository.existsById(userId)) {
			throw new IllegalArgumentException("User ID not found");
		}
		
		userRepository.deleteById(userId);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
