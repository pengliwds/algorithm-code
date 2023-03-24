package com.pengli.designPattern.behavioral.strategyPattern.optimize;

public class ModerateStrategy implements ExerciseStrategy{
    @Override
    public void exercise() {
        System.out.println("适度健身，每天30分钟");
    }

    private ModerateStrategy(){
    }

    public static ModerateStrategy getInstance(){
        return ModerateStrategyHolder.INSTANCE;
    }

    private static class ModerateStrategyHolder{
        private static final ModerateStrategy INSTANCE = new ModerateStrategy();
    }
}
