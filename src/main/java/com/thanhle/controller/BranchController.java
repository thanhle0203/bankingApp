package com.thanhle.controller;

import com.thanhle.domain.Branch;
import com.thanhle.service.BranchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping
    public ResponseEntity<Branch> createBranch(@RequestBody Branch branch) {
        // Log the received branch object
   
        Branch createdBranch = branchService.save(branch);
        return new ResponseEntity<>(createdBranch, HttpStatus.CREATED);
    }


    @GetMapping("/{branchId}")
    public ResponseEntity<Branch> getBranch(@PathVariable Long branchId) {
        Branch branch = branchService.findById(branchId);
        return branch != null ? new ResponseEntity<>(branch, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Branch>> getAllBranches() {
        List<Branch> branches = branchService.findAll();
        return new ResponseEntity<>(branches, HttpStatus.OK);
    }

    @PutMapping("/{branchId}")
    public ResponseEntity<Branch> updateBranch(@PathVariable Long branchId, @RequestBody Branch branch) throws Exception {
        Branch updatedBranch = branchService.update(branchId, branch);
        return new ResponseEntity<>(updatedBranch, HttpStatus.OK);
    }

    @DeleteMapping("/{branchId}")
    public ResponseEntity<Void> deleteBranch(@PathVariable Long branchId) {
        branchService.deleteById(branchId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Additional endpoints as required...
}
