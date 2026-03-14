package com.pengli.designPattern.structural.flyweightPattern;

public abstract class ChessPiece {

    // 内部状态：颜色
    protected String color;

    public ChessPiece(String color) {
        this.color = color;
    }

    // 外部状态：位置
    public abstract void display(Position position);
}
