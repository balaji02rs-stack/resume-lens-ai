package com.resumelens.backend.service;

import com.resumelens.backend.dto.*;
import com.resumelens.backend.entity.Resume;
import com.resumelens.backend.entity.User;
import com.resumelens.backend.parser.EducationExtractor;
import com.resumelens.backend.parser.ExperienceExtractor;
import com.resumelens.backend.parser.PdfParser;
import com.resumelens.backend.parser.ResumeParser;
import com.resumelens.backend.repository.ResumeRepository;
import com.resumelens.backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResumeAnalysisService {

    private final PdfParser pdfParser;
    private final ResumeParser resumeParser;
    private final EducationExtractor educationExtractor;
    private final ExperienceExtractor experienceExtractor;
    private final AtsScoreService atsScoreService;
    private final JobMatchService jobMatchService;
    private final ResumeRepository resumeRepository;
    private final UserRepository userRepository;

    public ResumeAnalysisService(
            PdfParser pdfParser,
            ResumeParser resumeParser,
            EducationExtractor educationExtractor,
            ExperienceExtractor experienceExtractor,
            AtsScoreService atsScoreService,
            JobMatchService jobMatchService,
            ResumeRepository resumeRepository,
            UserRepository userRepository) {

        this.pdfParser = pdfParser;
        this.resumeParser = resumeParser;
        this.educationExtractor = educationExtractor;
        this.experienceExtractor = experienceExtractor;
        this.atsScoreService = atsScoreService;
        this.jobMatchService = jobMatchService;
        this.resumeRepository = resumeRepository;
        this.userRepository = userRepository;
    }

    public ResumeAnalysisResponse analyzeResume(
            MultipartFile file,
            String jobDescription,
            String email) throws IOException {

        String resumeText = pdfParser.extractText(file);

        ParsedResumeResponse parsedResume = new ParsedResumeResponse(
                resumeParser.extractName(resumeText),
                resumeParser.extractEmail(resumeText),
                resumeParser.extractPhone(resumeText),
                resumeParser.extractSkills(resumeText),
                educationExtractor.extract(resumeText),
                experienceExtractor.extract(resumeText)
        );

        AtsScoreResponse atsScore =
                atsScoreService.calculateScore(resumeText);

        JobMatchResponse jobMatch =
                jobMatchService.matchResume(resumeText, jobDescription);

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Resume resume = new Resume();

        resume.setFileName(file.getOriginalFilename());
        resume.setAtsScore(atsScore.getAtsScore());
        resume.setJobMatchScore(jobMatch.getMatchScore());
        resume.setExtractedSkills(String.join(", ", parsedResume.getSkills()));
        resume.setUploadedAt(LocalDateTime.now());
        resume.setUser(user);

        resumeRepository.save(resume);

        return new ResumeAnalysisResponse(
                file.getOriginalFilename(),
                atsScore.getAtsScore(),
                jobMatch.getMatchScore(),
                parsedResume.getSkills(),
                parsedResume.getEducation(),
                parsedResume.getExperience(),
                resume.getUploadedAt(),
                true
        );
    }

    public List<ResumeHistoryResponse> getResumeHistory(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return resumeRepository.findByUserOrderByUploadedAtDesc(user)
                .stream()
                .map(resume -> new ResumeHistoryResponse(
                        resume.getId(),
                        resume.getFileName(),
                        resume.getAtsScore(),
                        resume.getJobMatchScore(),
                        resume.getUploadedAt()
                ))
                .collect(Collectors.toList());
    }
}