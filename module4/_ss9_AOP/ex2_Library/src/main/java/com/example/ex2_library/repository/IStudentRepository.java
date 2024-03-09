package com.example.ex2_library.repository;

import com.example.ex2_library.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IStudentRepository extends JpaRepository<Student, String> {
    @Query(value = "select * from Student where student_name like %:keySearch%", nativeQuery = true)
    Page<Student> findByName(Pageable pageable, String keySearch);
}
