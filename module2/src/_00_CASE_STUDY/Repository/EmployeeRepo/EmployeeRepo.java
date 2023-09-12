package _00_CASE_STUDY.Repository.EmployeeRepo;

import _00_CASE_STUDY.Model.Employee;

public interface EmployeeRepo {
    void displayEmployee();
    void addEmployee(Employee employee);
    void editEmployee(int id);
}
