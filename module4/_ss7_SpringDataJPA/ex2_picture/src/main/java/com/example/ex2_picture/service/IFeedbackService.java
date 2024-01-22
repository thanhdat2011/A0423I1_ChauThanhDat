package com.example.ex2_picture.service;

import com.example.ex2_picture.model.Feedback;

import java.util.List;

public interface IFeedbackService {
    void save(Feedback feedback);

    List<Feedback> findAllInDay(int day);

    Feedback findFeedbackById(Long id);
}
