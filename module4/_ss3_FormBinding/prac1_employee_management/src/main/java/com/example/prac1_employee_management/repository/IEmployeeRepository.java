package com.example.prac1_employee_management.repository;

import com.example.prac1_employee_management.model.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> findAll();

    void save(Employee employee);

    Employee findEmployeeById(String id);
}
