package com.thanhle.service;

import java.util.List;

import com.thanhle.domain.Branch;

public interface BranchService {
	Branch save(Branch branch);
	List<Branch> findAll();
	Branch findById(Long id);
	void deleteById(Long Id);
	Branch update(Long id, Branch branch) throws Exception;
}
