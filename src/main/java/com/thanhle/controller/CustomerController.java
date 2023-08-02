package com.thanhle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.thanhle.domain.Customer;
import com.thanhle.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired CustomerService customerService;
	
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
}
