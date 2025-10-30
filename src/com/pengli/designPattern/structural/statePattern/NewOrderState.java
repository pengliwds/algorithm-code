package com.pengli.designPattern.structural.statePattern;

public class NewOrderState implements OrderState {
    @Override
    public void handle(OrderContext context) {
        System.out.println("新订单，等待支付");
        context.setState(new PaidState());
    }

    @Override
    public String getStateName() {
        return "新订单";
    }
}
