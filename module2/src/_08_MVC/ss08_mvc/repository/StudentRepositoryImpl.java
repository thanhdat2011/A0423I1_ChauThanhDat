package ss08_mvc.repository;

import ss08_mvc.model.Student;

/**
 * (C) Copyright 2023 CodeGym Da Nang. All Rights Reserved.
 *
 * @author caube
 * @version 1.0
 * @see <a href="https://danang.codegym.vn/">CodeGym Da Nang</a>
 * @since 7/31/2023
 */
public class StudentRepositoryImpl implements ss08_mvc.repository.StudentRepository {
    //ket noi DB
    private static Student[] studentList;
    private static int size = 0;

    static {
        studentList = new Student[10];
        studentList[0] = new Student(1,"Nguyen Van A");
        studentList[1] = new Student(2,"Nguyen Van B");
        studentList[2] = new Student(3,"Nguyen Van C");
        size = 3;
    }

    @Override
    public Student[] findAll() {
        Student[] students = new Student[size];
        for(int i = 0; i < size; i++){
            students[i] = studentList[i];
        }
        return students;
    }

    @Override
    public void addStudent(Student student) {
        //kiem tra size > 10

        //them moi vao
        studentList[size] = student;
        size++;
    }
}
