package com.thanhle.service;

import com.thanhle.domain.Account;
import com.thanhle.domain.AccountType;

import java.util.List;

public interface AccountService {
    Account createAccount(AccountType type, double balance);
    Account findAccountById(Long accountId);
    List<Account> findAllAccounts();
    void deleteAccount(Long accountId);
    Account updateAccount(Account account);
    List<Account> findByAccountType(AccountType type);
    // Additional methods based on the requirements
}

