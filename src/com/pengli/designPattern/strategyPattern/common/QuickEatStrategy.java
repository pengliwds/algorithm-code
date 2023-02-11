package com.pengli.designPattern.strategyPattern.common;

public class QuickEatStrategy implements EatStrategy {
    @Override
    public void eat() {
        System.out.println("每天吃饭时间控制在20分钟");
    }
}
