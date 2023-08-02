package com.thanhle.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.thanhle.domain.Address;
import com.thanhle.domain.Customer;
import com.thanhle.domain.Role;
import com.thanhle.domain.User;
import com.thanhle.service.CustomerService;
import com.thanhle.service.RoleService;
import com.thanhle.service.UserService;

//@RestController
@Controller
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
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
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String handleSignup(User user, Customer customer, Address address) {
	    Role defaultRole = roleService.findByRoleName("User");
	    if (defaultRole == null) {
	    	// Log the error
	    	System.out.println("User role not found in database");
	    }

	    user.setRoles(Collections.singletonList(defaultRole));
	    User savedUser = userService.saveUser(user);
	    
	    customer.setUser(savedUser);
	    customer.setCustomerAddress(address);
	    customerService.saveCustomer(customer);
	   
	    return "redirect:/login";
	}

	
}
