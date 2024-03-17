package vn.codegym.repository;

import org.springframework.stereotype.Repository;
import vn.codegym.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * (C) Copyright 2023 iHub Academy. All Rights Reserved.
 *
 * @author TrungDC
 * @version 1.0
 * @since 12/27/2023
 */
@Repository
public class StudentRepositoryImpl implements IStudentRepository {
    private static List<Student> studentList;

    static {
        studentList = new ArrayList<>();
        studentList.add(new Student(1, " Nguyen Van A", 1, new String[]{"Java", "C#"}));
        studentList.add(new Student(2, " Nguyen Van B", 0, new String[]{"C#"}));
        studentList.add(new Student(3, " Nguyen Van C", 2, new String[]{"Java"}));
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public void save(Student student) {
        studentList.add(student);
    }

    @Override
    public List<Student> findByName(String keyword) {
        return null;
    }
}