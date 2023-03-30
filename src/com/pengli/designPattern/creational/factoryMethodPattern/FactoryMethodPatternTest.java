package com.pengli.designPattern.creational.factoryMethodPattern;


/**
 * 工厂方法模式
 * 解决工厂模式中开闭原则问题，工厂模式如果新加一种扩展，除了新建类，还需要修改工厂类
 * 工厂方法模式，需要新建类，并新建工厂类，符合开闭原则
 *
 */
public class FactoryMethodPatternTest {


    public static void main(String[] args) {
        Shape circle = new CircleFactory().createShape();
        Shape square = new SquareFactory().createShape();
        Shape triangle = new TriangleFactory().createShape();

        assert circle != null;
        circle.printShape();
        assert square != null;
        square.printShape();
        assert triangle != null;
        triangle.printShape();
    }

}
