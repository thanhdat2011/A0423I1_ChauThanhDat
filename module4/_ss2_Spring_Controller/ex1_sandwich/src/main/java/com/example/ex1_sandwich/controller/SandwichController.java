package com.example.ex1_sandwich.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/sandwich")
@Controller
public class SandwichController {
    @GetMapping
    public String home(){
        return "home";
    }

//    @PostMapping("/list")
//    public String showSandwichCondiment(@RequestParam String[] condiments, Model model){
//        model.addAttribute("condiments", condiments);
//        return "list";
//    }

    @PostMapping("/list")
    public ModelAndView showSandwichCondiment(@RequestParam String[] condiments){
        return new ModelAndView("list", "condiments", condiments);
    }
}
