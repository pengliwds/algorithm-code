package com.pengli.designPattern.strategyPattern.optimize;

/**
 * 使用工厂 + 单例 + Map + 策略模式
 */
public class OptimizeStrategyTest {

    public static void main(String[] args) {

        String type = "疯狂";
//        String type = "适度";

        ExerciseContext context = new ExerciseContext(type);

        context.exercise();

    }
}
