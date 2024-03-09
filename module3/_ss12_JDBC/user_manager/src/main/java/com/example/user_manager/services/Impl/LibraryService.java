package com.example.user_manager.services.Impl;

import com.example.user_manager.models.Book;
import com.example.user_manager.models.Student;
import com.example.user_manager.repositories.ILibraryRepo;
import com.example.user_manager.repositories.Impl.LibraryRepo;
import com.example.user_manager.services.ILibraryService;

import java.util.List;

public class LibraryService implements ILibraryService {
    ILibraryRepo libraryRepo = new LibraryRepo();
    @Override
    public List<Book> getAllBook() {
        return libraryRepo.findAllBook();
    }

    @Override
    public Book findBookById(String bookID) {
        return libraryRepo.findBookById(bookID);
    }

    @Override
    public void addStudent(Student student) {
        libraryRepo.addStudent(student);
    }

    @Override
    public Student findStudentByName(String studentName) {
        return libraryRepo.findStudentByName(studentName);
    }

    @Override
    public List<Student> getAllStudent() {
        return libraryRepo.findAllStudent();
    }

    @Override
    public List<Student> getStudentForOption() {
        return libraryRepo.findStudentForOption();
    }


}
