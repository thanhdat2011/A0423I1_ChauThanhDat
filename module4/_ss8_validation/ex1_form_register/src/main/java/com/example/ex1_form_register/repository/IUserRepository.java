package com.example.ex1_form_register.repository;

import com.example.ex1_form_register.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
