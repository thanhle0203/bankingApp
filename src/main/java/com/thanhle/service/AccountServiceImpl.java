package com.thanhle.service;


import com.thanhle.domain.Account;
import com.thanhle.domain.AccountType;
import com.thanhle.repository.AccountRepository;
import com.thanhle.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    
    @Override
    public List<Account> findAccountsByCustomerId(Long customerId) {
    	return accountRepository.findAccountsByCustomerId(customerId);
    }
    


    @Override
    public Account createAccount(Account account) {
    	List<Account> customerAccounts = findAccountsByCustomerId(account.getAccountCustomer().getCustomerId());
    	for (Account existingAccount : customerAccounts) {
    		if (existingAccount.getAccountType().equals(account.getAccountType())) {
    			throw new IllegalArgumentException("Customer already has an account of type: " + account.getAccountType());
    		}
    	}
        return accountRepository.save(account);
    }

    @Override
    public Account findAccountById(Long accountId) {
        return accountRepository.findById(accountId).orElse(null);
    }

    @Override
    public List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }

    @Override
    public Account updateAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> findByAccountType(AccountType type) {
        return accountRepository.findByAccountType(type);
    }

    // Implementations of additional methods...
}
