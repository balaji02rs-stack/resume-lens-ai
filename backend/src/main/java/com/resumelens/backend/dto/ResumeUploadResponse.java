package com.resumelens.backend.dto;

public class ResumeUploadResponse {

    private String fileName;
    private long fileSize;
    private String fileType;
    private String status;

    public ResumeUploadResponse() {
    }

    public ResumeUploadResponse(String fileName, long fileSize, String fileType, String status) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileType = fileType;
        this.status = status;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
