package com.example.prac3_upload_file.controller;

import com.example.prac3_upload_file.model.Upload;
import com.example.prac3_upload_file.service.UploadFileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class DemoController {
    @RequestMapping("/demo")
    public ModelAndView demo(){
        ModelAndView modelAndView = new ModelAndView("demo");
        modelAndView.addObject("upload", new Upload());
        return modelAndView;
    }
    @PostMapping("/upload")
    public ModelAndView upload(Upload upload) throws IOException {
        ModelAndView modelAndView = new ModelAndView("view");
        UploadFileService uploadFileService = new UploadFileService();
        uploadFileService.uploadFile(upload.getFile());
        return modelAndView;
    }
}
