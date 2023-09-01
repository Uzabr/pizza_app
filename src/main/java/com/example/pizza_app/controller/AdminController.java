package com.example.pizza_app.controller;


import com.example.pizza_app.model.User;
import com.example.pizza_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AdminController {

    private UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String admin(ModelMap modelMap) {
        modelMap.addAttribute("users", userService.getAllUsers());
        modelMap.addAttribute("roles", userService.getRol());
        modelMap.addAttribute("newuser", new User());
        return "adminform";
    }

    @PostMapping("/newuser")
    public String newUser(@ModelAttribute User user) {
            userService.saveUser(user);
            return "redirect:/adminform";
    }

    @PostMapping("/edit")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/adminform";
    }


    @PostMapping("/edit/{id}")
    public String loadUserForEdit(ModelMap modelMap, @PathVariable("id") long id) {
        User user = userService.getUserById(id);
        modelMap.addAttribute("loadUser", user);
        modelMap.addAttribute("loadRoles", userService.getRol());
        return "update";
    }

    @PostMapping("/delete{id}")
    public String deleteUser(@PathVariable("id") long id){
        userService.removeUser(id);
        return "redirect:/adminform";
    }

}
