package com.example.ss9.repositories.impl;

import com.example.ss9.models.Student;
import com.example.ss9.repositories.IStudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static List<Student> students = new ArrayList();

    static {
        students.add(new Student(1, "haiTT", true, 9.0));
        students.add(new Student(2, "trungDP", true, 7.0));
        students.add(new Student(3, "LinhNMH", false, 8.0));
        students.add(new Student(4, "Vô danh", null, 5.0));
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void save(Student student) {
        students.add(student);
    }
}
