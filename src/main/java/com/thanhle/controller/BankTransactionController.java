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

@RestController
//@Controller
@RequestMapping("/bankTransactions")
public class BankTransactionController {
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private BankTransactionService bankTransactionService;
	
	
	// Create new transaction
	@PostMapping
	public ResponseEntity<BankTransaction> createTransaction (
			@RequestParam(required = false) Long fromAccountId,
			@RequestParam(required = false) Long toAccountId,
			@RequestParam double amount,
			@RequestParam String comments,
			@RequestParam TransactionType transactionType
		) {
		try {
			BankTransaction transaction = bankTransactionService.createTransaction(fromAccountId, toAccountId, amount, comments, transactionType);
			return ResponseEntity.ok(transaction);
			
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(null);
		}
		
	}
	
	 
	// Get transaction by ID
	@GetMapping("/{transactionId}")
	public ResponseEntity<BankTransaction> getTransactionById(@PathVariable Long transactionId) {
		BankTransaction transaction = bankTransactionService.findTransactionById(transactionId);
		if (transaction != null) {
			return ResponseEntity.ok(transaction);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	// Get all transactions
	@GetMapping
	public List<BankTransaction> getAllTransactions() {
		return bankTransactionService.findAllTransactions();
	}
	
	// Update transaction
	@PutMapping
	public ResponseEntity<BankTransaction> updateTransaction(@PathVariable Long transactionId, @RequestBody BankTransaction transaction) {
		if (!transactionId.equals(transaction.getBankTransactionId())) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(bankTransactionService.updateTransaction(transaction));
	}
	
	// Delete transaction 
	@DeleteMapping("/{transactionId}")
	public ResponseEntity<Void> deleteTransaction(@PathVariable Long transactionId) {
		bankTransactionService.deleteTransaction(transactionId);
		return ResponseEntity.noContent().build();
	}
	
	// Get transacrions by account ID
	@GetMapping("/account/{accountId}")
	public List<BankTransaction> getTransactionsByAccountId(@PathVariable Long accountId) {
		return bankTransactionService.findTransactionsByAccountId(accountId);
	}
	
	@GetMapping("/transactions")
	public String showTransactionForm(Model model) {
		model.addAttribute("transaction", new BankTransaction());
		model.addAttribute("transactions", bankTransactionService.findAllTransactions());
		return "bankTransactionForm";
	}
	

	
	@PostMapping("/transaction")
	public String createTransaction(@RequestParam Long fromAccountId, 
									@RequestParam Long toAccountId, 
									@RequestParam double amount, 
									@RequestParam String comments,
									TransactionType transactionType, 
									RedirectAttributes redirectAttributes, 
									Model model) {
	
		
		try {
			
			bankTransactionService.createTransaction(fromAccountId, toAccountId, amount, comments, transactionType);
			
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
