package com.thanhle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thanhle.domain.BankTransaction;
import com.thanhle.domain.TransactionType;
import com.thanhle.service.BankTransactionService;

@RestController
@RequestMapping("/api/bankTransactions")
public class BankTransactionController {
	
	@Autowired
	private BankTransactionService bankTransactionService;
	
	@GetMapping("/{id}")
	public ResponseEntity<BankTransaction> findById(@PathVariable Long id) {
		return ResponseEntity.ok(bankTransactionService.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<BankTransaction>> findAll() {
		return ResponseEntity.ok(bankTransactionService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<BankTransaction> save(@RequestBody BankTransaction transaction) {
		return ResponseEntity.ok(bankTransactionService.save(transaction));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		bankTransactionService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/type/{type}") 
	public ResponseEntity<List<BankTransaction>> findByType(@PathVariable TransactionType type) {
		return ResponseEntity.ok(bankTransactionService.findByType(type));
	}

}
