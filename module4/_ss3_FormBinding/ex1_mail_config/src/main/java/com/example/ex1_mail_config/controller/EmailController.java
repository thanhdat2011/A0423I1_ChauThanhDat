package com.example.ex1_mail_config.controller;

import com.example.ex1_mail_config.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/email")
@Controller
public class EmailController {

    private static Email defaultEmail = new Email();
    @GetMapping
    public String home(){
        return "home";
    }
    @GetMapping("/showForm")
    public String showForm(Model model){
        model.addAttribute("email", defaultEmail);
        return "configMail";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("email") Email email, RedirectAttributes redirectAttributes){
        defaultEmail = email;
        redirectAttributes.addFlashAttribute("msg", "Save successful !!!");
        return "redirect:/email";
    }
}
