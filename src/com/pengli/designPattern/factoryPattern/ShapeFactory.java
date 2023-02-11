package com.pengli.designPattern.factoryPattern;

public class ShapeFactory {

    public static Shape createShape(String type){

        switch (type){
            case "正方形":
                return new Square();
            case "圆形":
                return new Circle();
            case "三角形":
                return new Triangle();
            default:
                return null;

        }
    }

}
