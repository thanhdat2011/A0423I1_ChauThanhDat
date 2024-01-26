package com.example.ex2.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class MusicDTO{
    private Long id;
    @NotBlank
    @Size(max = 800)
    @Pattern(regexp = "^[A-Za-z0-9 ]*$")
    private String name;

    @NotBlank
    @Size(max = 300)
    @Pattern(regexp = "^[A-Za-z0-9 ]*$")
    private String singer;
    @NotBlank
    @Size(max = 1000)
    @Pattern(regexp = "^[A-Za-z0-9 ,]*$")
    private String type;

    public MusicDTO() {
    }

    public MusicDTO(String name, String singer, String type) {
        this.name = name;
        this.singer = singer;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
