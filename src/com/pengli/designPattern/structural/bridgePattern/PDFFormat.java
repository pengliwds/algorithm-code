package com.pengli.designPattern.structural.bridgePattern;

public class PDFFormat implements FileFormat{

    private String content;
    @Override
    public void save(String data) {
        this.content = data;
        System.out.println("保存为PDF格式: " + data);
    }

    @Override
    public String load() {
        System.out.println("从PDF格式加载: " + content);
        return content;
    }
}
