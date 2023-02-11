package com.pengli.designPattern.observerPattern;

public class ObserverPatternTest {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new BinaryObserver(subject);
        new OctalObserver(subject);

        subject.setState(10);

        subject.setState(15);
    }
}
