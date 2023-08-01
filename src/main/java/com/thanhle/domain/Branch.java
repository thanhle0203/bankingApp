package com.thanhle.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
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
	
	@OneToMany(mappedBy="accountBranch")
	private List<Account> branchAccount = new ArrayList<>();
	
}
