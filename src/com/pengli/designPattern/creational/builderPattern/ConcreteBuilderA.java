package com.pengli.designPattern.creational.builderPattern;

/**
 * @Author pengli
 * @Date 25/4/2023
 * @Version 1.0
 */
public class ConcreteBuilderA implements Builder{

    private final BuilderProduct product = new BuilderProduct();
    @Override
    public void buildPartA() {
        System.out.println("===ConcreteBuilderA buildPartA===");
        product.add("部件A");
    }

    @Override
    public void buildPartB() {
        System.out.println("===ConcreteBuilderA buildPartB===");
        product.add("部件B");
    }

    @Override
    public BuilderProduct getResult() {
        return product;
    }
}
