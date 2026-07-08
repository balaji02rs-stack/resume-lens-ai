package com.resumelens.backend.service;

import com.resumelens.backend.dto.AtsScoreResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AtsScoreService {

    public AtsScoreResponse calculateScore(String resumeText) {

        int score = 50;

        List<String> strengths = new ArrayList<>();
        List<String> missingKeywords = new ArrayList<>();
        List<String> recommendations = new ArrayList<>();

        if (resumeText.toLowerCase().contains("java")) {
            score += 10;
            strengths.add("Java skills detected");
        } else {
            missingKeywords.add("Java");
        }

        if (resumeText.toLowerCase().contains("spring")) {
            score += 10;
            strengths.add("Spring Boot experience found");
        } else {
            missingKeywords.add("Spring Boot");
        }

        if (resumeText.toLowerCase().contains("sql")) {
            score += 10;
            strengths.add("SQL skills found");
        } else {
            missingKeywords.add("SQL");
        }

        if (resumeText.toLowerCase().contains("docker")) {
            score += 5;
            strengths.add("Docker experience found");
        } else {
            recommendations.add("Consider learning Docker");
        }

        if (resumeText.toLowerCase().contains("git")) {
            score += 5;
            strengths.add("Git experience found");
        }

        if (score > 100) {
            score = 100;
        }

        return new AtsScoreResponse(
                score,
                strengths,
                missingKeywords,
                recommendations
        );
    }
}