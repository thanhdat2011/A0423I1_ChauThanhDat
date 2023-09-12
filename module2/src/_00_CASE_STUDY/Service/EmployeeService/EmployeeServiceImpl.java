package _00_CASE_STUDY.Service.EmployeeService;


import _00_CASE_STUDY.Model.Employee;
import _00_CASE_STUDY.Repository.EmployeeRepo.EmployeeRepo;
import _00_CASE_STUDY.Repository.EmployeeRepo.EmployeeRepoImpl;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepo repo = new EmployeeRepoImpl();
    @Override
    public void displayEmployee() {
        repo.displayEmployee();
    }

    @Override
    public void addEmployee(Employee employee) {
        repo.addEmployee(employee);
    }

    @Override
    public void editEmployee(int id) {
        repo.editEmployee(id);
    }
}
