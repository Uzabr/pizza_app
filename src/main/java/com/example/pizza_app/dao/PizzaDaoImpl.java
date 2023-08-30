package com.example.pizza_app.dao;

import com.example.pizza_app.model.Pizza;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Transactional(rollbackOn = Exception.class)
public class PizzaDaoImpl implements PizzaDao{

    private static final Logger LOG = LoggerFactory.getLogger(PizzaDaoImpl.class);


    private final EntityManager entityManager;

    @Autowired
    public PizzaDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public void savePizza(Pizza pizza) {
        entityManager.persist(pizza);
        LOG.info("Pizza successfully saved");
    }

    @Override
    public void updatePizza(Pizza pizza) {
        entityManager.merge(pizza);
        LOG.info("Pizza updated");

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Pizza> getAllPizza() {
        return (List<Pizza>) entityManager.createQuery("from Pizza").getResultList();

    }

    @Override
    public Pizza getPizzaById(Long id) {
        return entityManager.find(Pizza.class, id);
    }

    @Override
    public void removePizza(Long id) {
        entityManager.remove(getPizzaById(id));
        LOG.info("pizza was deleted");
    }

    @Override
    public Pizza getPizzaByName(String name) {
        return (Pizza) entityManager.createQuery("select from Pizza pizza where pizza.name=:name").setParameter("name",name).getSingleResult();
    }
}
