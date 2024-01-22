package com.example.ex1_blog.controller;


import com.example.ex1_blog.model.Blog;
import com.example.ex1_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@RequestMapping("")
@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
//    @GetMapping("/")
//    public ModelAndView home(){
//        return new ModelAndView("list", "blogList", iBlogService.findAll());
//    }

    @GetMapping("/")
    public ModelAndView home(@RequestParam(defaultValue = "0", required = false) int page){
        Sort sort = Sort.by("publishDate");
        Pageable pageable = PageRequest.of(page, 2, sort);
        Page<Blog> blogPage = iBlogService.findAll(pageable);
        return new ModelAndView("list","blogList", blogPage);

    }

    @GetMapping("/create-blog-form")
    public ModelAndView showCreateForm(){
        return new ModelAndView("create", "blog",new Blog(LocalDate.now()));
    }

    @PostMapping("/add")
    public String createBlog(Blog blog){
        iBlogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/{id}/show-edit-form")
    public ModelAndView showEditForm(@PathVariable Long id){
        Blog blog = iBlogService.findBlogById(id);
        return new ModelAndView("edit", "blog", blog);
//        return new ModelAndView("edit", "blog", new Blog());
    }

    @PostMapping("/edit")
    public String editBlog(Blog blog){
        iBlogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteBlog(@PathVariable Long id){
        iBlogService.deleteBlogById(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/blog")
    public ModelAndView showBlog(@PathVariable Long id){
        return new ModelAndView("content","blog",iBlogService.findBlogById(id));
    }

    @PostMapping("/searchBlog")
    public ModelAndView searchBlog(@RequestParam(defaultValue = "0", required = false) int page, @RequestParam String keySearch){
        Pageable pageable = PageRequest.of(page, 2);
        Page<Blog> blogPage = iBlogService.findBlogByTitle(pageable, keySearch);
        return new ModelAndView("search", "blogList", blogPage);
    }

//    @GetMapping("/searchBlog")
//    public ModelAndView showSearchBlog(@RequestParam(defaultValue = "0", required = false) int page, @RequestParam String keySearch){
//        searchBlog(page, keySearch);
//    }

}
