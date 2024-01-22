package com.example.ex2_picture.service;

import com.example.ex2_picture.model.Feedback;
import com.example.ex2_picture.repository.IFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements IFeedbackService{

    @Autowired
    IFeedbackRepository iFeedbackRepository;
    @Override
    public void save(Feedback feedback) {
        iFeedbackRepository.save(feedback);
    }

    @Override
    public List<Feedback> findAllInDay(int day) {
        return iFeedbackRepository.findAllInDay(day);
    }

    @Override
    public Feedback findFeedbackById(Long id) {
        return iFeedbackRepository.getReferenceById(id);
    }
}
