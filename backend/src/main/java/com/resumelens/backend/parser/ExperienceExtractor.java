package com.resumelens.backend.parser;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExperienceExtractor {

    public List<String> extract(String text) {

        List<String> experience = new ArrayList<>();

        String[] lines = text.split("\\R");

        boolean capture = false;

        for (String line : lines) {

            String current = line.trim();

            if (current.equalsIgnoreCase("Experience")) {
                capture = true;
                continue;
            }

            if (capture) {

                if (current.isBlank()) {
                    break;
                }

                experience.add(current);
            }
        }

        return experience;
    }
}