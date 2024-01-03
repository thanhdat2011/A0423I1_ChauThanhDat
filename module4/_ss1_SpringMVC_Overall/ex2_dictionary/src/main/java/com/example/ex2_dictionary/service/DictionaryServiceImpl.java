package com.example.ex2_dictionary.service;

import com.example.ex2_dictionary.repository.IDictionaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements IDictionaryService{

    @Autowired
    private IDictionaryRepo repo;
    @Override
    public String search(String search) {
        return repo.search(search);
    }
}
