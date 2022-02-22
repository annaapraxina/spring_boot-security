package com.example.spring_bootsecurity.service;

import com.example.spring_bootsecurity.model.Role;

import java.util.List;

public interface RoleService {
    void addRole(Role role);

    void updateRole(Role role);

    void removeRoleById(Long id);

    Role getRoleByUsername(String username);

    List<Role> getAllRoles();
}
