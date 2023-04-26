package com.pengli.designPattern.creational.builderPattern;

/**
 * @Author pengli
 * @Date 23/4/2023
 * @Version 1.0
 */
public interface Builder {
    /**
     * 建造者模式所固话的流程A
     */
    void buildPartA();
    /**
     * 建造者模式所固话的流程B
     */
    void buildPartB();

    BuilderProduct getResult();

}
