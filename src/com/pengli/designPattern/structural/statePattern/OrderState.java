package com.pengli.designPattern.structural.statePattern;

public interface OrderState {

    void handle(OrderContext context);
    String getStateName();
}
