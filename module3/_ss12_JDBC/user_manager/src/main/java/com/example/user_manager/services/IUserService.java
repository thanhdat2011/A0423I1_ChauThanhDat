package com.example.user_manager.services;

import com.example.user_manager.models.User;

import java.util.List;

public interface IUserService {

    List<User> getAll();

    User findById(int id);

    void add(User user);

    void update(User user);

    void delete(int id);

    List<User> searchByCountry(String country);

    User getUserByIdSP(int id);
    void insertUserSP(User user);
}
