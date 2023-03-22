package com.pengli.designPattern.decorator;

/**
 * @Author pengli
 * @Date 2023/3/22
 * @Version 1.0
 */
public class Tshirt extends PersonDecorator {


    @Override
    public void doSomething() {
        super.doSomething();
        System.out.println("穿Tshirt");
    }
}
