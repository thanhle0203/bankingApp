package com.thanhle.service;

import java.util.List;

import com.thanhle.domain.Customer;

public interface CustomerService {
	Customer saveCustomer(Customer customer);
	Customer getCustomerById(Long customerId);
	Customer updateCustomer(Long customerId, Customer customer);
	void deleteCustomer(Long customerId);
	public List<Customer> getAllCustomers();
	Customer findById(Long customerId);
	
}
