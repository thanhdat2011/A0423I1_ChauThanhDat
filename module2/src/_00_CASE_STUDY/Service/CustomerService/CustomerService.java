package _00_CASE_STUDY.Service.CustomerService;

import _00_CASE_STUDY.Model.Customer;
import _00_CASE_STUDY.Model.Employee;

public interface CustomerService {
    void displayCustomer();
    void addCustomer(Customer customer);
    void editCustomer(int id);
}
