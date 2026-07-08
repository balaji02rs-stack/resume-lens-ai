package com.resumelens.backend.parser;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EducationExtractor {

    private final SectionParser sectionParser;

    public EducationExtractor(SectionParser sectionParser) {
        this.sectionParser = sectionParser;
    }

    public List<String> extract(String text) {

        return sectionParser.extractSection(text, "EDUCATION");
    }
}