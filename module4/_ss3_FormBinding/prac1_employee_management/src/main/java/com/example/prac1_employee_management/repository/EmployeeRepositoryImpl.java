package com.example.prac1_employee_management.repository;

import com.example.prac1_employee_management.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements IEmployeeRepository{
    private final static List<Employee> employeeList;
    static {
        employeeList = new ArrayList<>();
        employeeList.add(new Employee("E-001","Dat","0942045456"));
        employeeList.add(new Employee("E-002","Toan","0935345987"));
        employeeList.add(new Employee("E-003","Duy","0905001008"));
        employeeList.add(new Employee("E-004","Bui","0905007990"));
    }


    @Override
    public List<Employee> findAll() {
        return employeeList;
    }

    @Override
    public void save(Employee employee) {
        if (isIdExist(employee.getId())) {
            employeeList.set(getIndexOfEmployeeById(employee.getId()), employee );
        } else {
            employeeList.add(employee);
        }
    }

    @Override
    public Employee findEmployeeById(String id) {
        for (Employee employee: employeeList) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        throw new RuntimeException("cannot find");
    }

    private boolean isIdExist(String id) {
        for (Employee employee: employeeList) {
            if (employee.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private int getIndexOfEmployeeById(String id) {
        for (int i=0; i<employeeList.size();i++) {
            if (employeeList.get(i).getId().equals(id)) {
                return i;
            }
        }
        throw new RuntimeException();
    }
}
