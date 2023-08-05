package com.thanhle.controller;

import com.thanhle.domain.Branch;
import com.thanhle.service.BranchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/branches")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @GetMapping()
	public String branchForm(Model model) {
    	//model.addAttribute("branch", new Branch());
    	model.addAttribute("branches", branchService.findAll());
		return "branchForm";
	}
    
    @PostMapping("/save")
    public String saveBranch(@ModelAttribute Branch branch, BindingResult result, Model model) {
    	if (result.hasErrors()) {
    		return "branchForm";
    	}
        branchService.save(branch);
        model.addAttribute("message", "Branch saved successfully");
        model.addAttribute("branches", branchService.findAll());
        return "branchForm";
          
    }
    
    
    
    /*
    @PostMapping("/create-branch")
    public ResponseEntity<Branch> createBranch(@RequestBody Branch branch) {
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

    */
}
