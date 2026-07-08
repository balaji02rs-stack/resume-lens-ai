package com.resumelens.backend.dto;

import java.util.List;

public class JobMatchResponse {

    private int matchScore;
    private List<String> matchedSkills;
    private List<String> missingSkills;
    private List<String> recommendations;

    public JobMatchResponse() {
    }

    public JobMatchResponse(
            int matchScore,
            List<String> matchedSkills,
            List<String> missingSkills,
            List<String> recommendations) {

        this.matchScore = matchScore;
        this.matchedSkills = matchedSkills;
        this.missingSkills = missingSkills;
        this.recommendations = recommendations;
    }

    public int getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(int matchScore) {
        this.matchScore = matchScore;
    }

    public List<String> getMatchedSkills() {
        return matchedSkills;
    }

    public void setMatchedSkills(List<String> matchedSkills) {
        this.matchedSkills = matchedSkills;
    }

    public List<String> getMissingSkills() {
        return missingSkills;
    }

    public void setMissingSkills(List<String> missingSkills) {
        this.missingSkills = missingSkills;
    }

    public List<String> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<String> recommendations) {
        this.recommendations = recommendations;
    }
}
