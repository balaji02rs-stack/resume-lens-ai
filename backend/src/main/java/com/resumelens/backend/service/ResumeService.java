package com.resumelens.backend.service;

import com.resumelens.backend.dto.ApiResponse;
import com.resumelens.backend.dto.ResumeTextResponse;
import com.resumelens.backend.dto.ResumeUploadResponse;
import com.resumelens.backend.parser.PdfParser;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ResumeService {

    private final PdfParser pdfParser;

    public ResumeService(PdfParser pdfParser) {
        this.pdfParser = pdfParser;
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
}