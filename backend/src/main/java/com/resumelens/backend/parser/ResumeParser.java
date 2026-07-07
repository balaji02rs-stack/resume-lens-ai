package com.resumelens.backend.parser;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ResumeParser {

    public String extractEmail(String text) {

        Pattern pattern = Pattern.compile("[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+");

        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return matcher.group();
        }

        return "";
    }

    public String extractPhone(String text) {

        Pattern pattern = Pattern.compile("(\\+?\\d[\\d\\-\\s()]{8,}\\d)");

        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return matcher.group();
        }

        return "";
    }

    public String extractName(String text) {

        String[] lines = text.split("\\R");

        for (String line : lines) {

            line = line.trim();

            if (!line.isEmpty() && line.length() < 50) {
                return line;
            }
        }

        return "";
    }

    public List<String> extractSkills(String text) {

        String[] skillDatabase = {
                "Java",
                "Spring Boot",
                "Python",
                "SQL",
                "JavaScript",
                "React",
                "Angular",
                "HTML",
                "CSS",
                "REST API",
                "Git",
                "Docker",
                "AWS",
                "Hibernate",
                "PostgreSQL",
                "MySQL"
        };

        List<String> skills = new ArrayList<>();

        String lowerText = text.toLowerCase();

        for (String skill : skillDatabase) {

            if (lowerText.contains(skill.toLowerCase())) {
                skills.add(skill);
            }
        }

        return skills;
    }

}