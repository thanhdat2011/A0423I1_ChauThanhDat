package com.example.springboot.repository.student;

import com.example.springboot.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student,Long> {
    Page<Student> findAll(Pageable pageable);

    @Query(value = "select * from student where name like %:key%", nativeQuery = true)
    Page<Student> findStudentByNameContainsIgnoreCase(Pageable pageable, @Param("key") String key);

}
