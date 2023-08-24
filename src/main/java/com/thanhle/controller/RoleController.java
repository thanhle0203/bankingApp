package com.thanhle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.thanhle.domain.Role;
import com.thanhle.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping
	public Role createRole(@RequestBody Role role) {
		return roleService.saveRole(role);
	}
	
	@GetMapping("/{roleId}")
	public Role getRoleById(@PathVariable Long roleId) {
		return roleService.getRoleById(roleId);
	}
	
	@PutMapping("/{roleId}") 
	public Role updateRole(@PathVariable Long roleId, String role) {
		return roleService.updateRole(roleId, role);
	}
	
	@DeleteMapping("/{roleId}")
	public void deleteRole(@PathVariable Long roleId) {
		roleService.deleteRole(roleId);
	}
	
	@GetMapping
	public List<Role> getAllRoles() {
		return roleService.getAllRoles();
	}
}
