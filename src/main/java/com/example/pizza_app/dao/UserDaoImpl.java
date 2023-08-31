package com.example.pizza_app.dao;

import com.example.pizza_app.model.User;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    private static final Logger LOG = LoggerFactory.getLogger(UserDao.class);

    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;

    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
        LOG.info("user successfully added");
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return (List<User>) entityManager.createQuery("from User").getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void removeUser(Long id) {
        entityManager.remove(getUserById(id));
        LOG.info("user successfully removed");
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
        LOG.info("user updated");
    }

    @Override
    public User getUserByPhoneNumber(String phoneNumber) {
        return (User) entityManager.createQuery("select from User user where user.phoneNumber=:phoneNumber").setParameter("phoneNumber", phoneNumber).getSingleResult();
    }
}
