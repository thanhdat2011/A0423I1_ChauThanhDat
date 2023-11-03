package com.example.customer_exercise.controllers;

import com.example.customer_exercise.model.Customer;
import com.example.customer_exercise.services.CustomerServiceImpl;
import com.example.customer_exercise.services.ICustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/customer", name = "customerController")
public class CustomerController extends HttpServlet {
    ICustomerService customerService = new CustomerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customers = customerService.getAll();
        req.setAttribute("customers", customers);
        req.getRequestDispatcher("/customers/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
