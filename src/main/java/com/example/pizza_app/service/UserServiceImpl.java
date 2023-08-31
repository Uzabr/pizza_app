package com.example.pizza_app.service;

import com.example.pizza_app.dao.UserDao;
import com.example.pizza_app.dao.UserDaoImpl;
import com.example.pizza_app.dao.rol.RolDaoImpl;
import com.example.pizza_app.model.User;
import com.example.pizza_app.model.roles.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    private final UserDaoImpl userDao;
    private final RolDaoImpl rolDao;

    @Autowired
    public UserServiceImpl(UserDaoImpl userDao, RolDaoImpl rolDao) {
        this.userDao = userDao;
        this.rolDao = rolDao;
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void removeUser(Long id) {
        userDao.removeUser(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User getUserByPhoneNumber(String phoneNumber) {
        return userDao.getUserByPhoneNumber(phoneNumber);
    }

    @Override
    public void addRol(Set<Roles> roles) {
        rolDao.addRole(roles);
    }

    @Override
    public Set<Roles> getRol() {
        return rolDao.getRole();
    }
}
