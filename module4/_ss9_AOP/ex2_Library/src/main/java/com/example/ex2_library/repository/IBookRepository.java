package com.example.ex2_library.repository;

import com.example.ex2_library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IBookRepository extends JpaRepository<Book, Long> {
}
