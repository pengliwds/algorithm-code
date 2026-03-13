package com.pengli.designPattern.behavioral.chainOfResponsibilityPattern;

/**
 * 责任链模式
 *
 */
public class PatternTest {

    public static void main(String[] args) {

        CheckHandler.Builder builder = new CheckHandler.Builder();

        builder.addHandler(new FirstCheck()).addHandler(new SecondCheck()).addHandler(new ThirdCheck());

        Result result = builder.build().check();

        System.out.println(result.getMessage());

    }

}
