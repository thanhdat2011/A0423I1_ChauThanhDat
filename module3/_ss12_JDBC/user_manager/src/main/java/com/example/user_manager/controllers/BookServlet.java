package com.example.user_manager.controllers;

import com.example.user_manager.models.Book;
import com.example.user_manager.models.Student;
import com.example.user_manager.services.IBookService;
import com.example.user_manager.services.IStudentService;
import com.example.user_manager.services.Impl.BookService;
import com.example.user_manager.services.Impl.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/users", name = "userServlet")
public class userServlet extends HttpServlet {

    private static final IBookService bookService = new BookService();
    private static final IStudentService studentService = new StudentService();
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
//                showEditForm(req,resp);
                break;
            default:
                listBook(req,resp);

        }
    }


//    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int id = Integer.parseInt(req.getParameter("id"));
//        Student user = bookService.findById(id);
//        req.setAttribute("user",user);
//        req.getRequestDispatcher("users/edit.jsp").forward(req,resp);
//
//    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookID = req.getParameter(req.getParameter("id"));
        Book book = bookService.findById(bookID);
        req.setAttribute("bookName", book.getName());
        req.getRequestDispatcher("users/create.jsp").forward(req,resp);
    }

    private void listBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.getAll();
        req.setAttribute("books", books);
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
//                deleteUser(req,resp);
                break;
            default:
                break;
        }
    }

//    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        int id = Integer.parseInt(req.getParameter("id"));
//        bookService.delete(id);
//        resp.sendRedirect("/users");
//    }

    private void doEdit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        int id = Integer.parseInt(req.getParameter("id"));
//        String name = req.getParameter("name");
//        String email = req.getParameter("email");
//        String country = req.getParameter("country");
//
//        Student user = new Student(id,name,email,country);
//        userService.update(user);
//        resp.sendRedirect("/users");
    }

    private void doCreate(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String cardCode = req.getParameter("cardID");
        String bookName = req.getParameter("bookName");
        String studentName = req.getParameter("studentName");

        String rentDate = req.getParameter("rentDate");
        String returnDate = req.getParameter("returnDate");
        Student student = new Student(cardCode, bookName, studentName ,rentDate, returnDate);
//        studentService.add(student);
        resp.sendRedirect("/users");

    }

}
