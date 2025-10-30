package com.pengli.designPattern.structural.statePattern;

public class DeliveredState implements OrderState{
    @Override
    public void handle(OrderContext context) {
        System.out.println("订单已完成");
        // 最终状态，后续状态没有操作了
    }

    @Override
    public String getStateName() {
        return "已完成";
    }
}
