package com.example.pizza_app.controller;

import com.example.pizza_app.dao.UserDaoImpl;
import com.example.pizza_app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    UserDaoImpl userDao;
    @GetMapping(value = {"/user"})
    public String user(ModelMap modelMap) {


        modelMap.addAttribute("users", userDao.getAllUsers());
        return "userform";
    }
}
