package com.pengli.designPattern.structural.facadePattern;

/**
 * @Author pengli
 * @Date 23/4/2023
 * @Version 1.0
 */
public class Facade {

    private ActionA a;

    private ActionB b;

    private ActionC c;

    public Facade() {
        this.a = new ActionA();
        this.b = new ActionB();
        this.c = new ActionC();
    }


    public void integration(){
        a.doSomething();
        b.doSomething();
        c.doSomething();
    }

}
