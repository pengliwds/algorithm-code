package com.pengli.designPattern.behavioral.chainOfResponsibilityPattern;

public class SecondCheck extends CheckHandler {
    @Override
    Result check() {


        System.out.println("第二道关");

        // 不符合校验，直接返回Result

        if (null != next) {
            return next.check();
        }

        return new Result("第二道关校验成功");

    }
}
