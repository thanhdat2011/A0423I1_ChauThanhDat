package com.example.user_manager.repositories;

import com.example.user_manager.models.User;

import java.util.List;

public interface IUserRepo {

    List<User> findAll();

    User findById(int id);

    void save(User user);

    void update(User user);

    void deleteUserById(int id);

    List<User> searchByCountrySP(String country);

    User getUserByIdSP(int id);

    void insertUserSP(User user);
}
