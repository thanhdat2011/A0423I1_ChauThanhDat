package com.example.springboot.controller;

import com.example.springboot.model.CodegymClass;
import com.example.springboot.model.Student;
import com.example.springboot.service.codegym_class.ICodegymClassService;
import com.example.springboot.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private ICodegymClassService iCodegymClassService;

    @ModelAttribute("listClass")
    public List<CodegymClass> showListCodegymClass() {
        return iCodegymClassService.showList();
    }

//    @GetMapping("/")
//    public ModelAndView showList() {
//        return new ModelAndView("/list", "list", iStudentService.showList());
//    }

    @GetMapping("/")
    public ModelAndView showList(@RequestParam(defaultValue = "0", required = false) int page){
        Sort sort = Sort.by("name");
//        Pageable pageable = PageRequest.of(page,3);
        Pageable pageable = PageRequest.of(page,3, sort);
        Page<Student> pageStudent =iStudentService.findAll(pageable);
        return new ModelAndView("/list","list", pageStudent);
    }


    @GetMapping("/show-form-create")
    public ModelAndView showFormCreate() {
        return new ModelAndView("/create", "student", new Student());
    }

    @PostMapping("/add")
    public String addNewStudent(Student student) {
        iStudentService.save(student);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteStudent(@PathVariable Long id) {
        iStudentService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit-form")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Student student = iStudentService.getStudentById(id);
        return new ModelAndView("/edit", "student", student);
    }

    @PostMapping("/edit")
    public String editStudent(Student student) {
        iStudentService.save(student);
        return "redirect:/";
    }

    @PostMapping("/search")
    public ModelAndView searchStudentByName(@RequestParam("keySearch") String keySearch,
                                            @RequestParam(defaultValue = "0", required = false) int page){
        Pageable pageable = PageRequest.of(page, 3);
        Page<Student> studentPage = iStudentService.searchStudentByName(pageable, keySearch);
//        List<Student> studentList = iStudentService.searchStudentByName(keySearch);
        return new ModelAndView("/search", "list", studentPage);
    }
}
