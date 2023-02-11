package com.pengli.designPattern.strategyPattern.optimize;

import java.util.HashMap;
import java.util.Map;

public class ExerciseContext {

    ExerciseStrategy exerciseStrategy;

    private static final Map<String, ExerciseStrategy> strategyMap = new HashMap<>();

    static {
        strategyMap.put("疯狂", CrazyStrategy.getInstance());
        strategyMap.put("适度", ModerateStrategy.getInstance());
    }

    public ExerciseContext(String type){
        exerciseStrategy = strategyMap.get(type);
    }



    public void exercise() {
        exerciseStrategy.exercise();
    }

}
