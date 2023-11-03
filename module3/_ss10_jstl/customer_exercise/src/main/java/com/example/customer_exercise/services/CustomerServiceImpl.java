package com.example.customer_exercise.services;

import com.example.customer_exercise.model.Customer;
import com.example.customer_exercise.repositories.CustomerRepoImpl;
import com.example.customer_exercise.repositories.ICustomerRepo;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService{
    ICustomerRepo customerRepo = new CustomerRepoImpl();
    @Override
    public List<Customer> getAll() {
        return customerRepo.findAll();
    }
}
