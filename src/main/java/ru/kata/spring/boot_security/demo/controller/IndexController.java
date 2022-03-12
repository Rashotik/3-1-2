package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import ru.kata.spring.boot_security.demo.config.exception.LoginException;
import ru.kata.spring.boot_security.demo.service.AppService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class IndexController {
	@GetMapping("")
	public String welcomePage(Model model) {
		return "index";
	}
}