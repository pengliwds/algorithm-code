package com.pengli.designPattern.structural.statePattern;

/**
 * 上下文类
 */
public class OrderContext {


    private OrderState currentState;

    public OrderContext() {
        this.currentState = new NewOrderState(); // 初始状态
    }

    public void setState(OrderState state) {
        this.currentState = state;
        System.out.println("订单状态变更为: " + state.getStateName());
    }

    public void process() {
        currentState.handle(this);
    }

    public void cancel() {
        if (!(currentState instanceof DeliveredState)) {
            setState(new CancelledState());
        } else {
            System.out.println("已完成的订单不能取消");
        }
    }

    public String getCurrentState() {
        return currentState.getStateName();
    }
}
