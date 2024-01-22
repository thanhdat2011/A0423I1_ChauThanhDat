package com.example.springboot.service.student;

import com.example.springboot.model.Student;
import com.example.springboot.repository.student.IStudentRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudentRepository iStudentRepository;
//    @Override
//    public List<Student> showList() {
//        return iStudentRepository.findAll();
//    }


    @Override
    public void save(Student student) {
        iStudentRepository.save(student);
    }


    @Override
    public void deleteById(Long id) {
        iStudentRepository.deleteById(id);
    }

    @Override
    public Student getStudentById(Long id) {
        return iStudentRepository.getReferenceById(id);
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return iStudentRepository.findAll(pageable);
    }

    @Override
    public Page<Student> searchStudentByName(Pageable pageable, String keySearch) {
        return iStudentRepository.findStudentByNameContainsIgnoreCase(pageable, keySearch);
    }

//    @Override
//    public List<Student> searchStudentByName(String keySearch) {
//        return iStudentRepository.findStudentByNameContainsIgnoreCase(keySearch);
//    }


}
