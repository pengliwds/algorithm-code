package com.pengli.designPattern.creational.builderPattern;

/**
 * @Author pengli
 * @Date 25/4/2023
 * @Version 1.0
 */
public class ConcreteBuilderB implements Builder{

    private final BuilderProduct product = new BuilderProduct();
    @Override
    public void buildPartA() {
        System.out.println("===ConcreteBuilderB buildPartA===");
        product.add("部件X");
    }

    @Override
    public void buildPartB() {
        System.out.println("===ConcreteBuilderB buildPartA===");
        product.add("部件Y");
    }

    @Override
    public BuilderProduct getResult() {
        return product;
    }
}
