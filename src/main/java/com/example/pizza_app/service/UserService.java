package com.example.pizza_app.service;

import com.example.pizza_app.model.User;
import com.example.pizza_app.model.roles.Roles;

import java.util.List;
import java.util.Set;

public interface UserService {
    void saveUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    void removeUser(Long id);
    void updateUser(User user);
    User getUserByPhoneNumber(String phoneNumber);
    void addRol(Set<Roles> roles);

    Set<Roles> getRol();

}
