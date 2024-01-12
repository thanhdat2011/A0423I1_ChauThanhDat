package com.example.prac1_employee_management.controller;

import com.example.prac1_employee_management.model.Employee;
import com.example.prac1_employee_management.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping("/employee")
@Controller
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    // ======================================================================================================
    // show list
    @GetMapping
    public String showList(Model model){
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employeeList", employeeList);
        return "list";
    }

    // ======================================================================================================
    // Create
    @GetMapping("/showCreateForm")
    public String showCreateForm(Model model){
        model.addAttribute("employee", new Employee());
        return "create";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes){
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("msg","Create successfully !!!");
        return "redirect:/employee";
    }

    // ======================================================================================================
    // Edit
    @GetMapping("/showFormEdit/{id}")
    public String showFormEdit(@PathVariable String id, Model model) {
        Employee employee = employeeService.findEmployeeById(id);
        model.addAttribute("employee", employee);
        return "edit";
    }

    @PostMapping("/showFormEdit/{id}")
    public String edit(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("msg", "Update successfully !!!");
        return "redirect:/employee";
    }
}
