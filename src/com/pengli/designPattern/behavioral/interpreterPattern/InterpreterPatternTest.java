package com.pengli.designPattern.behavioral.interpreterPattern;

/**
 * 解释器模式测试类
 * 演示如何解释和计算算术表达式
 */
public class InterpreterPatternTest {
    public static void main(String[] args) {
        System.out.println("========== 解释器模式测试 ==========");

        // 创建表达式: 10 + 2 * 6 - 4 / 2
        // 根据运算符优先级：乘法/除法优先于加法/减法
        Expression expression = new MinusExpression(
            new PlusExpression(
                new NumberExpression(10),
                new MultiplyExpression(
                    new NumberExpression(2),
                    new NumberExpression(6)
                )
            ),
            new DivideExpression(
                new NumberExpression(4),
                new NumberExpression(2)
            )
        );

        System.out.println("表达式: " + expression);
        System.out.println("计算结果: " + expression.interpret());
        System.out.println("预期结果: 20 ((10 + 12) - 2)");

        System.out.println("\n========== 更多测试用例 ==========");

        // 测试: (5 + 3) * 4
        Expression expression2 = new MultiplyExpression(
            new PlusExpression(
                new NumberExpression(5),
                new NumberExpression(3)
            ),
            new NumberExpression(4)
        );

        System.out.println("表达式: " + expression2);
        System.out.println("计算结果: " + expression2.interpret());
        System.out.println("预期结果: 32 (8 * 4)");

        // 测试: 20 - 5 - 3
        Expression expression3 = new MinusExpression(
            new MinusExpression(
                new NumberExpression(20),
                new NumberExpression(5)
            ),
            new NumberExpression(3)
        );

        System.out.println("表达式: " + expression3);
        System.out.println("计算结果: " + expression3.interpret());
        System.out.println("预期结果: 12 (15 - 3)");

        // 测试: 100 / 5 / 2
        Expression expression4 = new DivideExpression(
            new DivideExpression(
                new NumberExpression(100),
                new NumberExpression(5)
            ),
            new NumberExpression(2)
        );

        System.out.println("表达式: " + expression4);
        System.out.println("计算结果: " + expression4.interpret());
        System.out.println("预期结果: 10 (20 / 2)");

        System.out.println("\n========== 除法异常测试 ==========");

        try {
            // 测试除零异常
            Expression errorExpression = new DivideExpression(
                new NumberExpression(10),
                new NumberExpression(0)
            );
            errorExpression.interpret();
        } catch (ArithmeticException e) {
            System.out.println("捕获到异常: " + e.getMessage());
        }

        System.out.println("\n========== 解释器模式测试完成 ==========");
    }
}