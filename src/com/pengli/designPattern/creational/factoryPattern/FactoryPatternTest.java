package com.pengli.designPattern.creational.factoryPattern;

public class FactoryPatternTest {


    public static void main(String[] args) {
        Shape circle = ShapeFactory.createShape("圆形");
        Shape square = ShapeFactory.createShape("正方形");
        Shape triangle = ShapeFactory.createShape("三角形");

        assert circle != null;
        circle.printShape();
        assert square != null;
        square.printShape();
        assert triangle != null;
        triangle.printShape();
    }

}
