package com.resumelens.backend.service;

import com.resumelens.backend.dto.ApiResponse;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {

    public ApiResponse getApplicationInfo() {

        return new ApiResponse(
                "SUCCESS",
                "Welcome to ResumeLens AI Backend"
        );
    }

}