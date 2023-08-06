package com.thanhle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thanhle.domain.Account;
import com.thanhle.domain.AccountType;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

	List<Account> findByAccountType(AccountType type);
	
	
	@Query("SELECT a from Account a WHERE a.accountCustomer.customerId = :customerId")
	List<Account> findAccountsByCustomerId(@Param("customerId") Long customerId);

}
