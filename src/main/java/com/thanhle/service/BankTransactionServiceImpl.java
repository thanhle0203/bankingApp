package com.thanhle.service;

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

	@Override
	public BankTransaction createTransaction(BankTransaction transaction) {
		Account fromAccount = transaction.getBankTransactionFromAccount();
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
	
		return bankTransactionRepository.findTransactionsByAccountId(accountId);
	}

	

}
