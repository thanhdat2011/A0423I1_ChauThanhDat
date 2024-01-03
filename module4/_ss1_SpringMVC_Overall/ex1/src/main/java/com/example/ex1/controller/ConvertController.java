package com.example.ex1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;

//@RequestMapping("/home")
@Controller
public class ConvertController {
    @GetMapping("/home")
    public String home(){
        return "result";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam("usd") double usd, Model model){
        model.addAttribute("vnd", (usd * 23000));
        return "result";
    }

//    @GetMapping("/convert")
//    public String convert(@RequestParam("usd") double usd, Model model){
//        model.addAttribute("vnd", (usd * 23000));
//        return "result";
//    }

}
