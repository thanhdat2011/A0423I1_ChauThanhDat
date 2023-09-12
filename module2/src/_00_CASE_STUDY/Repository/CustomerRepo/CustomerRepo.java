package _00_CASE_STUDY.Repository.CustomerRepo;

import _00_CASE_STUDY.Model.Customer;


public interface CustomerRepo {
    void displayCustomer();
    void addCustomer(Customer customer);
    void editCustomer(int id);
}
