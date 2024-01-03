package com.example.user_manager.services.Impl;

import com.example.user_manager.models.Book;
import com.example.user_manager.models.Student;
import com.example.user_manager.repositories.IBookRepo;
import com.example.user_manager.repositories.Impl.BookRepo;
import com.example.user_manager.services.IBookService;

import java.util.List;

public class BookService implements IBookService {
    IBookRepo bookRepo = new BookRepo();
    @Override
    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    @Override
    public Book findById(String bookID) {
        return bookRepo.findById(bookID);
    }

//    @Override
//    public void add(Student student) {
//        return bookRepo.save(student);
//    }

//    @Override
//    public Book findById(int id) {
//        return userRepo.findById(id);
//    }
//
//    @Override
//    public void add(Book user) {
//        userRepo.save(user);
//    }
//
//    @Override
//    public void update(Book user) {
//        userRepo.update(user);
//    }
//
//    @Override
//    public void delete(int id) {
//        userRepo.deleteUserById(id);
//    }
//
//    @Override
//    public List<Book> searchByCountrySP(String country) {
//        return userRepo.searchByCountrySP(country);
//    }
//
//    @Override
//    public Book getUserByIdSP(int id) {
//        return userRepo.getUserByIdSP(id);
//    }
//
//    @Override
//    public void insertUserSP(Student user) {
//        userRepo.insertUserSP(user);
//    }


}
