package com.example.user_manager.services.Impl;

import com.example.user_manager.models.User;
import com.example.user_manager.repositories.IUserRepo;
import com.example.user_manager.repositories.Impl.UserRepo;
import com.example.user_manager.services.IUserService;

import java.util.List;

public class UserService implements IUserService {
    IUserRepo userRepo = new UserRepo();
    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepo.findById(id);
    }

    @Override
    public void add(User user) {
        userRepo.save(user);
    }

    @Override
    public void update(User user) {
        userRepo.update(user);
    }

    @Override
    public void delete(int id) {
        userRepo.deleteUserById(id);
    }

    @Override
    public List<User> searchByCountry(String country) {
        return userRepo.searchByCountry(country);
    }

    @Override
    public User getUserByIdSP(int id) {
        return userRepo.getUserByIdSP(id);
    }

    @Override
    public void insertUserSP(User user) {
        userRepo.insertUserSP(user);
    }


}
