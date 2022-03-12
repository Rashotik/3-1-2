package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("")
    public String showUserInfo(User principal,
                               Model model) {
        model.addAttribute("user", principal);

        return "user";
    }
}
