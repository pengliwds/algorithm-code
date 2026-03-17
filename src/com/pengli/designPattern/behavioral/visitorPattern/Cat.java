package com.pengli.designPattern.behavioral.visitorPattern;

/**
 * 猫类（具体元素）
 */
public class Cat implements Animal {
    private String name;
    private int age;
    private String color;

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public void meow() {
        System.out.println(name + " 正在喵喵叫！");
    }
}