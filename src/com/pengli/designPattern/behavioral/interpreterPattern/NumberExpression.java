package com.pengli.designPattern.behavioral.interpreterPattern;

/**
 * 数字表达式
 * 终结符表达式
 */
public class NumberExpression implements Expression {
    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}