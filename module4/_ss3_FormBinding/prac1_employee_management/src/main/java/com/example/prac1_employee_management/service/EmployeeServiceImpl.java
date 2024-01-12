package com.example.prac1_employee_management.service;

import com.example.prac1_employee_management.model.Employee;
import com.example.prac1_employee_management.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeById(String id) {
        return employeeRepository.findEmployeeById(id);
    }


}
