package com.thanhle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thanhle.domain.BankTransaction;
import com.thanhle.domain.TransactionType;

@Repository
public interface BankTransactionRepository extends JpaRepository<BankTransaction, Long>  {

	List<BankTransaction> findByAccountAccountId(Long accountId);

}
