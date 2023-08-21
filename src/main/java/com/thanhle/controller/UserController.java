package com.thanhle.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.thanhle.DTO.SignupForm;
import com.thanhle.domain.Address;
import com.thanhle.domain.Branch;
import com.thanhle.domain.Customer;
import com.thanhle.domain.Role;
import com.thanhle.domain.User;
import com.thanhle.repository.UserRepository;
import com.thanhle.service.CustomerService;
import com.thanhle.service.RoleService;
import com.thanhle.service.UserService;

@RestController
@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private RoleService roleService;
	
	
	// Create a new user
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user, @RequestParam(name="role", defaultValue="USER") String role) {
		try {
			User savedUser = userService.saveUser(user, role);
			return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
			
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	// Get a specific user by ID
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable Long userId) {
		try {
			User user = userService.getUserById(userId);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	// Update a user by ID
	@PutMapping("/{userId}")
	public ResponseEntity<User> updatedUser(@PathVariable Long userId, @RequestBody User userUpdates) {
		try {
			User updatedUser = userService.updateUser(userId, userUpdates);
			return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	
	// Delete a user by Id
	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> deletedUser(@PathVariable Long userId) {
		try {
			userService.deleteUser(userId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	// Get all users
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	/*

	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginPage() {
		return "loginForm";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLogic(@RequestParam String userName, @RequestParam String password, @RequestParam Long roleId, Model model) {
		
		return "redirect:/home"; 
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET) 
	public String signupPage(Model model) {
		
		return "signupForm";
	}
	

	
	@PostMapping("/save")
	public String saveUser(User user, @RequestParam String role, Model model) {
	    userService.saveUser(user, role);

	    model.addAttribute("message", "User saved successfully");
	    model.addAttribute("users", userService.getAllUsers());
	    return "signupForm";
	}

	@GetMapping
	public String saveUser(User user, Model model) {
	    model.addAttribute("users", userService.getAllUsers());
	    return "signupForm";
	}
	
	*/


	
}
