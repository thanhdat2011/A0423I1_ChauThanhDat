package com.example.ex2.controller;

import com.example.ex2.model.Music;
import com.example.ex2.model.MusicDTO;
import com.example.ex2.service.IMusicService;
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

import javax.print.attribute.standard.Copies;

@RequestMapping("")
@Controller
public class MusicController {
    @Autowired
    private IMusicService iMusicService;
    @GetMapping("/")
    public ModelAndView home(){
        return new ModelAndView("layout", "list", iMusicService.findAll());
    }

    @GetMapping("/show-create-form")
    public ModelAndView showCreateForm(){
        return new ModelAndView("create","music", new MusicDTO());
    }

    @PostMapping("/add")
    public String addMusic(@Valid @ModelAttribute("music") MusicDTO musicDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDTO,music);
        iMusicService.save(music);
        return "redirect:/";
    }
}
