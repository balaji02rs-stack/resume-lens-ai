package com.resumelens.backend.controller;

import com.resumelens.backend.dto.ResumeTextResponse;
import com.resumelens.backend.dto.ResumeUploadResponse;
import com.resumelens.backend.service.ResumeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResumeUploadResponse uploadResume(
            @RequestParam("file") MultipartFile file) {

        return resumeService.uploadResume(file);
    }

    @PostMapping(value = "/extract-text", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResumeTextResponse extractText(
            @RequestParam("file") MultipartFile file) throws IOException {

        return resumeService.extractResumeText(file);
    }
}