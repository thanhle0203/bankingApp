package com.thanhle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thanhle.domain.BankTransaction;
import com.thanhle.domain.TransactionType;
import com.thanhle.repository.BankTransactionRepository;

@Service
public class BankTransactionServiceImpl implements BankTransactionService {
	
	@Autowired
	private BankTransactionRepository bankTransactionRepository;

	@Override
	public BankTransaction findById(Long id) {
	
		return bankTransactionRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public List<BankTransaction> findAll() {
		return bankTransactionRepository.findAll();
	}

	@Override
	@Transactional
	public BankTransaction save(BankTransaction transaction) {
	
		return bankTransactionRepository.save(transaction);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		bankTransactionRepository.deleteById(id);
		
	}

	@Override
	@Transactional
	public List<BankTransaction> findByType(TransactionType type) {
		return bankTransactionRepository.findByTransactionType(type);
	}

}
