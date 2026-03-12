package com.pengli.designPattern.structural.bridgePattern;

public class DOCXFormat implements FileFormat{

    private String content;

    @Override
    public void save(String data) {
        this.content = data;
        System.out.println("保存为DOCX格式: " + data);
    }

    @Override
    public String load() {
        System.out.println("从DOCX格式加载: " + content);
        return content;
    }
}
