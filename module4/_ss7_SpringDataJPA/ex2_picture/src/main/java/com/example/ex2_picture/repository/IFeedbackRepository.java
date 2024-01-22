package com.example.ex2_picture.repository;

import com.example.ex2_picture.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IFeedbackRepository extends JpaRepository<Feedback, Long> {
    @Query(value = "select * from feedback where day(comment_date) = :daynow", nativeQuery = true)
    List<Feedback> findAllInDay(@Param("daynow") int daynow);

}
