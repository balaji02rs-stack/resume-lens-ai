package com.resumelens.backend.service;

import com.resumelens.backend.dto.ApiResponse;
import com.resumelens.backend.dto.AtsScoreResponse;
import com.resumelens.backend.dto.ParsedResumeResponse;
import com.resumelens.backend.dto.ResumeTextResponse;
import com.resumelens.backend.dto.ResumeUploadResponse;
import com.resumelens.backend.parser.EducationExtractor;
import com.resumelens.backend.parser.ExperienceExtractor;
import com.resumelens.backend.parser.PdfParser;
import com.resumelens.backend.parser.ResumeParser;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ResumeService {

    private final PdfParser pdfParser;
    private final ResumeParser resumeParser;
    private final EducationExtractor educationExtractor;
    private final ExperienceExtractor experienceExtractor;
    private final AtsScoreService atsScoreService;

    public ResumeService(
            PdfParser pdfParser,
            ResumeParser resumeParser,
            EducationExtractor educationExtractor,
            ExperienceExtractor experienceExtractor,
            AtsScoreService atsScoreService) {

        this.pdfParser = pdfParser;
        this.resumeParser = resumeParser;
        this.educationExtractor = educationExtractor;
        this.experienceExtractor = experienceExtractor;
        this.atsScoreService = atsScoreService;
    }

    public ApiResponse getApplicationInfo() {

        return new ApiResponse(
                "SUCCESS",
                "Welcome to ResumeLens AI Backend"
        );
    }

    public ResumeUploadResponse uploadResume(MultipartFile file) {

        return new ResumeUploadResponse(
                file.getOriginalFilename(),
                file.getSize(),
                file.getContentType(),
                "Uploaded Successfully"
        );
    }

    public ResumeTextResponse extractResumeText(MultipartFile file) throws IOException {

        String text = pdfParser.extractText(file);

        return new ResumeTextResponse(text);
    }

    public ParsedResumeResponse parseResume(MultipartFile file) throws IOException {

        String text = pdfParser.extractText(file);

        return new ParsedResumeResponse(
                resumeParser.extractName(text),
                resumeParser.extractEmail(text),
                resumeParser.extractPhone(text),
                resumeParser.extractSkills(text),
                educationExtractor.extract(text),
                experienceExtractor.extract(text)
        );
    }

    public AtsScoreResponse calculateAtsScore(MultipartFile file) throws IOException {

        String text = pdfParser.extractText(file);

        return atsScoreService.calculateScore(text);
    }
}