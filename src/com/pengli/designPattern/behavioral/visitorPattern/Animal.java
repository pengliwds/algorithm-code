package com.pengli.designPattern.behavioral.visitorPattern;

/**
 * 动物接口（元素接口）
 */
public interface Animal {
    void accept(Visitor visitor);
    String getName();
    int getAge();
}