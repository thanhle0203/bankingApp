package com.thanhle.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thanhle.domain.Account;
import com.thanhle.domain.BankTransaction;
import com.thanhle.domain.TransactionType;
import com.thanhle.repository.BankTransactionRepository;

@Service
public class BankTransactionServiceImpl implements BankTransactionService {
	
	@Autowired
	private BankTransactionRepository bankTransactionRepository;
	
	@Autowired
	private AccountService accountService;
	

	@Override
	public BankTransaction createTransaction(Long fromAccountId, Long toAccountId, double amount, String comments, TransactionType transactionType) {
		Account fromAccount = null;
		Account toAccount = null;
		
		if (fromAccountId != null) {
			fromAccount = accountService.findAccountById(fromAccountId);
		}
		
		if (toAccountId != null) {
			toAccount = accountService.findAccountById(toAccountId);
		}
			
		
		
		if (fromAccount == null || toAccount == null) {
			throw new IllegalArgumentException("One or both of the accounts are not found");
		}
		
		if (amount <=0) {
			throw new IllegalArgumentException("Amount must be greater than 0");
		}
		
		// Deducting from "fromAccount" balance for widthrawal
		if (transactionType == TransactionType.WITHDRAWAL || transactionType == TransactionType.TRANSFER) {
			if (fromAccount == null) {
				throw new IllegalArgumentException("From account not found");
			}
			
			fromAccount.setAccountBalance(fromAccount.getAccountBalance() - amount);
			accountService.updateAccount(fromAccount);
		}
		
		// Adding to "toAccount" balance for deposit
		if (transactionType == TransactionType.DEPOSIT || transactionType == TransactionType.TRANSFER) {
			if (toAccount == null) {
				throw new IllegalArgumentException("To account not found");
			}
			
			toAccount.setAccountBalance(toAccount.getAccountBalance() + amount);
			accountService.updateAccount(toAccount);
		}
		
		
		
		// Recording transaction
		BankTransaction transaction = new BankTransaction();
		transaction.setBankTransactionFromAccount(fromAccount);
		transaction.setBankTransactionToAccount(toAccount);
		transaction.setTransactionAmount(amount);
		transaction.setTransactionType(transactionType);
		transaction.setComments(comments);
		transaction.setBankTransactionDateTime(LocalDateTime.now());
		
		return bankTransactionRepository.save(transaction);
	}
	
	@Override
	public BankTransaction findTransactionById(Long transactionId) {
		return bankTransactionRepository.findById(transactionId).orElse(null);
	}

	@Override
	public List<BankTransaction> findAllTransactions() {
		return bankTransactionRepository.findAll();
	}

	

	@Override
	public void deleteTransaction(Long transactionId) {
		bankTransactionRepository.deleteById(transactionId);
		
	}

	@Override
	public BankTransaction updateTransaction(BankTransaction transaction) {
		return bankTransactionRepository.save(transaction);
	}

	@Override
	public List<BankTransaction> findTransactionsByAccountId(Long accountId) {
	
		return bankTransactionRepository.findByBankTransactionFromAccount_AccountId(accountId);
	}

	

	

}
