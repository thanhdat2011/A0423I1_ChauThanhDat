package com.example.springboot.service.student;

import com.example.springboot.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
//    List<Student> showList();
    void save(Student student);



    void deleteById(Long id);


    Student getStudentById(Long id);

    Page<Student> findAll(Pageable pageable);

    Page<Student> searchStudentByName(Pageable pageable, String keySearch);

//    List<Student> searchStudentByName(String keySearch);

}
