package com.thanhle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.thanhle.domain.Branch;
import com.thanhle.repository.BranchRepository;

@Service
public class BranchServiceImpl implements BranchService {
	@Autowired
	private BranchRepository branchRepository;

	@Override
	public Branch save(Branch branch) {
		return branchRepository.save(branch);
	}

	@Override
	public List<Branch> findAll() {
		return branchRepository.findAll();
	}

	@Override
	public Branch findById(Long id) {
		Optional<Branch> branch = branchRepository.findById(id);
		return branch.orElse(null);
	}

	@Override
	public void deleteById(Long Id) {
		branchRepository.deleteById(Id);
		
	}

	@Override
	public Branch update(Long id, Branch updatedBranch) throws Exception {
		Optional<Branch> existingBranch = branchRepository.findById(id);
		if (existingBranch.isPresent()) {
			Branch branch = existingBranch.get();
			branch.setBranchName(updatedBranch.getBranchName());
			branch.setBranchAddress(updatedBranch.getBranchAddress());
			branch.setBranchAccount(updatedBranch.getBranchAccount());
			
			return branchRepository.save(branch);
		} else {
			throw new Exception("Branch with ID " + id + " does not exist.");
		}
		
	}
	
	

}
