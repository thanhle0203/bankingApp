package com.thanhle.domain;

import java.time.LocalDate;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "customerId")
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
	@JsonBackReference
	private List<Account> customerAccounts;
	
	@JoinColumn(name="userId")
	@OneToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private User user;



	

}
