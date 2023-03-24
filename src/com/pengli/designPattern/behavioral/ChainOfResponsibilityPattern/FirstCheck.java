package com.pengli.designPattern.behavioral.ChainOfResponsibilityPattern;

public class FirstCheck extends CheckHandler {


    @Override
    Result check() {

        System.out.println("第一道关");

        // 不符合校验，直接返回Result

        if (null != next) {
            return next.check();
        }

        return new Result("第一道关校验成功");
    }
}
