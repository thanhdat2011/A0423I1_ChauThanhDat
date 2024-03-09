package com.example.security.service;

import com.example.security.model.User;

public interface UserService {
    User findUserByEmail(String email);
}
