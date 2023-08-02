package com.thanhle.domain;

import java.time.LocalDate;
import java.util.*;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long accountId;
	
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	private LocalDate accountDateOpen;
	
	private double accountBalance;
	
	@JoinColumn(name="branchId")
	@ManyToOne
	private Branch accountBranch;
	
	@JoinColumn(name="customerId")
	@ManyToOne
	private Customer accountCustomer;
	
	@OneToMany(mappedBy = "account")
	private List<BankTransaction> transactions = new ArrayList();
	
	

}
