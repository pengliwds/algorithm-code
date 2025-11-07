package com.pengli.designPattern.structural.adapterPattern;


public class LegacyFileHandler {


    public void read(String fileName) {
        System.out.println("Reading file: " + fileName);
    }

    public String determineFileType(String fileName) {
        System.out.println("Determining file type for: " + fileName);
        if (fileName.endsWith(".txt")) {
            System.out.println("File type is txt");
            return "txt";
        } else if (fileName.endsWith(".pdf")) {
            System.out.println("File type is pdf");
            return "pdf";
        }
        // add more file types here
        return "unknown";
    }

}
