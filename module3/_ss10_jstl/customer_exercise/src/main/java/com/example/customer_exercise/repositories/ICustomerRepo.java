package com.example.customer_exercise.repositories;

import com.example.customer_exercise.model.Customer;

import java.util.List;

public interface ICustomerRepo {
    List<Customer> findAll();
}
