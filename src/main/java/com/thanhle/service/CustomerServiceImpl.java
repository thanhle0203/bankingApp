package com.thanhle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanhle.domain.Account;
import com.thanhle.domain.Customer;
import com.thanhle.domain.User;
import com.thanhle.repository.CustomerRepository;
import com.thanhle.repository.UserRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Customer saveCustomer(Customer customer) {
		if (customer.getCustomerId() != null && customerRepository.existsById(customer.getCustomerId())) {
			throw new IllegalArgumentException("Customer ID already exists");
		}
		
		// Optionally create a user if it doesn't exist
		User user = customer.getUser();
		if (user != null && user.getUserId() == null) {
			userRepository.save(user);
			customer.setUser(user);
		}
		
		// Save or update the associated Accounts
		List<Account> accounts = customer.getCustomerAccounts();
		if (accounts != null) {
			for (Account account : accounts) {
				account.setAccountCustomer(customer);
			}
		}
		
		return customerRepository.save(customer);
	}
	
	public Customer setCustomerUserByUserId(Long customerId, Long userId) {
		Customer customer = getCustomerById(customerId);
		User user = getUserById(userId);
		customer.setUser(user);
		return customerRepository.save(customer);
	}

	private User getUserById(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerById(Long customerId) {
		return customerRepository.findById(customerId).orElseThrow(() -> new IllegalArgumentException("Customer ID not found"));
	}

	@Override
	public Customer updateCustomer(Long customerId, Customer newCustomer) {
		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new IllegalArgumentException("Customer ID not found"));
	
		// Update the associated User if it has changed
		User user = newCustomer.getUser();
		if (user != null) {
			userRepository.save(user);
		}
		// Get fields you want to update
		customer.setCustomerName(newCustomer.getCustomerName());
		customer.setCustomerGender(newCustomer.getCustomerGender());
		customer.setCustomerDob(newCustomer.getCustomerDob());
	    customer.setCustomerMobileNum(newCustomer.getCustomerMobileNum());
	    customer.setCustomerAddress(newCustomer.getCustomerAddress());
	    customer.setUser(newCustomer.getUser());
	    
		return customerRepository.save(customer);
	}

	@Override
	public void deleteCustomer(Long customerId) {
		if (!customerRepository.existsById(customerId)) {
			throw new IllegalArgumentException("Customer ID not found");
		}
		
		customerRepository.deleteById(customerId);
		
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(Long customerId) {
		Optional<Customer> existingCustomer = customerRepository.findById(customerId);
		if (existingCustomer.isPresent()) {
			return existingCustomer.get();
		}
		else {
			return null;
		}
	}
	
	

}
