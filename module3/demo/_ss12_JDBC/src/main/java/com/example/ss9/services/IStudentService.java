package com.example.ss9.services;

import com.example.ss9.models.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAll();

    void addStudent(Student student);

    void deleteById(int id);
}
