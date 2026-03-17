package com.pengli.designPattern.behavioral.interpreterPattern;

/**
 * 除法表达式
 * 非终结符表达式
 */
public class DivideExpression implements Expression {
    private Expression left;
    private Expression right;

    public DivideExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        int rightValue = right.interpret();
        if (rightValue == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return left.interpret() / rightValue;
    }

    @Override
    public String toString() {
        return "(" + left + " / " + right + ")";
    }
}