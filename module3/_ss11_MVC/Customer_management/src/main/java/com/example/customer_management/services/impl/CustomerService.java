package com.example.customer_management.services.impl;

import com.example.customer_management.models.Customer;
import com.example.customer_management.repositories.ICustomerRepo;
import com.example.customer_management.repositories.impl.CustomerRepo;
import com.example.customer_management.services.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerRepo repo = new CustomerRepo();
    @Override
    public void save(Customer customer) {
        repo.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return repo.findAll();
    }

    @Override
    public Customer findById(int id) {
        return repo.findById(id);
    }

    @Override
    public void remove(int id) {
        repo.remove(id);
    }

    @Override
    public void update(int id, Customer customer) {
        repo.update(id, customer);
    }
}
