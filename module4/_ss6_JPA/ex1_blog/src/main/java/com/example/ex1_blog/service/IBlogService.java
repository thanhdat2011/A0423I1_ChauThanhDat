package com.example.ex1_blog.service;


import com.example.ex1_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
//    List<Blog> findAll();


    Blog findBlogById(Long id);

    void save(Blog blog);

    Page<Blog> findAll(Pageable pageable);

    void deleteBlogById(Long id);

    Page<Blog> findBlogByTitle(Pageable pageable, String keySearch);
}
