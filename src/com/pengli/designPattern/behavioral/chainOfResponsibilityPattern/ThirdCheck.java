package com.pengli.designPattern.behavioral.chainOfResponsibilityPattern;

public class ThirdCheck extends CheckHandler{


    @Override
    Result check() {
        System.out.println("第三道关");
        System.out.println("第三道关校验成功");
        // 不符合校验，直接返回Result

        if (null != next) {
            return next.check();
        }
        return new Result("第三道关校验成功");

    }
}
