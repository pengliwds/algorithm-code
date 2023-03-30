package com.pengli.designPattern.behavioral.observerPattern;

/**
 * 观察者模式
 *
 */
public class ObserverPatternTest {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new BinaryObserver(subject);
        new OctalObserver(subject);

        subject.setState(10);

        subject.setState(15);
    }
}
