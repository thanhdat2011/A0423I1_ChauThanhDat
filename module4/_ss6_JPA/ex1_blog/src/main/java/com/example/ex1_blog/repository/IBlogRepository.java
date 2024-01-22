package com.example.ex1_blog.repository;


import com.example.ex1_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
//    Page<Blog> findAll(Pageable pageable);

    @Query(value = "select * from Blog where title like %:keySearch%", nativeQuery = true)
    Page<Blog> findBlogByTitleContains(Pageable pageable ,@Param("keySearch") String keySearch);
}
