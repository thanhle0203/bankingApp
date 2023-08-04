package com.thanhle.service;

import java.util.List;

import com.thanhle.domain.BankTransaction;
import com.thanhle.domain.TransactionType;

public interface BankTransactionService {
	BankTransaction findById(Long id);
	List<BankTransaction> findAll();
	BankTransaction save(BankTransaction transaction);
	void delete(Long id);
	List<BankTransaction> findByType(TransactionType type);

}
