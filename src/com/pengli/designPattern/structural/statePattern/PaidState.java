package com.pengli.designPattern.structural.statePattern;

public class PaidState implements OrderState{
    @Override
    public void handle(OrderContext context) {
        System.out.println("订单已支付，等待发货");
        context.setState(new ShippedState());
    }

    @Override
    public String getStateName() {
        return "已支付";
    }
}
