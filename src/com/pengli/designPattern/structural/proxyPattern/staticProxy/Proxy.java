package com.pengli.designPattern.structural.proxyPattern.staticProxy;

public class Proxy implements GiveGift{

    Pursuit pursuit;

    public Proxy(String name) {
        this.pursuit = new Pursuit(name);
    }

    @Override
    public void giveMoney() {
        pursuit.giveMoney();
        System.out.println("代理类说我爱你");
    }

    @Override
    public void giveFlowers() {
        pursuit.giveFlowers();
        System.out.println("代理类说我爱你");
    }

    @Override
    public void giveBags() {
        pursuit.giveBags();
        System.out.println("代理类说我爱你");
    }
}
