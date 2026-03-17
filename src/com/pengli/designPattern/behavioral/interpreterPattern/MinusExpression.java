package com.pengli.designPattern.behavioral.interpreterPattern;

/**
 * 减法表达式
 * 非终结符表达式
 */
public class MinusExpression implements Expression {
    private Expression left;
    private Expression right;

    public MinusExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() - right.interpret();
    }

    @Override
    public String toString() {
        return "(" + left + " - " + right + ")";
    }
}