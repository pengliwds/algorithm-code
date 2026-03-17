package com.pengli.designPattern.behavioral.visitorPattern;

/**
 * 狗类（具体元素）
 */
public class Dog implements Animal {
    private String name;
    private int age;
    private String breed;

    public Dog(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public String getBreed() {
        return breed;
    }

    public void bark() {
        System.out.println(name + " 正在汪汪叫！");
    }
}