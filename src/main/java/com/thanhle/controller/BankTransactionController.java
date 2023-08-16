package com.thanhle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thanhle.domain.Account;
import com.thanhle.domain.BankTransaction;
import com.thanhle.domain.TransactionType;
import com.thanhle.service.AccountService;
import com.thanhle.service.BankTransactionService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/bankTransactions")
public class BankTransactionController {
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private BankTransactionService bankTransactionService;
	
	@GetMapping("/transactions")
	public String showTransactionForm(Model model) {
		model.addAttribute("transaction", new BankTransaction());
		model.addAttribute("transactions", bankTransactionService.findAllTransactions());
		return "bankTransactionForm";
	}
	
	/*
	@GetMapping("/transaction/{accountId}")
	public String showTransactionForm(@PathVariable Long accountId, Model model) {
		Account account = accountService.findAccountById(accountId);
		if (account == null) {
			return "error";
		}
		
		model.addAttribute("account", account);
		model.addAttribute("transaction", new BankTransaction());
		return "bankTransactionForm";
	}
	*/
	
	
	@PostMapping("/transaction")
	public String createTransaction(@RequestParam Long fromAccountId, 
									@RequestParam Long toAccountId, 
									@RequestParam double amount, 
									TransactionType transactionType, 
									RedirectAttributes redirectAttributes, 
									Model model) {
	
		
		try {
			
			bankTransactionService.createTransaction(fromAccountId, toAccountId, amount, transactionType);
			
			// Fetch all transactions of the given accountId
			if(!model.containsAttribute("transactions")) {
			    List<BankTransaction> transactions = bankTransactionService.findTransactionsByAccountId(fromAccountId);
			    model.addAttribute("transactions", transactions);
			    System.out.println("Transactions 1" + transactions);
			}

			
			//return "redirect:/bankTransactions/account/" + fromAccountId;
			return "redirect:/bankTransactions/transaction/" + fromAccountId;
		} catch (IllegalArgumentException e) {
			redirectAttributes.addFlashAttribute("error", e.getMessage());
			return "redirect:/bankTransactions/transaction";
		}
	}
	
	@GetMapping("/transaction/{fromAccountId}")
	public String getAllTransactionsAccountId(@PathVariable Long fromAccountId, Model model) {
	    // Fetch all transactions of the given accountId
	    List<BankTransaction> transactions = bankTransactionService.findTransactionsByAccountId(fromAccountId);
	    System.out.println("Transactions " + transactions);
	    
	    model.addAttribute("transactions", new BankTransaction());

	    // Add the fetched transactions to the model
	    model.addAttribute("transactions", transactions);

	    // Return the appropriate view name
	    return "bankTransactionForm";
	}
	
	@GetMapping("/account/{fromAccountId}")
	public String getAllTransactionsFromAccount(@PathVariable Long fromAccountId, Model model) {
	    // Fetch all transactions of the given accountId
	    List<BankTransaction> transactions = bankTransactionService.findTransactionsByAccountId(fromAccountId);
	    System.out.println("Transactions " + transactions);
	    
	    model.addAttribute("transactions", new BankTransaction());

	    // Add the fetched transactions to the model
	    model.addAttribute("transactions", transactions);

	    // Return the appropriate view name
	    return "bankTransactionForm";
	}
	



}
