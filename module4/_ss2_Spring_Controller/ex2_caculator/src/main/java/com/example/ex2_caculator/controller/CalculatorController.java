package com.example.ex2_caculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RequestMapping("/calculator")
@Controller
public class CalculatorController {
    @GetMapping
    public String home(){
        return "home";
    }
    @PostMapping
    public String calculate(@RequestParam double num1, @RequestParam double num2, @RequestParam String operator, RedirectAttributes redirectAttributes){
        String result = "";

        switch (operator) {
            case "+": result = String.valueOf(num1 + num2);
                    break;
            case "-": result = String.valueOf(num1 - num2);
                    break;
            case "x": result = String.valueOf(num1 * num2);
                    break;
            case "/": result = num2 == 0 ? "Can not divide by 0" : String.valueOf((num1/num2));
        }

//        model.addAttribute("result", result);
        redirectAttributes.addFlashAttribute("result", "Result : " + result);
        return "redirect:/calculator";
    }
}
