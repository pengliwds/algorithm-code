package com.pengli.designPattern.structural.flyweightPattern;

public class ConcreteChessPiece extends ChessPiece{
    public ConcreteChessPiece(String color) {
        super(color);
        System.out.println("创建 " + color + " 棋子");
    }

    @Override
    public void display(Position position) {
        System.out.println(color + "棋子放在位置 (" +
                position.getX() + ", " + position.getY() + ")");
    }
}
