package com.example.product_management.models;

public class Product {
    private int id;
    private String name;
    private String manufacture;
    private double price;
    private int amount;

    public Product(int id, String name, String manufacture, double price, int amount) {
        this.id = id;
        this.name = name;
        this.manufacture = manufacture;
        this.price = price;
        this.amount = amount;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
