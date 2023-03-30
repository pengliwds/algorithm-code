package com.pengli.designPattern.behavioral.templatePattern;

/**
 * @Author pengli
 * @Date 29/3/2023
 * @Version 1.0
 */
public class StudentB extends AbstractSuperClass{
    @Override
    void doUniqueThingA() {
        System.out.println("张飞");
    }

    @Override
    void doUniqueThingB() {
        System.out.println("C");
    }

    @Override
    void doUniqueThingC() {
        System.out.println("A");
    }
}
