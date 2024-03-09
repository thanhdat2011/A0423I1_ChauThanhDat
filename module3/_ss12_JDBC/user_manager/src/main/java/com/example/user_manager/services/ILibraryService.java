package com.example.user_manager.services;

import com.example.user_manager.models.Book;
import com.example.user_manager.models.Student;

import java.util.List;

public interface ILibraryService {

    List<Book> getAllBook();

    Book findBookById(String bookID);

    void addStudent(Student student);

    Student findStudentByName(String studentName);

    List<Student> getAllStudent();


    List<Student> getStudentForOption();

}
