package ru.kata.spring.boot_security.demo.controller;

import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "admin";
    }


    @GetMapping("/admin/get/{userId}")
    public String  gtUser(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("allUsers", userService.findUserById(userId));
        return "admin";
    }

    @GetMapping(value = "admin/new")
    public String addUserForm(@ModelAttribute("user") User user) {
        return "form";
    }

    @GetMapping("/admin/edit")
    public String editUserForm(@RequestParam(value = "id", required = true) long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "form";
    }

    @PostMapping(value = "/admin")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }
    @GetMapping("/admin/delete")
    public String deleteUser(@RequestParam(value = "id", required = true, defaultValue = "") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
