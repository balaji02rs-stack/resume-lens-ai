package com.resumelens.backend.service;

import com.resumelens.backend.dto.ApiResponse;
import com.resumelens.backend.dto.ParsedResumeResponse;
import com.resumelens.backend.dto.ResumeTextResponse;
import com.resumelens.backend.dto.ResumeUploadResponse;
import com.resumelens.backend.parser.PdfParser;
import com.resumelens.backend.parser.ResumeParser;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;

@Service
public class ResumeService {

    private final PdfParser pdfParser;
    private final ResumeParser resumeParser;

    public ResumeService(PdfParser pdfParser, ResumeParser resumeParser) {
        this.pdfParser = pdfParser;
        this.resumeParser = resumeParser;
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
                Collections.emptyList(),
                Collections.emptyList()
        );
    }
}