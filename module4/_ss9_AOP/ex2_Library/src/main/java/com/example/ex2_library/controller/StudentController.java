package com.example.ex2_library.controller;

import com.example.ex2_library.model.FPTClass;
import com.example.ex2_library.model.Student;
import com.example.ex2_library.model.DTO.StudentDTO;
import com.example.ex2_library.service.Interface.IFPTClassService;
import com.example.ex2_library.service.Interface.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;
    @Autowired
    private IFPTClassService ifptClassService;

//    @ExceptionHandler(Exception.class)
//    public String handleException() {
//        return "/error_page";
//    }
    @ModelAttribute("fptClassList")
    public List<FPTClass> getFptClassList(){
        return ifptClassService.findAll();
    }


    /* ============================== CREATE =================================== */
    @GetMapping("/list")
    public ModelAndView showStudentList(@RequestParam(defaultValue = "0", required = false) int page){
//        return new ModelAndView("/student/list","studentList", iStudentService.findAll());
        Sort sort = Sort.by("studentName").ascending();
        Pageable pageable = PageRequest.of(page, 2, sort);
        Page<Student> studentPage = iStudentService.getStudentList(pageable);
        return new ModelAndView("/student/list", "studentList", studentPage);
    }

    /* ============================== CREATE =================================== */
    @GetMapping("/show-form-create")
    public ModelAndView showFormCreate(){
        return new ModelAndView("/student/create", "student", new StudentDTO());
    }

    @PostMapping("/add")
    public String addStudent(@Valid @ModelAttribute("student") StudentDTO studentDTO,
                            BindingResult bindingResult){
        new StudentDTO().validate(studentDTO, bindingResult); //níu có custom validate
        if (bindingResult.hasErrors()){
            return "/student/create";
        }
        Student student = new Student();
        FPTClass fptClass = ifptClassService.findById(studentDTO.getFptClass());
        BeanUtils.copyProperties(studentDTO, student);

        student.setFptClass(fptClass);
        iStudentService.save(student);
        return "redirect:/student/list";
    }

    /* ============================== DELETE =================================== */
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable String id){
        iStudentService.removeStudentById(id);
        return "redirect:/student/list";
    }

    /* ============================== EDIT =================================== */
    @GetMapping("/{id}/show-form-edit")
    public ModelAndView showEditForm(@PathVariable String id){
        ModelAndView modelAndView = new ModelAndView("/student/edit");
        Student student = iStudentService.findById(id);
//        StudentDTO studentDTO = new StudentDTO();
//        // copy qua DTO để còn validate
//        BeanUtils.copyProperties(student, studentDTO);
//        studentDTO.setFptClass(student.getFptClass().getClassId());
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("student") StudentDTO studentDTO,
                       BindingResult bindingResult){
        new StudentDTO().validate(studentDTO, bindingResult);
        if (bindingResult.hasErrors()){
            return "/student/edit";
        }
        Student student = new Student();
        FPTClass fptClass = ifptClassService.findById(studentDTO.getFptClass());

        BeanUtils.copyProperties(studentDTO, student);
        student.setFptClass(fptClass);
        iStudentService.save(student);
        return "redirect:/student/list";
    }

    /* ============================== SEARCH =================================== */
    @GetMapping("/search")
    public ModelAndView showSearch(@RequestParam(defaultValue = "0", required = false) int page, @RequestParam String keySearch){
        Pageable pageable = PageRequest.of(page, 2);
        Page<Student> studentPage = iStudentService.findByName(pageable, keySearch);
        ModelAndView modelAndView = new ModelAndView("/student/search");
        modelAndView.addObject("studentList", studentPage);
        modelAndView.addObject("keySearch", keySearch);
        return modelAndView;
//        return new ModelAndView("search", "blogList", studentPage);
    }
}
