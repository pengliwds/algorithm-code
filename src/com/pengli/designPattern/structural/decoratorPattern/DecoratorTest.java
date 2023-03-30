package com.pengli.designPattern.structural.decoratorPattern;

/**
 * 装饰器模式
 * 解决动态的添加功能需求
 * 在运行时，可以更加条件，自由动态的组装各种功能，最后组合为一个复合体，包含多种功能
 *
 * @Author pengli
 * @Date 2023/3/22
 * @Version 1.0
 */
public class DecoratorTest {


    public static void main(String[] args) {
        Person person = new Yourself();

        Tshirt tshirt = new Tshirt();
        Trousers trousers = new Trousers();
        Shoes shoes = new Shoes();

        tshirt.setDecorator(person);
        trousers.setDecorator(tshirt);
        shoes.setDecorator(trousers);

        shoes.doSomething();

    }

}
