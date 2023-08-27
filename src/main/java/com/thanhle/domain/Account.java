package com.thanhle.domain;

import java.time.LocalDate;
import java.util.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;

import lombok.*;
//@JsonIdentityInfo(
		  //generator = ObjectIdGenerators.PropertyGenerator.class, 
		  //property = "accountId")
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private Branch accountBranch;
	
	@JoinColumn(name="customerId")
	@ManyToOne
	//@JsonManagedReference
	@JsonBackReference
	private Customer accountCustomer;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	private List<BankTransaction> transactions = new ArrayList();


	

}
