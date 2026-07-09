package com.resumelens.backend.dto;

import java.time.LocalDateTime;

public class ResumeHistoryResponse {

    private Long id;
    private String fileName;
    private int atsScore;
    private int jobMatchScore;
    private LocalDateTime uploadedAt;

    public ResumeHistoryResponse() {
    }

    public ResumeHistoryResponse(
            Long id,
            String fileName,
            int atsScore,
            int jobMatchScore,
            LocalDateTime uploadedAt) {

        this.id = id;
        this.fileName = fileName;
        this.atsScore = atsScore;
        this.jobMatchScore = jobMatchScore;
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

    public int getAtsScore() {
        return atsScore;
    }

    public void setAtsScore(int atsScore) {
        this.atsScore = atsScore;
    }

    public int getJobMatchScore() {
        return jobMatchScore;
    }

    public void setJobMatchScore(int jobMatchScore) {
        this.jobMatchScore = jobMatchScore;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
}