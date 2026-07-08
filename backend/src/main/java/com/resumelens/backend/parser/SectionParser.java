package com.resumelens.backend.parser;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SectionParser {

    public List<String> extractSection(String text, String sectionName) {

        List<String> section = new ArrayList<>();

        String[] lines = text.split("\\R");

        boolean capture = false;

        Set<String> sectionHeaders = Set.of(
                "EDUCATION",
                "EXPERIENCE",
                "WORK EXPERIENCE",
                "PROFESSIONAL EXPERIENCE",
                "EMPLOYMENT",
                "SKILLS",
                "PROJECTS",
                "CERTIFICATIONS",
                "LANGUAGES",
                "ACHIEVEMENTS"
        );

        for (String line : lines) {

            String current = line.trim();

            if (current.equalsIgnoreCase(sectionName)) {
                capture = true;
                continue;
            }

            if (capture) {

                String upper = current.toUpperCase();

                if (sectionHeaders.contains(upper)) {
                    break;
                }

                if (!current.isBlank()) {
                    section.add(current);
                }
            }
        }

        return section;
    }

}