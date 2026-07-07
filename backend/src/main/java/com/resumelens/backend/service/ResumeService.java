package com.resumelens.backend.service;

import com.resumelens.backend.dto.ApiResponse;
import com.resumelens.backend.dto.ResumeUploadResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ResumeService {

    public ApiResponse getApplicationInfo() {
        return new ApiResponse(
                "SUCCESS",
                "Welcome to ResumeLens AI Backend"
        );
    }

    public ResumeUploadResponse uploadResume(MultipartFile file) {

        return new ResumeUploadResponse(
                file.getOriginalFilename(),
                file.getSize(),
                file.getContentType(),
                "Uploaded Successfully"
        );
    }
}