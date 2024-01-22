package com.example.ex1_form_register.service;

import com.example.ex1_form_register.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void save(User user);
}
