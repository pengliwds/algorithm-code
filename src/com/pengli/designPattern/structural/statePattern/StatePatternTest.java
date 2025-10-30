package com.pengli.designPattern.structural.statePattern;

public class StatePatternTest {

    public static void main(String[] args) {
        OrderContext context = new OrderContext();
        context.setState(new NewOrderState());

        context.process();
        context.process();
        context.cancel();
        context.process();
    }
}
