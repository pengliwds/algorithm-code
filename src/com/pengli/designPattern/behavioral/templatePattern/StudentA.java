package com.pengli.designPattern.behavioral.templatePattern;

/**
 * @Author pengli
 * @Date 29/3/2023
 * @Version 1.0
 */
public class StudentA extends AbstractSuperClass{
    @Override
    void doUniqueThingA() {
        System.out.println("刘备");
    }

    @Override
    void doUniqueThingB() {
        System.out.println("A");
    }

    @Override
    void doUniqueThingC() {
        System.out.println("B");
    }
}
