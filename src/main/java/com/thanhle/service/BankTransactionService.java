package com.thanhle.service;

import java.util.List;

import com.thanhle.domain.BankTransaction;
import com.thanhle.domain.TransactionType;

public interface BankTransactionService {
	BankTransaction findTransactionById(Long transactionId);
	List<BankTransaction> findAllTransactions();
	BankTransaction createTransaction(BankTransaction transaction);
	void deleteTransaction(Long transactionId);
	BankTransaction updateTransaction(BankTransaction transaction);
	List<BankTransaction> findTransactionsByAccountId(Long accountId);

}
