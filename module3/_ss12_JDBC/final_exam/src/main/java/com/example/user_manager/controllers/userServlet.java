package com.example.user_manager.controllers;

import com.example.user_manager.models.User;
import com.example.user_manager.services.IUserService;
import com.example.user_manager.services.Impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@WebServlet(urlPatterns = "/users", name = "userServlet")
public class userServlet extends HttpServlet {
    private static final IUserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action ="";
        }
        switch (action) {
            case "create":
                showCreateForm(req,resp);
                break;
            case "edit":
                showEditForm(req,resp);
                break;
            case "sort":
                doSort(req,resp);
                break;
            default:
                listUser(req,resp);

        }
    }


    private void doSort(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> users = userService.getAll();
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        req.setAttribute("users",users);
        req.getRequestDispatcher("users/sort.jsp").forward(req,resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
//        User user = userService.getUserByIdSP(id);
        User user = userService.findById(id);
        req.setAttribute("user",user);
        req.getRequestDispatcher("users/edit.jsp").forward(req,resp);

    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("users/create.jsp").forward(req,resp);
    }

    private void listUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userService.getAll();
        req.setAttribute("users", users);
        req.getRequestDispatcher("/users/list.jsp").forward(req,resp);
    }


    // ===========================================================================================================

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action ="";
        }
        switch (action) {
            case "create":
                doCreate(req,resp);
                break;
            case "edit":
                doEdit(req,resp);
                break;
            case "delete":
                deleteUser(req,resp);
                break;
            case "search":
                doSearch(req,resp);
                break;
            default:
                break;
        }
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        userService.delete(id);
        resp.sendRedirect("/users");
    }

    private void doEdit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");

        User user = new User(id,name,email,country);
        userService.update(user);
        resp.sendRedirect("/users");
    }

    private void doCreate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        User user = new User(name,email,country);
        userService.insertUserSP(user);
        resp.sendRedirect("/users");
    }

    private void doSearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String country = req.getParameter("country");
        List<User> users = userService.searchByCountrySP(country);
        req.setAttribute("users", users);
        req.getRequestDispatcher("/users/search.jsp").forward(req,resp);
    }
}
