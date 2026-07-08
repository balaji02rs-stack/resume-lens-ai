package com.resumelens.backend.service;

import com.resumelens.backend.dto.JobMatchResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobMatchService {

    public JobMatchResponse matchResume(String resumeText, String jobDescription) {

        List<String> matchedSkills = new ArrayList<>();
        List<String> missingSkills = new ArrayList<>();
        List<String> recommendations = new ArrayList<>();

        List<String> skills = Arrays.asList(
                "Java",
                "Spring Boot",
                "SQL",
                "Python",
                "Docker",
                "Git",
                "AWS",
                "REST API",
                "JUnit",
                "Kafka",
                "Microservices"
        );

        int matched = 0;

        String resume = resumeText.toLowerCase();
        String job = jobDescription.toLowerCase();

        for (String skill : skills) {

            boolean required = job.contains(skill.toLowerCase());
            boolean available = resume.contains(skill.toLowerCase());

            if (required && available) {
                matchedSkills.add(skill);
                matched++;
            }

            if (required && !available) {
                missingSkills.add(skill);
                recommendations.add("Consider adding experience with " + skill + ".");
            }
        }

        int totalRequired = matchedSkills.size() + missingSkills.size();

        int score = totalRequired == 0
                ? 100
                : (matched * 100) / totalRequired;

        return new JobMatchResponse(
                score,
                matchedSkills,
                missingSkills,
                recommendations
        );
    }
}
