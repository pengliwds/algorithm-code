package com.pengli.designPattern.behavioral.visitorPattern;

/**
 * 访问者接口
 */
public interface Visitor {
    void visit(Dog dog);
    void visit(Cat cat);
    void visit(Bird bird);
}