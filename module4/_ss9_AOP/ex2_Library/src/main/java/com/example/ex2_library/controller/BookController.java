package com.example.ex2_library.controller;

import com.example.ex2_library.model.Book;
import com.example.ex2_library.model.DTO.BookDTO;
import com.example.ex2_library.service.Interface.IBookService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService iBookService;

    /* ============================== LIST =================================== */
    @GetMapping("/list")
    public ModelAndView showBookList(@RequestParam(defaultValue = "0", required = false) int page){
        Sort sort = Sort.by("name").ascending();
        Pageable pageable = PageRequest.of(page, 2, sort);
        Page<Book> bookPage = iBookService.findAllPage(pageable);
        return new ModelAndView("/book/list","bookList", bookPage);
    }

    /* ============================== CREATE =================================== */
    @GetMapping("/show-form-create")
    public ModelAndView showCreateForm(){
        return new ModelAndView("/book/create","book", new BookDTO());
    }

    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("book") BookDTO bookDTO,
                            BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/book/create";
        }
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO, book);
        iBookService.addNewBook(book);
        return "redirect:/book/list";
    }

}
