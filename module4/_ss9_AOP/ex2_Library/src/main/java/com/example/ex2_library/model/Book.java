package com.example.ex2_library.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String name;
    private String author;
    private LocalDate publishDate;
    private int amount;

    @OneToMany(mappedBy = "book")
    List<StudentRentBook> bookRentList;
    public Book() {
    }



    public Book(Long bookId, String name, String author, LocalDate publishDate, int amount) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.publishDate = publishDate;
        this.amount = amount;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<StudentRentBook> getBookRentList() {
        return bookRentList;
    }

    public void setBookRentList(List<StudentRentBook> bookRentList) {
        this.bookRentList = bookRentList;
    }
}
