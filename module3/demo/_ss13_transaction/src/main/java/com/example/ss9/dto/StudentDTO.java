package com.example.ss9.dto;

public class StudentDTO {
    private Integer id;
    private String name;
    private Boolean gender;

    private Double point;

    private String nameClass;

    public StudentDTO() {
    }

    public StudentDTO(Integer id, String name, Boolean gender, Double point, String nameClass) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.point = point;
        this.nameClass = nameClass;
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
