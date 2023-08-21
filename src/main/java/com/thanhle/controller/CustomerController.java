package com.thanhle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.thanhle.domain.Customer;
import com.thanhle.service.CustomerService;
import com.thanhle.service.UserService;

//@RestController
@Controller
@RequestMapping("/customers")
public class CustomerController {
	@Autowired CustomerService customerService;
	@Autowired UserService userService;
	
	@PostMapping("/save")
	public String saveCustomer(Customer customer, Model model) {
	    Customer savedCustomer = customerService.saveCustomer(customer);

	    model.addAttribute("message", "Customer saved successfully");
	    model.addAttribute("customers", customerService.getAllCustomers());
	    return "redirect:/customers/create/" + savedCustomer.getCustomerId();
	}

	@GetMapping
	public String getCustomer(Customer customer, Model model) {
		model.addAttribute("customers", customerService.getAllCustomers());
		
		model.addAttribute("users", userService.getAllUsers());
		
	    return "customerForm";
	}
	
	
	@GetMapping("/create/{customerId}")
	public String createAccount(@PathVariable Long customerId, Model model) {
	    // Find the customer and add it to the model
	    Customer customer = customerService.findById(customerId);
	    model.addAttribute("customer", customer);

	    // Return the name of the JSP that contains the account creation form
	    return "accountForm";
	}

	
	/*
	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
	@GetMapping("/{customerId}")
	public Customer getCustomerById(@PathVariable Long customerId) {
		return customerService.getCustomerById(customerId);
	}
	
	@PutMapping("/{customerId}") 
	public Customer updateCustomer(@PathVariable Long customerId, @RequestBody Customer newCustomer) {
		return customerService.updateCustomer(customerId, newCustomer);
	}
	
	@DeleteMapping("/{customerId}")
	public void deleteCustomer(@PathVariable Long customerId) {
		customerService.deleteCustomer(customerId);
	}
	*/
	
	
}
