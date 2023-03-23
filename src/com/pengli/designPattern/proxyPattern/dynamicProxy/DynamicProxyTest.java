package com.pengli.designPattern.proxyPattern.dynamicProxy;

public class DynamicProxyTest {

    public static void main(String[] args) {


        GiveGift giveGift = new Pursuit("某人");

        GiveGift proxy = ProxyFactory.getProxy(giveGift);

        proxy.giveFlowers();
        proxy.giveBags();
        proxy.giveMoney();

    }
}
