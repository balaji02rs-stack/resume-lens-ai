package com.resumelens.backend.parser;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EducationExtractor {

    public List<String> extract(String text) {

        List<String> education = new ArrayList<>();

        String[] lines = text.split("\\R");

        boolean capture = false;

        for (String line : lines) {

            String current = line.trim();

            if (current.equalsIgnoreCase("Education")) {
                capture = true;
                continue;
            }

            if (capture) {

                if (current.isBlank()) {
                    break;
                }

                education.add(current);
            }
        }

        return education;
    }
}