package com.example.ex2_library.service.Implement;

import com.example.ex2_library.model.Student;
import com.example.ex2_library.repository.IStudentRepository;
import com.example.ex2_library.service.Interface.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentRepository iStudentRepository;
    @Override
    public List<Student> getStudentList() {
        return iStudentRepository.findAll();
    }

    @Override
    public Student findById(String id) {
        return iStudentRepository.getReferenceById(id);
    }

    @Override
    public void removeStudentById(String id) {
        iStudentRepository.deleteById(id);
    }

    @Override
    public void save(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public Page<Student> getStudentList(Pageable pageable) {
        return iStudentRepository.findAll(pageable);
    }

    @Override
    public Page<Student> findByName(Pageable pageable, String keySearch) {
        return iStudentRepository.findByName(pageable, keySearch);
    }
}
