package com.pengli.designPattern.structural.adapterPattern;

public class FileProcessorAdapter implements FileProcessor {

    private LegacyFileHandler legacyFileHandler;

    public FileProcessorAdapter(LegacyFileHandler legacyFileHandler) {
        this.legacyFileHandler = legacyFileHandler;
    }


    @Override
    public void processFile(String fileName) {
        legacyFileHandler.read(fileName);
    }

    @Override
    public String getFileType() {

        return legacyFileHandler.determineFileType("default.txt");
    }
}
