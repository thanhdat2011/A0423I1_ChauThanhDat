package com.example.ex2_library.repository;

import com.example.ex2_library.model.StudentRentBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRentBookRepository extends JpaRepository<StudentRentBook, Long> {
}
