package com.example.customer_management.repositories;

import com.example.customer_management.models.Customer;

import java.util.List;

public interface ICustomerRepo {
    void save(Customer customer);

    List<Customer> findAll();

    Customer findById(int id);

    void remove(int id);
}
