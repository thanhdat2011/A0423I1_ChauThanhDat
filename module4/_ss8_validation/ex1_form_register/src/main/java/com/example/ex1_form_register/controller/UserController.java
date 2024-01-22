package com.example.ex1_form_register.controller;

import com.example.ex1_form_register.model.User;
import com.example.ex1_form_register.model.UserDTO;
import com.example.ex1_form_register.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("")
@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;
    @GetMapping("/")
    public ModelAndView home(){
        return new ModelAndView("list","user", iUserService.findAll());
    }

    @GetMapping("/show-create-form")
    public ModelAndView showAddForm(){
        return new ModelAndView("create","user", new UserDTO());
    }

    @PostMapping("/add")
    public String addUser(@Valid @ModelAttribute("user") UserDTO userDTO,
                          BindingResult bindingResult){
        new UserDTO().validate(userDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        iUserService.save(user);
        return "redirect:/";
    }
}
