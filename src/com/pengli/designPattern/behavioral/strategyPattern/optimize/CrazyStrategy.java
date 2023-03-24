package com.pengli.designPattern.behavioral.strategyPattern.optimize;

public class CrazyStrategy implements ExerciseStrategy{
    @Override
    public void exercise() {
        System.out.println("疯狂健身，不疯活不成魔");
    }

    private CrazyStrategy(){

    }

    public static CrazyStrategy getInstance(){
        return CrazyStrategyHolder.INSTANCE;
    }

     private static class CrazyStrategyHolder{
         private final static CrazyStrategy INSTANCE = new CrazyStrategy();

     }

}
