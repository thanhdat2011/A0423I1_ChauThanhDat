package com.example.user_manager.repositories.Impl;

import com.example.user_manager.models.Book;
import com.example.user_manager.models.Student;
import com.example.user_manager.repositories.ILibraryRepo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryRepo implements ILibraryRepo {

    private final static String INSERT_USER_SQL = "insert into users(user_name, user_email,user_country) values (?,?,?);";
    private final static String SELECT_ALL_BOOK_SQL = "select * from books;";
    private final static String SELECT_BOOK_BY_ID_SQL = "select * from books where book_id = ?";
    private final static String UPDATE_USER_BY_ID_SQL = "update users set user_name = ?, user_email = ?, user_country = ? where user_id = ?;";
    public static final String DELETE_USER_BY_ID = "delete from users where user_id = ?";


    @Override
    public List<Book> findAllBook() {
        List<Book> users = new ArrayList<>();
        Book book;
        try {
            Statement statement = BaseRepo.getConnectionJavaToDB().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_BOOK_SQL);
            while (resultSet.next()) {
                book = new Book();
                book.setId(resultSet.getString("book_id"));
                book.setName(resultSet.getString("book_name"));
                book.setAuthor(resultSet.getString("book_author"));
                book.setAmount(resultSet.getInt("book_amount"));
                book.setDescription(resultSet.getString("book_description"));
                users.add(book);
            }
        } catch (SQLException e) {
            System.out.println("Error connect to DB");
        }
        return users;
    }

    @Override
    public Book findBookById(String bookID) {
        Book book = null;
        try {
            CallableStatement callableStatement = BaseRepo.getConnectionJavaToDB().prepareCall("call get_book_by_id(?)");
            callableStatement.setString(1, bookID);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("book_name");
                String author = resultSet.getString("book_author");
                int amount = resultSet.getInt("book_amount");
                String description = resultSet.getString("book_description");
                book = new Book(bookID, name, author, amount, description);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

    @Override
    public void addStudent(Student student) {
        try {
            CallableStatement callableStatement = BaseRepo.getConnectionJavaToDB().prepareCall("call rent_book(?,?,?,?)");
//            callableStatement.setString(1, student.getCardId());
            callableStatement.setString(1, student.getBookId());
            callableStatement.setInt(2, student.getStudentId());
            callableStatement.setDate(3, Date.valueOf(student.getRentDate()));
            callableStatement.setDate(4, Date.valueOf(student.getReturnDate()));
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student findStudentByName(String studentName) {
        Student student = null;
        try {
            PreparedStatement preparedStatement = BaseRepo.getConnectionJavaToDB().prepareStatement("select * from students where student_name = ?");
            preparedStatement.setString(1, studentName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("student_id");
                String name = resultSet.getString("student_name");
                String studentClass = resultSet.getString("student_class");
                student = new Student(id, name, studentClass);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    @Override
    public List<Student> findAllStudent() {
        List<Student> students = new ArrayList<>();
        try {
            CallableStatement callableStatement = BaseRepo.getConnectionJavaToDB().prepareCall("call find_all_student()");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                String cardId = resultSet.getString("card_id");
                String bookId = resultSet.getString("book_id");
                String bookName = resultSet.getString("book_name");
                String bookAuthor = resultSet.getString("book_author");
                String studentName = resultSet.getString("student_name");
                String studentClass = resultSet.getString("student_class");
                LocalDate rentDate = resultSet.getDate("rent_date").toLocalDate();
                LocalDate returnDate = resultSet.getDate("return_date").toLocalDate();
                Student student = new Student(cardId, bookId,bookName,bookAuthor,studentName,studentClass,rentDate,returnDate);
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public List<Student> findStudentForOption() {
        List<Student> students = new ArrayList<>();
        try {
            Statement statement = BaseRepo.getConnectionJavaToDB().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from students");
            while (resultSet.next()) {
                int id = resultSet.getInt("student_id");
                String name = resultSet.getString("student_name");
                String studentClass = resultSet.getString("student_class");
                Student student = new Student(id,name,studentClass);
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }


}
