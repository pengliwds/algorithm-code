package com.pengli.designPattern.observerPattern;

public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }


    @Override
    public void update() {
        System.out.println("BinaryObserver " + Integer.toBinaryString(subject.getState()));
    }


}
