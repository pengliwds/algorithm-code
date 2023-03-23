package com.pengli.designPattern.decoratorPattern;

/**
 * @Author pengli
 * @Date 2023/3/22
 * @Version 1.0
 */
public abstract class PersonDecorator implements Person {

    public Person person;

    public void setDecorator(Person person) {
        this.person = person;
    }

    @Override
    public void doSomething() {
        person.doSomething();
    }
}
