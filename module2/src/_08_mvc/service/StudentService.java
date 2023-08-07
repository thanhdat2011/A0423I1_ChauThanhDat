package ss08_mvc.service;

import ss08_mvc.model.Student;

public interface StudentService {
    //CRUD
    Student[] findAll();
    void addStudent(Student student);

    //Validation - kiem tra dữ liệu đầu vào
}
