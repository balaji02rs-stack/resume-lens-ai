package com.resumelens.backend.dto;

import java.util.List;

public class AtsScoreResponse {

    private int atsScore;
    private List<String> strengths;
    private List<String> missingKeywords;
    private List<String> recommendations;

    public AtsScoreResponse() {
    }

    public AtsScoreResponse(
            int atsScore,
            List<String> strengths,
            List<String> missingKeywords,
            List<String> recommendations) {

        this.atsScore = atsScore;
        this.strengths = strengths;
        this.missingKeywords = missingKeywords;
        this.recommendations = recommendations;
    }

    public int getAtsScore() {
        return atsScore;
    }

    public void setAtsScore(int atsScore) {
        this.atsScore = atsScore;
    }

    public List<String> getStrengths() {
        return strengths;
    }

    public void setStrengths(List<String> strengths) {
        this.strengths = strengths;
    }

    public List<String> getMissingKeywords() {
        return missingKeywords;
    }

    public void setMissingKeywords(List<String> missingKeywords) {
        this.missingKeywords = missingKeywords;
    }

    public List<String> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<String> recommendations) {
        this.recommendations = recommendations;
    }
}