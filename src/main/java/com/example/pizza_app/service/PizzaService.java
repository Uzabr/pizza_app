package com.example.pizza_app.service;

import com.example.pizza_app.model.Pizza;

import java.util.List;

public interface PizzaService {

    void savePizza(Pizza pizza);
    void updatePizza(Pizza pizza);
    List<Pizza> getAllPizza();
    Pizza getPizzaById(Long id);
    void removePizza(Long id);
    Pizza getPizzaByName(String name);
}
