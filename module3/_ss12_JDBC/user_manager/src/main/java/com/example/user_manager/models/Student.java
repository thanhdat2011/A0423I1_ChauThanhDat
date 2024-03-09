package com.example.user_manager.models;

import java.time.LocalDate;
import java.util.Date;

public class Student {
    private String bookId;
    private String bookName;
    private String bookAuthor;
    private String studentName;
    private String studentClass;
    private int studentId;
    private String cardId;
    private LocalDate rentDate;
    private LocalDate returnDate;

    public Student(String cardId,String bookId, String bookName, String bookAuthor, String studentName, String studentClass, LocalDate rentDate, LocalDate returnDate) {
        this.cardId = cardId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    public Student(String cardId, String bookId, String bookName, int studentId, LocalDate rentDate, LocalDate returnDate) {
        this.cardId = cardId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.studentId = studentId;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    public Student(String bookId, String bookName, int studentId, LocalDate rentDate, LocalDate returnDate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.studentId = studentId;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }
    public Student() {
    }

    public Student(int id, String name, String studentClass) {
        this.studentId = id;
        this.studentName = name;
        this.studentClass = studentClass;
    }



    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
