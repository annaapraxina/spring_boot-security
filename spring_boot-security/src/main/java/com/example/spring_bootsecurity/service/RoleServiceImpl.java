package com.example.spring_bootsecurity.service;

import com.example.spring_bootsecurity.dao.RoleDao;
import com.example.spring_bootsecurity.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

    private RoleDao roleDao;

    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Override
    public void updateRole(Role role) {
        roleDao.updateRole(role);
    }

    @Override
    public void removeRoleById(Long id) {
        roleDao.removeRoleById(id);
    }

    @Override
    public Role getRoleByUsername(String role) {
        return roleDao.getRoleByUsername(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }
}
