package com.example.ex2_library.service.Implement;

import com.example.ex2_library.model.StudentRentBook;
import com.example.ex2_library.repository.IStudentRentBookRepository;
import com.example.ex2_library.service.Interface.IStudentRentBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentRentBookServiceImpl implements IStudentRentBookService {
    @Autowired
    private IStudentRentBookRepository iStudentRentBookRepository;
    @Override
    public List<StudentRentBook> findAll() {
        return iStudentRentBookRepository.findAll();
    }

    @Override
    public void rentBook(StudentRentBook studentRentBook) {
        iStudentRentBookRepository.save(studentRentBook);
    }

    @Override
    public StudentRentBook findById(Long id) {
        return iStudentRentBookRepository.getReferenceById(id);
    }

    @Override
    public void removeRentByID(Long id) {
        iStudentRentBookRepository.deleteById(id);
    }
}
