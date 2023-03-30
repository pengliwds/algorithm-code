package com.pengli.designPattern.behavioral.templatePattern;

/**
 * 模板方法
 * 模板方法模式就是提供了一个很好的代码复用平台。
 * 因为有时候，我们会遇到由一系列步骤构成的过程需要执行。这个过程从高层次上看是相同的，但有些步骤的实现可能不同。
 *
 * @Author pengli
 * @Date 29/3/2023
 * @Version 1.0
 */
public class TemplatePatternTest {

    public static void main(String[] args) {

        AbstractSuperClass a = new StudentA();
        a.doComplexThings();
        System.out.println("=====================这是一条华丽的分割线======================");
        AbstractSuperClass b = new StudentB();
        b.doComplexThings();

    }
}
