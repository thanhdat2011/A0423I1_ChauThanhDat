package com.example.ex2.repository;


import com.example.ex2.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMusicRepository extends JpaRepository<Music, Long> {

}
