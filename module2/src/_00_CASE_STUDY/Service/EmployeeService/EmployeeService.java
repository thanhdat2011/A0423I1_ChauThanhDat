package _00_CASE_STUDY.Service.EmployeeService;

import _00_CASE_STUDY.Model.Employee;

public interface EmployeeService {
    void displayEmployee();
    void addEmployee(Employee employee);
    void editEmployee(int id);
}
