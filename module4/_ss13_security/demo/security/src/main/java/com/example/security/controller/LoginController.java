package com.example.security.controller;

import com.example.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping({"/login","/"})
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String loginForm() {
        return "login";
    }

}
