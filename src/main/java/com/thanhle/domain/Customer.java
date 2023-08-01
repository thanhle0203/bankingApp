package com.thanhle.domain;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long customerId;
	
	private String customerName;
	
	private String customerGender;
	
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	private LocalDate customerDob;
	
	private String customerMobileNum;
	
	@Embedded
	private Address customerAddress;
	
	private String realId;
	
	@OneToMany(mappedBy="accountCustomer")
	private List<Account> customerAccounts;
	
	@JoinColumn(name="userId")
	@OneToOne
	private User user;
	

}
