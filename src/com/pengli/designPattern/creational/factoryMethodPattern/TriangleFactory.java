package com.pengli.designPattern.creational.factoryMethodPattern;

/**
 * @Author pengli
 * @Date 27/3/2023
 * @Version 1.0
 */
public class TriangleFactory implements ShapeFactory{
    @Override
    public Shape createShape() {
        return new Triangle();
    }
}
