package com.example.springboot.controller;

import com.example.springboot.model.CodegymClass;
import com.example.springboot.model.Student;
import com.example.springboot.model.StudentDTO;
import com.example.springboot.service.codegym_class.ICodegymClassService;
import com.example.springboot.service.student.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private ICodegymClassService iCodegymClassService;

    @ModelAttribute("listClass")
    public List<CodegymClass> showListCodegymClass(){
        return iCodegymClassService.showList();
    }

    @GetMapping("/")
    public ModelAndView showList(@RequestParam(defaultValue = "0",required = false) int page,
                                 @RequestParam(defaultValue = "3",required = false) int pageSize,
                                 Model model){
        Sort sort = Sort.by("name").ascending();
        Pageable pageable = PageRequest.of(page,3,sort);
        Page<Student> pageStudent = iStudentService.findAll(pageable);
        int size = pageStudent.getTotalPages();
        List<Integer> listPage = new ArrayList<>();
        for (int i = 1; i <= size ; i++) {
            listPage.add(i);
        }
        model.addAttribute("pages",listPage);
        return new ModelAndView("/list", "list",iStudentService.findAll(pageable));
    }

    @GetMapping("/show-form-create")
    public ModelAndView showFormCreate(){
        return new ModelAndView("/create","student",new StudentDTO());
    }

    @PostMapping("/add")
    public String addNewStudent(@Valid @ModelAttribute("student") StudentDTO student,
                                BindingResult bindingResult){
        // Sử dụng để kiểm tra lỗi đối với custom validate
        // anonymous object
        // Garbage Collection -> công cụ dọn rác
        new StudentDTO().validate(student,bindingResult);
        if(bindingResult.hasErrors()){
            return "/create";
        }
        Student s = new Student();
        CodegymClass codegymClass = iCodegymClassService.findById(student.getCodeGymClass());
        // Chuyển đổi dữ liệu từ DTO -> Entity
        BeanUtils.copyProperties(student,s);
        s.setCodeGymClass(codegymClass);
        iStudentService.addNewStudent(s);
        return "redirect:/";
    }
}
