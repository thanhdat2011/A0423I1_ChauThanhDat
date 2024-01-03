package com.example.ex2_dictionary.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class DictionaryRepoImpl implements IDictionaryRepo{
    private final static HashMap<String, String> dictionary = new HashMap<>();
    static {
        dictionary.put("dog", "con chó");
        dictionary.put("cat", "con mèo");
        dictionary.put("hippo", "hà mã");
        dictionary.put("bird", "con chim");
        dictionary.put("lion", "sư tử");
        dictionary.put("parrot", "con vẹt");
        dictionary.put("elephant", "con voi");
        dictionary.put("bear", "gấu");
        dictionary.put("hello", "xin chào");
    }
    @Override
    public String search(String search) {
        return dictionary.get(search);
    }
}
