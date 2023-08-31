package com.example.pizza_app.dao.rol;

import com.example.pizza_app.model.roles.Roles;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RolDaoImpl implements RolDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void addRole(Set<Roles> role) {
        role.forEach(roles -> entityManager.persist(roles));
    }

    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public Set<Roles> getRole() {
        List<Roles> roles = entityManager.createQuery("from Roles").getResultList();
        return new HashSet<>(roles);
    }
}
