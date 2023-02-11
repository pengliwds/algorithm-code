package com.pengli.designPattern.strategyPattern.common;

public class SlowEatStrategy implements EatStrategy{
    @Override
    public void eat() {
        System.out.println("每天吃饭时间想吃多久吃多久");
    }
}
