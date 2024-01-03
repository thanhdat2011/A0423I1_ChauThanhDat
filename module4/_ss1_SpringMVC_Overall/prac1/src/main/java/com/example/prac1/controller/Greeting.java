package com.example.prac1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/greeting")
@Controller
public class Greeting {
//    @GetMapping
//    public String greeting(@RequestParam("name") String name, Model model) {
//        model.addAttribute("name", name);
//        return "home";
//    }

    @GetMapping
    public String home(Model model){
        model.addAttribute("name", "World Of Dat");
        return "home";
    }
}
