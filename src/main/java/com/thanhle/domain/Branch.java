package com.thanhle.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
//@JsonIdentityInfo(
		  //generator = ObjectIdGenerators.PropertyGenerator.class, 
		  //property = "branchId")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Branch {
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long branchId;
	
	@NotEmpty
	private String branchName;
	
	@Embedded
	private Address branchAddress;
	
	@JsonIgnore
	@OneToMany(mappedBy="accountBranch")
	@JsonManagedReference
	private List<Account> branchAccount = new ArrayList<>();
	
}
