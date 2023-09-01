package com.example.pizza_app.controller;

import com.example.pizza_app.dao.UserDaoImpl;
import com.example.pizza_app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDaoImpl userDao;
    @GetMapping
    public String user(ModelMap modelMap) {


        modelMap.addAttribute("users", userDao.getAllUsers());
        return "userform";
    }
}
