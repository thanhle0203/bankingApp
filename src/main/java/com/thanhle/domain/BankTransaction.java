package com.thanhle.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BankTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bankTransactionId;
	
	@ManyToOne
	@JoinColumn(name = "accountId")
	private Account account;

	
	// this can be used for deposits and transfers
	@ManyToOne
	@JoinColumn(name = "bankTransactionToAccountId")
	private Account bankTransactionToAccount;
	
	// this can be used for withdrawals and transfer
	@ManyToOne
	@JoinColumn(name = "bankTransactionFromAccountId")
	private Account bankTransactionFromAccount;
	
	private double transactionAmount;
	
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime bankTransactionDateTime;
	
	
	private String comments;


	
	
	
}
