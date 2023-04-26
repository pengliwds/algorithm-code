package com.pengli.designPattern.creational.builderPattern;

/**
 * @Author pengli
 * @Date 25/4/2023
 * @Version 1.0
 */
public class Director {

    public BuilderProduct build(Builder builder){
        builder.buildPartA();
        builder.buildPartB();
        return builder.getResult();
    }
}
