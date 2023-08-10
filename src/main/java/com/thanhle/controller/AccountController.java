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

//@RestController
@Controller
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;
    
    @Autowired
    private CustomerService customerService;
    
    @PostMapping("/save/{customerId}")
	public String saveAccount(Account account, @PathVariable Long customerId, Model model) {
    	
    	Customer customer = customerService.findById(customerId);
		if (customer == null) {
			return "error";
		}
		
	    account.setAccountCustomer(customer);
		accountService.createAccount(account);
		
		model.addAttribute("customer", customer);
	    model.addAttribute("account", "Account saved successfully");
	    model.addAttribute("accounts", accountService.findAllAccounts());
	    return "redirect:/someSuccessPage";
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
	
	
	
	@GetMapping("/create")
	public String createAccountForm(Model model) {
	    model.addAttribute("accounts", accountService.findAllAccounts());
	    return "accountForm";
	}
	

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.CREATED);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccount(@PathVariable Long accountId) {
        Account account = accountService.findAccountById(accountId);
        return account != null ? new ResponseEntity<>(account, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.findAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long accountId, @RequestBody Account account) {
        account.setAccountId(accountId);
        Account updatedAccount = accountService.updateAccount(account);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long accountId) {
        accountService.deleteAccount(accountId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/type")
    public ResponseEntity<List<Account>> findByAccountType(@RequestParam AccountType type) {
        List<Account> accounts = accountService.findByAccountType(type);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    // Additional endpoints as required...
}
