package com.thanhle.domain;

import java.time.LocalDate;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
	
	@NotBlank(message = "Customer name is required.")
	private String customerName;
	
	private String customerGender;
	
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	private LocalDate customerDob;
	
	@Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits.")
	private String customerMobileNum;
	
	@Embedded
	private Address customerAddress;
	
	private String realId;
	
	@JsonIgnore
	@OneToMany(mappedBy="accountCustomer", fetch = FetchType.LAZY)
	//@JsonBackReference
	@JsonManagedReference
	private List<Account> customerAccounts;
	
	@JoinColumn(name="userId")
	@OneToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private User user;

	

}
