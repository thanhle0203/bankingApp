package com.thanhle.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

//@RestController
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
	

	
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{userId}")
	public User getUserById(@PathVariable Long userId) {
		return userService.getUserById(userId);
	}
	
	@PutMapping("/{userId}")
	public User updateUser(@PathVariable Long userId, @RequestBody User user) {
		return userService.updateUser(userId, user);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginPage() {
		return "loginForm";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLogic(@RequestParam String userName, @RequestParam String password, @RequestParam Long roleId, Model model) {
		
		return "redirect:/home"; 
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET) 
	public String signupPage() {
		return "signupForm";
	}
	
	/*
	@PostMapping("/save")
	  public String saveUser(User user, Model model) {
	        userService.saveUser(user);
	        model.addAttribute("message", "User saved successfully");
	        model.addAttribute("users", userRepository.findAll());
	        return "signupForm";
	          
	}
	*/
	
	@PostMapping("/save")
	public String saveUser(User user, @RequestParam String role, Model model) {
	    userService.saveUser(user, role);

	    model.addAttribute("message", "User saved successfully");
	    model.addAttribute("users", userService.getAllUsers());
	    return "signupForm";
	}

	


	
}
