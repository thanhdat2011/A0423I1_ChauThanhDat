package com.example.user_manager.models;

public class Book {
    private String id;
    private String name;
    private String author;
    private int amount;
    private String description;

    public Book(String id, String name, String author, int amount, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.amount = amount;
        this.description = description;
    }

    public Book() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
