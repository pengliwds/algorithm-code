package com.pengli.designPattern.creational.builderPattern;

/**
 * 建造者模式
 * 建造者模式是在<b>当创建复杂对象的算法</b>应该独立于该对象的组成部分以及它们的装配方式时适用的模式
 * 简单说就是流程比较多，需要经过很多固定的步骤，那么就可以把这些步骤抽象出来，使用指挥者固定步骤和顺序来构建对象
 *
 * @Author pengli
 * @Date 25/4/2023
 * @Version 1.0
 */
public class BuilderTest {
    public static void main(String[] args) {
        Director director = new Director();
        Builder builderA = new ConcreteBuilderA();
        Builder builderB = new ConcreteBuilderB();

        BuilderProduct productA = director.build(builderA);
        productA.showProduct();

        BuilderProduct productB = director.build(builderB);
        productB.showProduct();


    }

}
