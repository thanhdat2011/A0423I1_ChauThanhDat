package com.example.ex2_picture.controller;

import com.example.ex2_picture.model.Feedback;
import com.example.ex2_picture.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("")
@Controller
public class PictureController {
    @Autowired
    private IFeedbackService iFeedbackService;

    @GetMapping("/")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("layout");
        modelAndView.addObject("feedback", new Feedback(LocalDate.now()));
        List<Feedback> list = iFeedbackService.findAllInDay(LocalDate.now().getDayOfYear());
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @PostMapping("/comment")
    public String comment(Feedback feedback) {
        iFeedbackService.save(feedback);
        return "redirect:/";
    }

    @GetMapping("/{id}/likeComment")
    public String like(@PathVariable Long id){
        Feedback feedback = iFeedbackService.findFeedbackById(id);
        feedback.setLikeNum(feedback.getLikeNum() + 1);
        iFeedbackService.save(feedback);
        return "redirect:/";
    }
}
