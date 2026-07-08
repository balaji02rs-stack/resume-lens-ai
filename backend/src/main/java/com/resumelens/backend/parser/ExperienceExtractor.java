package com.resumelens.backend.parser;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExperienceExtractor {

    private final SectionParser sectionParser;

    public ExperienceExtractor(SectionParser sectionParser) {
        this.sectionParser = sectionParser;
    }

    public List<String> extract(String text) {

        List<String> experience = sectionParser.extractSection(text, "EXPERIENCE");

        if (experience.isEmpty()) {
            experience = sectionParser.extractSection(text, "WORK EXPERIENCE");
        }

        if (experience.isEmpty()) {
            experience = sectionParser.extractSection(text, "PROFESSIONAL EXPERIENCE");
        }

        return experience;
    }
}