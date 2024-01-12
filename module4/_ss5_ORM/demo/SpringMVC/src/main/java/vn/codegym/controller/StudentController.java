package vn.codegym.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Student;
import vn.codegym.service.IStudentService;

import java.util.List;

@RequestMapping("")
@Controller
public class StudentController {

    @Autowired
    private IStudentService service;

    @ModelAttribute("listLanguage")
    public String[] showListLanguage(){
        return new String[]{"Java", "C#", "JS"};
    }

    @GetMapping("/") // URL handle mapping
    public String showList1(Model model) { // handle method
        List<Student> studentList = service.findAll();
        model.addAttribute("studentList", studentList);
        return "list";
    }

    @GetMapping("/showFormCreate")
    public String showFormCreate(Model model) {
        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("student") Student student,
                      RedirectAttributes redirectAttributes) {
        service.save(student);
        redirectAttributes.addFlashAttribute("msg","Successfully");
        return "redirect:/";
    }


}
