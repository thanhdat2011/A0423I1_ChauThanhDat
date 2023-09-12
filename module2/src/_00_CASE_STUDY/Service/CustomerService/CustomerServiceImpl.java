package _00_CASE_STUDY.Service.CustomerService;

import _00_CASE_STUDY.Model.Customer;
import _00_CASE_STUDY.Repository.CustomerRepo.CustomerRepo;
import _00_CASE_STUDY.Repository.CustomerRepo.CustomerRepoImpl;

public class CustomerServiceImpl implements CustomerService{
    CustomerRepo repo = new CustomerRepoImpl();
    @Override
    public void displayCustomer() {
        repo.displayCustomer();
    }

    @Override
    public void addCustomer(Customer customer) {
        repo.addCustomer(customer);
    }

    @Override
    public void editCustomer(int id) {
        repo.editCustomer(id);
    }
}
