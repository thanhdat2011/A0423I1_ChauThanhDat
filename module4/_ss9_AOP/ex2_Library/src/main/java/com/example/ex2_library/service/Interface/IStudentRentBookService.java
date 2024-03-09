package com.example.ex2_library.service.Interface;

import com.example.ex2_library.model.StudentRentBook;

import java.util.List;

public interface IStudentRentBookService {
    List<StudentRentBook> findAll();

    void rentBook(StudentRentBook studentRentBook);

    StudentRentBook findById(Long id);

    void removeRentByID(Long id);
}
