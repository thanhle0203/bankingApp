package com.thanhle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.thanhle.domain.Customer;
import com.thanhle.exception.CustomerBadRequestException;
import com.thanhle.service.CustomerService;
import com.thanhle.service.UserService;

import jakarta.validation.Valid;

@RestController
//@Controller
@RequestMapping("/customers")
public class CustomerController {
	@Autowired CustomerService customerService;
	@Autowired UserService userService;
	
	// Get all customers
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return ResponseEntity.ok(customerService.getAllCustomers());
	}
	
	// Get customer by ID
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
		Customer customer = customerService.findById(customerId);
		if (customer != null)  {
			return ResponseEntity.ok(customer);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	// Create a new customer
	//@PostMapping
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
		/*
		if (customer.getCustomerId() != null && customerService.existsById(customer.getCustomerId())) {
			throw new CustomerBadRequestException("Customer ID should be null when creating a new customer.");
		}
		
		Customer savedCustomer = customerService.saveCustomer(customer);
		return ResponseEntity.ok(savedCustomer);
		
		*/
		
		
		try {
			Customer savedCustomer = customerService.saveCustomer(customer);
			return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(null);
		}
		
	}
	
	// Update an existing customer
	@PutMapping("/{customerId}")
	public ResponseEntity<Customer> updatedCustomer(@PathVariable Long customerId, @RequestBody Customer updatedCustomer) {
		if (!customerId.equals(updatedCustomer.getCustomerId())) {
			throw new CustomerBadRequestException("Path ID does not match the customer ID in the request body.");
		}
		
		Customer customer = customerService.updateCustomer(customerId, updatedCustomer);
		return ResponseEntity.ok(customer);
		
		/*
		try {
			Customer customer = customerService.updateCustomer(customerId, updatedCustomer);
			return ResponseEntity.ok(customer);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(null);
		}
		*/
	}
	
	// Delete a customer
	@DeleteMapping("/{customerId}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId) {
		try {
			customerService.deleteCustomer(customerId);
			return ResponseEntity.noContent().build();
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	// Set user for a customer by userId 
	@PostMapping("/{customerId}/setUser/{userId}")
	public ResponseEntity<Customer> setCustomerUserByUserId(@PathVariable Long customerId, @PathVariable Long userId) {
		Customer updatedCustomer = customerService.setCustomerUserByUserId(customerId, userId);
		if (updatedCustomer != null) {
			return ResponseEntity.ok(updatedCustomer);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	/*
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
	*/


	
	
}
