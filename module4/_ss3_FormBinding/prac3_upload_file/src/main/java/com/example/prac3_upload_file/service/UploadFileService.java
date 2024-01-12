package com.example.prac3_upload_file.service;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class UploadFileService {
    public void uploadFile(MultipartFile file) throws IOException {
        String folderUpload = "D:\\CodeGym\\module4\\_ss3_FormBinding\\prac3_upload_file\\src\\main\\webapp\\WEB-INF\\img\\";
        String fileName = file.getOriginalFilename();
        FileCopyUtils.copy(file.getBytes(), new File(folderUpload + fileName));

    }
}
