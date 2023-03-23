package com.pengli.designPattern.decoratorPattern;

/**
 * @Author pengli
 * @Date 2023/3/22
 * @Version 1.0
 */
public class DecoratorDemo {


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
