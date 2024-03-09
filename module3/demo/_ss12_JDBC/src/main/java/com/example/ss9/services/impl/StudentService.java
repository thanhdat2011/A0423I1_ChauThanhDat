package com.example.ss9.services.impl;

import com.example.ss9.models.Student;
import com.example.ss9.repositories.IStudentRepository;
import com.example.ss9.repositories.impl.StudentRepository;
import com.example.ss9.services.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    private IStudentRepository iStudentRepository = new StudentRepository();
    @Override
    public List<Student> getAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public void addStudent(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public void deleteById(int id) {
        iStudentRepository.deleteById(id);
    }
}
