package com.pengli.designPattern.strategyPattern.common;

public class StrategyTest {

    public static void main(String[] args) {

//        String param = "慢吃";
        String param = "快吃";

        Context context = generateContext(param);
        context.contextInterface();
    }

    public static Context generateContext(String type) {
        Context context;
        switch (type) {
            case "慢吃":
                context = new Context(new SlowEatStrategy());
                break;
            case "快吃":
            default:
                context = new Context(new QuickEatStrategy());
                break;
        }
        return context;
    }

}
