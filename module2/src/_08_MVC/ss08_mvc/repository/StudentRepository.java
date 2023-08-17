package ss08_mvc.repository;

import ss08_mvc.model.Student;

public interface StudentRepository {
    Student[] findAll();
    void addStudent(Student student);
}
