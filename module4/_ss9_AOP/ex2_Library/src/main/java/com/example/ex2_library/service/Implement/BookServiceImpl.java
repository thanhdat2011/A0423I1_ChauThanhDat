package com.example.ex2_library.service.Implement;

import com.example.ex2_library.model.Book;
import com.example.ex2_library.repository.IBookRepository;
import com.example.ex2_library.service.Interface.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;
    @Override
    public List<Book> getBookList() {
        return iBookRepository.findAll();
    }

    @Override
    public void addNewBook(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public Book findById(Long book) {
        return iBookRepository.getReferenceById(book);
    }

    @Override
    public Page<Book> findAllPage(Pageable pageable) {
        return iBookRepository.findAll(pageable);
    }

    @Override
    public void updateAmountOfBook(Book book) {
        iBookRepository.save(book);
    }

}
