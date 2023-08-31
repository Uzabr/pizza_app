package com.example.pizza_app.dao;

import com.example.pizza_app.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    void removeUser(Long id);
    void updateUser(User user);
    User getUserByPhoneNumber(String phoneNumber);

}
