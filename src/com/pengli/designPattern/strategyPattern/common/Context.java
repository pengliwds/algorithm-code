package com.pengli.designPattern.strategyPattern.common;

public class Context {

    EatStrategy eatStrategy;


    public Context(EatStrategy eatStrategy){
        this.eatStrategy = eatStrategy;

    }

    public void contextInterface(){
        this.eatStrategy.eat();
    }

}
