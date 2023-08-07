package ss08_mvc.service;

import ss08_mvc.model.Student;
import ss08_mvc.repository.StudentRepository;
import ss08_mvc.repository.StudentRepositoryImpl;

/**
 * (C) Copyright 2023 CodeGym Da Nang. All Rights Reserved.
 *
 * @author caube
 * @version 1.0
 * @see <a href="https://danang.codegym.vn/">CodeGym Da Nang</a>
 * @since 7/31/2023
 */
public class StudentServiceImpl implements StudentService{
    private StudentRepository repository = new StudentRepositoryImpl();

    @Override
    public Student[] findAll() {
        return repository.findAll();
    }

    @Override
    public void addStudent(Student student) {
        repository.addStudent(student);
    }
}
