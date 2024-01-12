package com.example.prac1_employee_management.service;

import com.example.prac1_employee_management.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    void save(Employee employee);

    Employee findEmployeeById(String id);
}
