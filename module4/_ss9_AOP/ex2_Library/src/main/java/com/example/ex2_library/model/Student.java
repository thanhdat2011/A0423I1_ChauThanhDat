package com.example.ex2_library.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Student {
    @Id
    private String studentId;
    private String studentName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
    @ManyToOne
    @JoinColumn(name = "classId")
    private FPTClass fptClass;

    @OneToMany(mappedBy = "student")
    private List<StudentRentBook> studentRentBookList;
    public Student() {
    }

    public Student(String studentId, String studentName, LocalDate dob, FPTClass fptClass) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.dob = dob;
        this.fptClass = fptClass;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public FPTClass getFptClass() {
        return fptClass;
    }

    public void setFptClass(FPTClass fptClass) {
        this.fptClass = fptClass;
    }

    public List<StudentRentBook> getStudentRentBookList() {
        return studentRentBookList;
    }

    public void setStudentRentBookList(List<StudentRentBook> studentRentBookList) {
        this.studentRentBookList = studentRentBookList;
    }
}
