package com.pengli.designPattern.structural.decoratorPattern;

/**
 * @Author pengli
 * @Date 2023/3/22
 * @Version 1.0
 */
public class Trousers extends PersonDecorator {

    public Trousers(Person person) {
        super(person);
    }

    @Override
    public void doSomething() {
        super.doSomething();
        System.out.println("穿裤子");
    }
}
