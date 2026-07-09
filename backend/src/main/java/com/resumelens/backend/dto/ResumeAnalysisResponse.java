package com.resumelens.backend.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ResumeAnalysisResponse {

    private String fileName;
    private int atsScore;
    private int jobMatchScore;
    private List<String> skills;
    private List<String> education;
    private List<String> experience;
    private LocalDateTime uploadedAt;
    private boolean saved;

    public ResumeAnalysisResponse() {
    }

    public ResumeAnalysisResponse(
            String fileName,
            int atsScore,
            int jobMatchScore,
            List<String> skills,
            List<String> education,
            List<String> experience,
            LocalDateTime uploadedAt,
            boolean saved) {

        this.fileName = fileName;
        this.atsScore = atsScore;
        this.jobMatchScore = jobMatchScore;
        this.skills = skills;
        this.education = education;
        this.experience = experience;
        this.uploadedAt = uploadedAt;
        this.saved = saved;
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

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getEducation() {
        return education;
    }

    public void setEducation(List<String> education) {
        this.education = education;
    }

    public List<String> getExperience() {
        return experience;
    }

    public void setExperience(List<String> experience) {
        this.experience = experience;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }
}