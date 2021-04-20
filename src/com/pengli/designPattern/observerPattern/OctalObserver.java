package com.pengli.designPattern.observerPattern;

public class OctalObserver extends Observer {


    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("OctalObserver " + Integer.toOctalString(subject.getState()));
    }
}
