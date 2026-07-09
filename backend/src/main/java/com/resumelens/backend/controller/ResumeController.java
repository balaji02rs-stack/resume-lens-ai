package com.resumelens.backend.controller;

import com.resumelens.backend.dto.*;
import com.resumelens.backend.security.UserDetailsImpl;
import com.resumelens.backend.service.ResumeAnalysisService;
import com.resumelens.backend.service.ResumeService;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    private final ResumeService resumeService;
    private final ResumeAnalysisService resumeAnalysisService;

    public ResumeController(
            ResumeService resumeService,
            ResumeAnalysisService resumeAnalysisService) {

        this.resumeService = resumeService;
        this.resumeAnalysisService = resumeAnalysisService;
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

    @PostMapping(value = "/parse", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ParsedResumeResponse parseResume(
            @RequestParam("file") MultipartFile file) throws IOException {

        return resumeService.parseResume(file);
    }

    @PostMapping(value = "/ats-score", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public AtsScoreResponse atsScore(
            @RequestParam("file") MultipartFile file) throws IOException {

        return resumeService.calculateAtsScore(file);
    }

    @PostMapping(value = "/job-match", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public JobMatchResponse jobMatch(
            @RequestParam("file") MultipartFile file,
            @RequestParam("jobDescription") String jobDescription)
            throws IOException {

        return resumeService.matchResume(file, jobDescription);
    }

    @PostMapping(value = "/analyze", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResumeAnalysisResponse analyzeResume(
            @RequestParam("file") MultipartFile file,
            @RequestParam("jobDescription") String jobDescription,
            Authentication authentication)
            throws IOException {

        UserDetailsImpl user =
                (UserDetailsImpl) authentication.getPrincipal();

        return resumeAnalysisService.analyzeResume(
                file,
                jobDescription,
                user.getUsername());
    }

    @GetMapping("/history")
    public List<ResumeHistoryResponse> getHistory(
            Authentication authentication) {

        UserDetailsImpl user =
                (UserDetailsImpl) authentication.getPrincipal();

        return resumeAnalysisService.getResumeHistory(
                user.getUsername());
    }
}