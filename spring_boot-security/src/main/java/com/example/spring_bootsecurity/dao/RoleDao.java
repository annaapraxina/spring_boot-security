package com.example.spring_bootsecurity.dao;

import com.example.spring_bootsecurity.model.Role;

import java.util.List;

public interface RoleDao {
    void addRole(Role role);

    void updateRole(Role role);

    void removeRoleById(Long id);

    Role getRoleByUsername(String role);

    List<Role> getAllRoles();
}
