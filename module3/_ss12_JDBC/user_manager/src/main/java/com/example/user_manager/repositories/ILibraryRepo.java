package com.example.user_manager.repositories;

import com.example.user_manager.models.Book;
import com.example.user_manager.models.Student;

import java.util.List;

public interface ILibraryRepo {

    List<Book> findAllBook();

    Book findBookById(String bookID);

    void addStudent(Student student);

    Student findStudentByName(String studentName);

    List<Student> findAllStudent();

    List<Student> findStudentForOption();



//    Student findById(int id);
//
//    void save(Book user);
//
//    void update(Book user);
//
//    void deleteUserById(int id);
//
//
//    Student getUserByIdSP(int id);
//
//    void insertUserSP(Student user);
}
