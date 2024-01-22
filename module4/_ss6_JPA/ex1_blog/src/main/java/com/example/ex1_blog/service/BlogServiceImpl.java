package com.example.ex1_blog.service;


import com.example.ex1_blog.model.Blog;
import com.example.ex1_blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService{

    @Autowired
    IBlogRepository iBlogRepository;

//    @Override
//    public List<Blog> findAll() {
//        return iBlogRepository.findAll();
//    }

    @Override
    public Blog findBlogById(Long id) {
        return iBlogRepository.getReferenceById(id);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public void deleteBlogById(Long id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findBlogByTitle(Pageable pageable, String keySearch) {
        return iBlogRepository.findBlogByTitleContains(pageable, keySearch);
    }


}
