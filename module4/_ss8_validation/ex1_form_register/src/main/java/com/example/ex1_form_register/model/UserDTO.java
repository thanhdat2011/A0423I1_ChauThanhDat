package com.example.ex1_form_register.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class UserDTO implements Validator {
//    Firstname, lastname bắt buộc, có độ dài tối thiểu 5, tối đa 45 ký tự
//
//    Phonenumber đúng quy tắc của sđt
//
//    Age >=18
//
//    Email đúng quy tắc của email
    private Long id;

    @NotBlank
    @Size(min = 5, message = "> 5 character")
    @Size(max = 45, message = "< 45 character")
    private String firstName;
    @NotBlank
    @Size(min = 5, message = "> 5 character")
    @Size(max = 45, message = "< 45 character")
    private String lastName;
    @Pattern(regexp = "^(090|091|[(]84[)][+]90|[(]84[)][+]91)[\\\\d]{7}$")
    private String phone;
    private LocalDate dob;

    @Pattern(regexp = "^[\\\\w.]+@[a-zA-Z0-9]+(\\\\.[a-zA-Z0-9]+){1,2}$")
    private String email;

    public UserDTO() {
    }

    public UserDTO(Long id, String firstName, String lastName, String phone, LocalDate dob, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.dob = dob;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = new UserDTO();
        LocalDate dob =userDTO.getDob();
    }
}
