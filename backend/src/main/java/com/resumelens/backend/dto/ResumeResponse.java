package com.resumelens.backend.dto;

import java.time.LocalDateTime;

public class ResumeResponse {

    private Long id;
    private String fileName;
    private Integer atsScore;
    private Integer jobMatchScore;
    private String extractedSkills;
    private LocalDateTime uploadedAt;

    public ResumeResponse() {
    }

    public ResumeResponse(Long id, String fileName, Integer atsScore,
                          Integer jobMatchScore, String extractedSkills,
                          LocalDateTime uploadedAt) {
        this.id = id;
        this.fileName = fileName;
        this.atsScore = atsScore;
        this.jobMatchScore = jobMatchScore;
        this.extractedSkills = extractedSkills;
        this.uploadedAt = uploadedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getAtsScore() {
        return atsScore;
    }

    public void setAtsScore(Integer atsScore) {
        this.atsScore = atsScore;
    }

    public Integer getJobMatchScore() {
        return jobMatchScore;
    }

    public void setJobMatchScore(Integer jobMatchScore) {
        this.jobMatchScore = jobMatchScore;
    }

    public String getExtractedSkills() {
        return extractedSkills;
    }

    public void setExtractedSkills(String extractedSkills) {
        this.extractedSkills = extractedSkills;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
}