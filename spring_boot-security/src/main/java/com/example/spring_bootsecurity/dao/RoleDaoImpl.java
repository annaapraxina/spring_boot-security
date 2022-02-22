package com.example.spring_bootsecurity.dao;

import com.example.spring_bootsecurity.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void updateRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public void removeRoleById(Long id) {
        entityManager.remove(entityManager.find(Role.class, id));
    }

    @Override
    public Role getRoleByUsername(String role) {
        TypedQuery<Role> queryRole = entityManager.createQuery("select r from Role r where r.role=:role",
                Role.class).setParameter("role", role);
        return queryRole.getSingleResult();
    }

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("select r from Role r", Role.class).getResultList();
    }
}
