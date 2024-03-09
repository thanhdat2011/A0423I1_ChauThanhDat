package com.example.ss9.controllers;

import com.example.ss9.models.Student;
import com.example.ss9.services.IStudentService;
import com.example.ss9.services.impl.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = ("/student"), name = "studentController")
public class StudentController extends HttpServlet {
    private IStudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                req.getRequestDispatcher("students/create.jsp").forward(req, resp);
            }
            default: {
                req.setAttribute("name", "A0423I1");
                List<Student> students = studentService.getAll();
                req.setAttribute("students", students);
                req.getRequestDispatcher("students/list.jsp").forward(req, resp);
            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                String name = req.getParameter("name");
                String temp = req.getParameter("gender");
                Boolean gender;
                if (temp.equals("1")) {
                    gender = true;
                } else if (temp.equals("0")) {
                    gender = false;
                } else {
                    gender = null;
                }
                Double point = Double.valueOf(req.getParameter("point"));
                Integer id = (int) (Math.random() * 1000);
                Student student = new Student(id, name, gender, point);
                studentService.addStudent(student);
                 resp.sendRedirect("/student");
            }
            case "delete": {
                int id = Integer.parseInt(req.getParameter("id"));
                studentService.deleteById(id);
                resp.sendRedirect("/student");
            }
        }

    }
}
