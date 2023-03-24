package com.pengli.designPattern.structural.proxyPattern.staticProxy;

public class ProxyTest {

    public static void main(String[] args) {

        Proxy me = new Proxy("某人");
        me.giveFlowers();
        me.giveBags();
        me.giveMoney();

    }
}
