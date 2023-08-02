package com.thanhle.service;

import java.util.List;

import com.thanhle.domain.Role;

public interface RoleService {
	public Role saveRole(Role role);
	public Role getRoleById(Long roleId);
	public Role updateRole(Long roleId, String newRoleName);
	public void deleteRole(Long roleId);
	public List<Role> getAllRoles();
	public Role findByRoleName(String string);

}
