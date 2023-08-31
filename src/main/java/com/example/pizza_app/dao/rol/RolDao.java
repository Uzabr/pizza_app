package com.example.pizza_app.dao.rol;

import com.example.pizza_app.model.roles.Roles;

import java.util.Set;

public interface RolDao {
    void addRole(Set<Roles> role) ;
    Set<Roles> getRole();
}
