package com.pengli.designPattern.behavioral.visitorPattern;

/**
 * 鸟类（具体元素）
 */
public class Bird implements Animal {
    private String name;
    private int age;
    private String featherColor;
    private boolean canFly;

    public Bird(String name, int age, String featherColor, boolean canFly) {
        this.name = name;
        this.age = age;
        this.featherColor = featherColor;
        this.canFly = canFly;
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

    public String getFeatherColor() {
        return featherColor;
    }

    public boolean canFly() {
        return canFly;
    }

    public void chirp() {
        System.out.println(name + " 正在叽叽喳喳叫！");
    }

    public void fly() {
        if (canFly) {
            System.out.println(name + " 飞向了天空！");
        } else {
            System.out.println(name + " 虽然是鸟，但不会飞！");
        }
    }
}