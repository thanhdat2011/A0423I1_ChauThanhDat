package com.example.ex2_library.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class FPTClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classId;
    private String className;

    @OneToMany(mappedBy = "fptClass")
    private List<Student> studentList;

    public FPTClass() {
    }

    public FPTClass(Long classId, String className) {
        this.classId = classId;
        this.className = className;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
