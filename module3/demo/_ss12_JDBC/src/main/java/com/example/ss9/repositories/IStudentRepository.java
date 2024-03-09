package com.example.ss9.repositories;

import com.example.ss9.models.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();

    void save(Student student);

    void deleteById(int id);
}
