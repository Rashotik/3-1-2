package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.AppService;

import javax.validation.Valid;

@Controller
public class AdminController {
    @Autowired
    private AppService userService;

    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.findAllUsers());
        return "admin";
    }


    @GetMapping("/admin/get/{userId}")
    public String  gtUser(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("allUsers", userService.findUser(userId));
        return "admin";
    }

    @GetMapping(value = "admin/new")
    public String addUserForm(@ModelAttribute("user") User user) {
        return "form";
    }

    @GetMapping("/admin/edit")
    public String editUserForm(@RequestParam(value = "id", required = true) long id, Model model) {
        model.addAttribute("user", userService.findUser(id));
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