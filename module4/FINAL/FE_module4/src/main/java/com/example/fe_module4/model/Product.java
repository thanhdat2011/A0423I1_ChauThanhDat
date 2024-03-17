package com.example.fe_module4.model;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pId;
    private String pName;
    private double pPrice;
    private String pStatus;

    @ManyToOne
    @JoinColumn(name = "tId")
    private ProductType pType;

    public Product() {
    }

    public Product(String pName, double pPrice, String pStatus) {
        this.pName = pName;
        this.pPrice = pPrice;
        this.pStatus = pStatus;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public double getpPrice() {
        return pPrice;
    }

    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }

    public String getpStatus() {
        return pStatus;
    }

    public void setpStatus(String pStatus) {
        this.pStatus = pStatus;
    }

    public ProductType getpType() {
        return pType;
    }

    public void setpType(ProductType pType) {
        this.pType = pType;
    }
}
