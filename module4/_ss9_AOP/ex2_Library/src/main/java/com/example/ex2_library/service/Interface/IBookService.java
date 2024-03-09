package com.example.ex2_library.service.Interface;

import com.example.ex2_library.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {
    List<Book> getBookList();

    void addNewBook(Book book);

    Book findById(Long book);

    Page<Book> findAllPage(Pageable pageable);


    void updateAmountOfBook(Book book);
}
