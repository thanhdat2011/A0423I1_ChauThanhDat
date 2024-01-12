package com.example.demo_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@Controller
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    @GetMapping
}