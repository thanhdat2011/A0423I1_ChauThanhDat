package com.example.prac1_email_validate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/email")
@Controller
public class ValidationEmailController {
    private final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    @GetMapping
    public String home(){
        return "home";
    }

//    @PostMapping
//    public ModelAndView check(@RequestParam String email){
//        return new ModelAndView("home", "msg", email.matches(EMAIL_REGEX) ? "Valid Email!!!" : "Invalid Email!!!");
//    }

    @PostMapping
    public String check(@RequestParam String email, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("msg", email.matches(EMAIL_REGEX) ? "Valid Email!!!" : "Invalid Email!!!");
        return "redirect:/email";
    }
}
