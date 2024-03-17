package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Student;
import vn.codegym.service.IStudentService;
import vn.codegym.service.StudentServiceImpl;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping("/student")
@Controller
public class StudentController {

    @Autowired
    private IStudentService service;

    @GetMapping
    public String showList(Model model) {
        List<Student> studentList = service.findAll();
        model.addAttribute("studentList", studentList);
        return "list";
    }

    @GetMapping("/list")
    public String showList1(ModelMap model) {
        List<Student> studentList = service.findAll();
        model.addAttribute("studentList", studentList);
        return "list";
    }

//    @GetMapping("/top")
//    public ModelAndView showList1(){
//        List<Student> studentList = service.findAll();
//        ModelAndView model = new ModelAndView("list");
//        model.addObject("studentList", studentList);
//        return model;
//    }

    @GetMapping("/top")
    public ModelAndView showList1() {
        return new ModelAndView("list",
                "studentList", service.findAll());
    }


}
