package com.pengli.designPattern.structural.proxyPattern.dynamicProxy;

public class Pursuit implements GiveGift {

    private String name;

    public Pursuit(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {
        System.out.println("追求者送了" + name + "一万块");
    }

    @Override
    public void giveFlowers() {
        System.out.println("追求者送了" + name + "99朵花");
    }

    @Override
    public void giveBags() {
        System.out.println("追求者送了" + name + "爱马仕包");
    }
}
