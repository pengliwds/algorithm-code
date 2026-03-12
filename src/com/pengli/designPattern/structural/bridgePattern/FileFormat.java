package com.pengli.designPattern.structural.bridgePattern;

public interface FileFormat {


    void save(String data);

    String load();
}
