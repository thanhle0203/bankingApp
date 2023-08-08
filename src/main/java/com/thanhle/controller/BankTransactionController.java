package com.thanhle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thanhle.domain.BankTransaction;
import com.thanhle.domain.TransactionType;
import com.thanhle.service.BankTransactionService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/bankTransactions")
public class BankTransactionController {
	
	@Autowired
	private BankTransactionService bankTransactionService;
	
	@GetMapping("/transaction")
	public String showTransactionForm(Model model) {
		model.addAttribute("transaction", new BankTransaction());
		model.addAttribute("transactions", bankTransactionService.findAllTransactions());
		return "bankTransactionForm";
	}
	
	@PostMapping("/transaction")
	public String createTransaction(@RequestParam Long fromAccountId, @RequestParam Long toAccountId, @RequestParam double amount, TransactionType transactionType, RedirectAttributes redirectAttributes, Model model) {
	
		
		try {
			BankTransaction savedTransaction = bankTransactionService.createTransaction(fromAccountId, toAccountId, amount, transactionType);
			model.addAttribute("transactions", savedTransaction);
			model.addAttribute("transactions", bankTransactionService.findAllTransactions());
			
			return "redirect:/transactions";
		} catch (IllegalArgumentException e) {
			redirectAttributes.addFlashAttribute("error", e.getMessage());
			return "redirect:/bankTransactions/transaction";
		}
	}

}
