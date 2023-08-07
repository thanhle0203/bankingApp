package com.thanhle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thanhle.domain.BankTransaction;
import com.thanhle.domain.TransactionType;
import com.thanhle.service.BankTransactionService;

@RestController
@RequestMapping("/bankTransactions")
public class BankTransactionController {
	
	@Autowired
	private BankTransactionService bankTransactionService;
	
	@GetMapping("/transaction")
	public String showTransactionForm(Model model) {
		model.addAttribute("transaction", new BankTransaction());
		return "bankTransactionForm";
	}
	
	@PostMapping("/transaction")
	public String createTransaction(@ModelAttribute BankTransaction transaction, Model model) {
		BankTransaction savedTransaction = bankTransactionService.createTransaction(transaction);
		model.addAllAttribute("transaction", savedTransaction);
		return "redirect:/transactions";
	}

}
