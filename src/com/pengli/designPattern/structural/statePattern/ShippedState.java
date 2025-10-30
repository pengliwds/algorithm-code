package com.pengli.designPattern.structural.statePattern;

public class ShippedState implements OrderState {
    @Override
    public void handle(OrderContext context) {
        System.out.println("订单已发货，不能取消订单");
        context.setState(new DeliveredState());
    }

    @Override
    public String getStateName() {
        return "已发货";
    }
}
