package com.resumelens.backend.controller;

import com.resumelens.backend.dto.ApiResponse;
import com.resumelens.backend.service.ResumeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    private final ResumeService resumeService;

    public HealthController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping("/api/resume/info")
    public ApiResponse applicationInfo() {
        return resumeService.getApplicationInfo();
    }
}