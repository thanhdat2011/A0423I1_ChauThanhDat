package com.example.ex2_dictionary.controller;


import com.example.ex2_dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/dictionary")
@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService service;

    @GetMapping
    public String home(){
        return "home";
    }

    @PostMapping
    public ModelAndView search(@RequestParam("search") String search){
//        ModelAndView modelAndView = new ModelAndView("home");
//        String result = service.search(search);
//        modelAndView.addObject("result", result);
//        return modelAndView;
        String result = service.search(search);
        return new ModelAndView("home","result", result == null ? "Not found !!!" : result);
    }
}
