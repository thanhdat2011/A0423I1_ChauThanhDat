package com.example.ex2.service;

import com.example.ex2.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    void save(Music music);
}
