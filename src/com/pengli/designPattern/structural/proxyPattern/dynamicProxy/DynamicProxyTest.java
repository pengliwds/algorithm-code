package com.pengli.designPattern.structural.proxyPattern.dynamicProxy;


/**
 * 动态代理
 * 和静态代理区别，一个类ProxyFactory，可以根据接口，动态的获取对应类的代理类，不用一个个实现
 *
 * @Author pengli
 * @Date 2023/3/22
 * @Version 1.0
 */
public class DynamicProxyTest {

    public static void main(String[] args) {


        GiveGift giveGift = new Pursuit("某人");

        GiveGift proxy = ProxyFactory.getProxy(giveGift);

        proxy.giveFlowers();
        proxy.giveBags();
        proxy.giveMoney();

    }
}
