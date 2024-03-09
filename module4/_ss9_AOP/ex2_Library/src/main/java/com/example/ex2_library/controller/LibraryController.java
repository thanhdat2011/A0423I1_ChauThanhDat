package com.example.ex2_library.controller;

import com.example.ex2_library.model.Book;
import com.example.ex2_library.model.DTO.StudentRentBookDTO;
import com.example.ex2_library.model.Student;
import com.example.ex2_library.model.StudentRentBook;
import com.example.ex2_library.service.Interface.IBookService;
import com.example.ex2_library.service.Interface.IStudentRentBookService;
import com.example.ex2_library.service.Interface.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/library")
public class LibraryController {
    @Autowired
    private IStudentRentBookService iStudentRentBookService;
    @Autowired
    private IStudentService iStudentService;
    @Autowired
    private IBookService iBookService;

    @GetMapping
    public String showLibrary(){
        return "home";
    }

    @ModelAttribute("bookList")
    public List<Book> getBookList(){
        return iBookService.getBookList();
    }

    @ModelAttribute("studentList")
    public List<Student> getStudentList(){
        return iStudentService.getStudentList();
    }

    /* ============================== LIST =================================== */
    @GetMapping("/list")
    public ModelAndView getRentList(){
        return new ModelAndView("/rentBook/list", "rentList", iStudentRentBookService.findAll());
    }

    /* ============================== CREATE =================================== */
    @GetMapping("/show-form-rent")
    public ModelAndView showRentForm(){
        return new ModelAndView("/rentBook/rent", "rentBook", new StudentRentBookDTO());
    }

    @PostMapping("/rent")
    public String rent(@Valid @ModelAttribute("rentBook") StudentRentBookDTO studentRentBookDTO,
                       BindingResult bindingResult,
                       Model model){
        new StudentRentBookDTO().validate(studentRentBookDTO, bindingResult);
        if (bindingResult.hasErrors()){
            return "/rentBook/rent";
        }
        int bookRent = studentRentBookDTO.getAmount();
        int bookInLibrary = iBookService.findById(studentRentBookDTO.getBook()).getAmount();
        // Check book rent < available book in library
        if (bookRent > bookInLibrary) {
            model.addAttribute("msg", "Book is not enough !!!");
            return "rentBook/rent";
        } else {

            StudentRentBook studentRentBook = new StudentRentBook();
            Student student = iStudentService.findById(studentRentBookDTO.getStudent());
            Book book = iBookService.findById(studentRentBookDTO.getBook());

            BeanUtils.copyProperties(studentRentBookDTO, studentRentBook);
            studentRentBook.setStudent(student);
            studentRentBook.setBook(book);
            studentRentBook.setRentDate(LocalDate.now());
            iStudentRentBookService.rentBook(studentRentBook);

            // trừ sách trong thư viện
            book.setAmount(bookInLibrary - bookRent);
            iBookService.updateAmountOfBook(book);
        }
        return "redirect:/library/list";
    }

    /* ============================== DELETE =================================== */

    @PostMapping("/{id}/delete")
    public String giveBookBack(@PathVariable Long id){
        // update lại sách trong thư viện
        StudentRentBook studentRentBook = iStudentRentBookService.findById(id);
        System.out.println(studentRentBook);
        Book book = iBookService.findById(studentRentBook.getBook().getBookId());
        book.setAmount(book.getAmount() + studentRentBook.getAmount());
        iBookService.updateAmountOfBook(book);

        // rồi mới xóa
        iStudentRentBookService.removeRentByID(id);
        return "redirect:/library/list";
    }
}
