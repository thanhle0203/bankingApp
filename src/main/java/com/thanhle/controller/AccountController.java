package com.thanhle.controller;

import com.thanhle.domain.Account;
import com.thanhle.domain.AccountType;
import com.thanhle.domain.Customer;
import com.thanhle.service.AccountService;
import com.thanhle.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;
    
    @Autowired
    private CustomerService customerService;
    
 // Create a new account
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
    	try {
    		Account createdAccount = accountService.createAccount(account);
    		return ResponseEntity.ok(createdAccount);
    	} catch (IllegalArgumentException e) {
    		return ResponseEntity.badRequest().build();
    	}
 
    }

    // Get all accounts
    @GetMapping("/getAll")
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(accountService.findAllAccounts());
    }

    // Get account by id
    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long accountId) {
        Account account = accountService.findAccountById(accountId);
        if (account != null) {
            return ResponseEntity.ok(account);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update an account
    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long accountId, @RequestBody Account updatedAccount) {
    	if (!accountId.equals(updatedAccount.getAccountId())) {
    		return ResponseEntity.badRequest().build();
    	}

        return ResponseEntity.ok(accountService.updateAccount(updatedAccount));
    }

    // Delete an account
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

    // Get accounts by type
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Account>> getAccountsByType(@PathVariable AccountType type) {
        return ResponseEntity.ok(accountService.findByAccountType(type));
    }

    // Get accounts by customer id
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Account>> getAccountsByCustomerId(@PathVariable Long customerId) {
        return ResponseEntity.ok(accountService.findAccountsByCustomerId(customerId));
    }
    
    @GetMapping
	public String getAccountForm(Model model) {
		
	    model.addAttribute("accounts", accountService.findAllAccounts());
	    return "accountForm";
	}
    
    @PostMapping("/save/{customerId}")
	public String saveAccount(Account account, @PathVariable Long customerId, Model model) {
    	
    	Customer customer = customerService.findById(customerId);
		if (customer == null) {
			return "error";
		}
		
	    account.setAccountCustomer(customer);
	    Account createdAccount = accountService.createAccount(account);
		
		model.addAttribute("customer", customer);
	    model.addAttribute("account", "Account saved successfully");
	    model.addAttribute("accounts", accountService.findAllAccounts());
	    return "redirect:/bankTransactions/transaction/" + createdAccount.getAccountId();
	}

	@GetMapping("/create/{customerId}")
	public String createAccountForm(Account account, @PathVariable Long customerId, Model model) {
		Customer customer = customerService.findById(customerId);
		if (customer == null) {
			return "error";
		}
		
		model.addAttribute("customer", customer);
	    model.addAttribute("accounts", accountService.findAllAccounts());
	    return "accountForm";
	}
	
	

	
}
