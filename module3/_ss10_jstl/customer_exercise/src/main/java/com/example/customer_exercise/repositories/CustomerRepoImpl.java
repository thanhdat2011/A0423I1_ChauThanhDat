package com.example.customer_exercise.repositories;

import com.example.customer_exercise.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepoImpl implements ICustomerRepo{
    private static final List<Customer> customers = new ArrayList<>();
    static {
        customers.add(new Customer("Dat","20/11/2000","Ho Nghinh"));
        customers.add(new Customer("Duy","1/1/2002","Le Duan"));
        customers.add(new Customer("Huy","10/2/1997","Hai Phong"));
        customers.add(new Customer("Minh","19/11/1993","Pham Van Dong"));
        customers.add(new Customer("Phuc","12/3/2004","Dien Bien Phu"));
    }
    @Override
    public List<Customer> findAll() {
        return customers;
    }
}
