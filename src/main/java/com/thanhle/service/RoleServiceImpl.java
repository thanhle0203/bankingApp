package com.thanhle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanhle.domain.Role;
import com.thanhle.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired RoleRepository roleRepository;

	@Override
	public Role saveRole(Role role) {
		if (role.getRoleId() != null && roleRepository.existsById(role.getRoleId())) {
			throw new IllegalArgumentException("Role ID already exists");
		}
		return roleRepository.save(role);
	}

	@Override
	public Role getRoleById(Long roleId) {
		
		return roleRepository.findById(roleId).orElseThrow(() -> new IllegalArgumentException("User ID not found!"));
	}

	@Override
	public Role updateRole(Long roleId, String newRoleName) {
		Role role = roleRepository.findById(roleId).orElseThrow(() -> new IllegalArgumentException("Role ID not found"));
		
		role.setRoleName(newRoleName);
		return roleRepository.save(role);
	}

	@Override
	public void deleteRole(Long roleId) {
		if (!roleRepository.existsById(roleId)) {
			throw new IllegalArgumentException("Role ID not found");
		}
		roleRepository.deleteById(roleId);
		
	}

	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public Role findByRoleName(String roleName) {
		// TODO Auto-generated method stub
		return roleRepository.findByRoleName(roleName);
	}

}
