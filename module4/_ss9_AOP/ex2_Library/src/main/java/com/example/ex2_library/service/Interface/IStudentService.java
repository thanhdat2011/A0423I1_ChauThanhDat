package com.example.ex2_library.service.Interface;

import com.example.ex2_library.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    List<Student> getStudentList();


    Student findById(String id);

    void removeStudentById(String id);

    void save(Student student);

    Page<Student> getStudentList(Pageable pageable);

    Page<Student> findByName(Pageable pageable, String keySearch);
}
