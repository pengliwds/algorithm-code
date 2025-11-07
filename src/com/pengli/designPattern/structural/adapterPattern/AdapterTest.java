package com.pengli.designPattern.structural.adapterPattern;


/**
 * 适配器模式
 * 适配器模式（Adapter Pattern）是一种结构型设计模式，它使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
 * 这种模式涉及到一个单独的类，该类负责加入一些额外的功能。
 * 该模式的别名为包装器（Wrapper）。
 * 适配器模式的主要优点是可以让原本由于接口不兼容而不能一起工作的类可以一起工作。
 * 缺点是增加了类的数量，使得系统更加复杂。
 * 使用场景：
 * 1、系统需要使用一些现存的类，而这些类的接口不符合系统的需要。
 * 2、想要建立一个可以重复使用的类，用于与一些彼此之间没有太大关联的一些类，包括一些可能在将来引进的类一起工作。
 *
 */
public class AdapterTest {


    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessorAdapter(new LegacyFileHandler());

        fileProcessor.processFile("test.txt");

        fileProcessor.getFileType();

    }
}
