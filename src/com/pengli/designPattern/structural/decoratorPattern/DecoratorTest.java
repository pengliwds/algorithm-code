package com.pengli.designPattern.structural.decoratorPattern;

/**
 * 装饰器模式
 * 解决动态的添加功能需求
 * 在运行时，可以根据条件，自由动态的组装各种功能，最后组合为一个复合体，包含多种功能
 *
 * @Author pengli
 * @Date 2023/3/22
 * @Version 1.0
 */
public class DecoratorTest {


    public static void main(String[] args) {


        Person shoes = new Shoes(new Trousers(new Tshirt(new Yourself())));
        shoes.doSomething();

    }

}
