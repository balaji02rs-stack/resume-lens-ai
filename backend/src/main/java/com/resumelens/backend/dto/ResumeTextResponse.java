package com.resumelens.backend.dto;

public class ResumeTextResponse {

    private String extractedText;

    public ResumeTextResponse() {
    }

    public ResumeTextResponse(String extractedText) {
        this.extractedText = extractedText;
    }

    public String getExtractedText() {
        return extractedText;
    }

    public void setExtractedText(String extractedText) {
        this.extractedText = extractedText;
    }
}