package com.pengli.designPattern.structural.proxyPattern.staticProxy;

/**
 * 代理模式
 * 控制被代理对象，添加额外的功能
 *
 * @Author pengli
 * @Date 2023/3/22
 * @Version 1.0
 */
public class ProxyTest {

    public static void main(String[] args) {

        Proxy me = new Proxy("某人");
        me.giveFlowers();
        me.giveBags();
        me.giveMoney();

    }
}
