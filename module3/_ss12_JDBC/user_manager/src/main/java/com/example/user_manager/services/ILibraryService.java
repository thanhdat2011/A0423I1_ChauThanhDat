package com.example.user_manager.services;

import com.example.user_manager.models.Book;
import com.example.user_manager.models.Student;

import java.util.List;

public interface IBookService {

    List<Book> getAll();

    Book findById(String bookID);

//    void add(Student student);


//    Book findById(int id);
//
//    void add(Book book);
//
//    void update(Book user);
//
//    void delete(int id);
//
//    List<Book> searchByCountrySP(String country);
//
//    Book getUserByIdSP(int id);
//    void insertUserSP(Book book);
}
