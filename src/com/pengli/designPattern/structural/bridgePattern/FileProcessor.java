package com.pengli.designPattern.structural.bridgePattern;

abstract  class FileProcessor {
    protected FileFormat fileFormat;

    public FileProcessor(FileFormat fileFormat) {
        this.fileFormat = fileFormat;
    }

    public abstract void processFile(String data);
    public abstract String getFileInfo();

    public void setFileFormat(FileFormat fileFormat) {
        this.fileFormat = fileFormat;
    }
}
