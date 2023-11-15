package com.example.customer_management.controllers;

import com.example.customer_management.models.Customer;
import com.example.customer_management.services.ICustomerService;
import com.example.customer_management.services.impl.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/customers", name = "CustomerServlet")
public class CustomerServlet extends HttpServlet {
    private final ICustomerService customerService = new CustomerService();

    /* ================================================================================================== */
    /* doGet() */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(req, resp);
                break;
            case "edit":
                showUpdateForm(req, resp);
                break;
            case "delete":
                showDeleteForm(req, resp);
                break;
            case "view":
                showViewForm(req, resp);
            default:
                listCustomers(req, resp);
                break;
        }
    }

    private void showViewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = customerService.findById(id);
        req.setAttribute("customer", customer);
        req.getRequestDispatcher("customers/view.jsp").forward(req,resp);
    }

    private void showUpdateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = customerService.findById(id);
        req.setAttribute("customer", customer);
        req.getRequestDispatcher("customers/edit.jsp").forward(req,resp);
    }


    private static void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("customers/create.jsp").forward(req, resp);
    }

    private void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = customerService.findById(id);
        req.setAttribute("customer", customer);
        req.getRequestDispatcher("/customers/delete.jsp").forward(req,resp);
    }

    private void listCustomers(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = customerService.findAll();
        request.setAttribute("customers", customers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("customers/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    /* ================================================================================================== */
    /* doPost() */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(req, resp);
                break;
            case "edit":
                updateCustomer(req, resp);
                break;
            case "delete":
                deleteCustomer(req, resp);
                break;
            default:
                break;
        }
    }

    private void updateCustomer(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        int id = Integer.parseInt((req.getParameter("id")));
        Customer customer = customerService.findById(id);
        customer.setName(name);
        customer.setEmail(email);
        customer.setAddress(address);
        customerService.update(id, customer);
        req.setAttribute("customer", customer);
        RequestDispatcher dispatcher = req.getRequestDispatcher("customers/edit.jsp");
        req.setAttribute("message", "Customer was updated !!!");
        try {
            dispatcher.forward(req, resp);

        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void deleteCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        customerService.remove(id);
        resp.sendRedirect("/customers");
    }

    private void createCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        int id = (int) (Math.random() * 10000);

        Customer customer = new Customer(id, name, email, address);
        customerService.save(customer);

        RequestDispatcher dispatcher = req.getRequestDispatcher("customers/create.jsp");
        req.setAttribute("message", "New customer was created !!!");
        try {
            dispatcher.forward(req, resp);

        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
        /* lúc ni là nó getRequestDispatcher ròi nên là dòng dưới ni ko chạy */
//        resp.sendRedirect("/customers");
    }
    /* ================================================================================================== */
}
