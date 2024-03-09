package com.example.user_manager.controllers;

import com.example.user_manager.models.Book;
import com.example.user_manager.models.Student;
import com.example.user_manager.services.ILibraryService;
import com.example.user_manager.services.Impl.LibraryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/books", name = "BookServlet")
public class BookServlet extends HttpServlet {

    private static final ILibraryService libraryService = new LibraryService();
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
            case "studentList":
                listStudent(req,resp);
                break;
            default:
                listBook(req,resp);

        }
    }

    private void listStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = libraryService.getAllStudent();
        req.setAttribute("students", students);
        req.getRequestDispatcher("/books/studentList.jsp").forward(req,resp);
    }


    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookID = req.getParameter("id");
        Book book = libraryService.findBookById(bookID);
        req.setAttribute("bookName", book.getName());
        List<Student> students = libraryService.getStudentForOption();
        req.setAttribute("students", students);

        LocalDate rentDate = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        String rentDate = dateObj.format(formatter);

        req.setAttribute("rentDate", rentDate);
        req.getRequestDispatcher("/books/create.jsp").forward(req,resp);
    }

    private void listBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = libraryService.getAllBook();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/books/bookList.jsp").forward(req,resp);
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

     private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {

     }

    private void doEdit(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }

    private void doCreate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        String cardId = req.getParameter("cardId");
        String bookId = req.getParameter("id");
        String bookName = req.getParameter("bookName");

        String studentName = req.getParameter("studentName");
        Student student = libraryService.findStudentByName(studentName);

//        LocalDate rentDate = LocalDate.parse(req.getParameter("rentDate"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        LocalDate rentDate = LocalDate.parse(req.getParameter("rentDate"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate rentDate = LocalDate.now();
        LocalDate returnDate = LocalDate.parse(req.getParameter("returnDate"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

//        Student student1 = new Student(cardId, bookId, bookName, student.getStudentId() ,rentDate, returnDate);
        Student student1 = new Student(bookId, bookName, student.getStudentId() ,rentDate, returnDate);
        libraryService.addStudent(student1);
        resp.sendRedirect("/books");

    }

}
