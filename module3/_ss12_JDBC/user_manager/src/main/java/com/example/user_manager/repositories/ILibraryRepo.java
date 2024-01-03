package com.example.user_manager.repositories;

import com.example.user_manager.models.Book;

import java.util.List;

public interface IBookRepo {

    List<Book> findAll();

    Book findById(String bookID);

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
