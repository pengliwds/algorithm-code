package com.pengli.designPattern.structural.statePattern;

public class CancelledState implements OrderState{
    @Override
    public void handle(OrderContext context) {
        System.out.println("Order is cancelled");
        // 最终状态
    }

    @Override
    public String getStateName() {
        return "已取消";
    }
}
