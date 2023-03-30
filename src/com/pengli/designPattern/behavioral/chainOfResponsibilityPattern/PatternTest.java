package com.pengli.designPattern.behavioral.chainOfResponsibilityPattern;

/**
 * 责任链模式
 *
 */
public class PatternTest {

    public static void main(String[] args) {

        CheckHandler.Builder builder = new CheckHandler.Builder();

        FirstCheck firstCheck = new FirstCheck();
        SecondCheck secondCheck = new SecondCheck();

        builder.addHandler(firstCheck).addHandler(secondCheck);

        Result result = builder.build().check();

        System.out.println(result.getMessage());

    }

}
