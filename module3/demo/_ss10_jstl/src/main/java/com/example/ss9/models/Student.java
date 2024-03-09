package com.example.ss9.models;

public class Student {
    private Integer id;
    private String name;
    private Boolean gender;

    private Double point;

    public Student() {
    }

    public Student(Integer id, String name, Boolean gender, Double point) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.point = point;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }
}
