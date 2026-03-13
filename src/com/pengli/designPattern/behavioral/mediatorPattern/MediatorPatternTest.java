package com.pengli.designPattern.behavioral.mediatorPattern;

import java.util.concurrent.TimeUnit;

/**
 * 中介者模式是一种行为设计模式，它通过引入一个中介者对象来封装一组对象之间的交互，从而减少对象之间的直接耦合。这些对象不再直接相互引用，而是通过中介者进行通信。
 *
 * 解耦对象：将多个对象之间的复杂网状关系转变为星型结构
 * 集中控制：将对象间的交互逻辑集中到中介者中
 * 简化通信：对象只需要知道中介者，而不需要知道其他对象
 *
 * 对象之间存在复杂的网状引用关系
 * 多个类相互耦合，形成复杂的结构
 * 一个对象引用很多其他对象，导致难以复用
 * 需要通过一个中间类来封装多个类之间的交互
 */
public class MediatorPatternTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("========== 中介者模式：飞机与塔台调度系统 ==========\n");

        // 创建塔台（中介者）
        ControlTower controlTower = new ControlTower();

        // 创建飞机（同事对象）
        Plane plane1 = new Plane("CA1234", controlTower);
        Plane plane2 = new Plane("MU5678", controlTower);
        Plane plane3 = new Plane("CZ9012", controlTower);

        System.out.println("\n=== 场景1：正常起飞调度 ===");
        plane1.requestTakeoff();

        System.out.println("\n=== 场景2：空中调度通信 ===");
        plane2.sendDispatchMessage("请求修改航线到北京");

        System.out.println("\n=== 场景3：降落调度 ===");
        plane3.setStatus("空中");
        plane3.setAltitude(8000);
        plane3.requestLanding();

        // 等待飞机操作完成
        TimeUnit.SECONDS.sleep(8);

        System.out.println("\n=== 场景4：天气影响 ===");
        controlTower.updateWeatherStatus("雷雨");
        Plane plane4 = new Plane("HU3456", controlTower);
        plane4.requestTakeoff(); // 由于天气，起飞被拒绝

        System.out.println("\n=== 场景5：紧急广播 ===");
        controlTower.broadcastEmergency("机场出现鸟群，所有飞机请注意避让！");

        TimeUnit.SECONDS.sleep(3);

        System.out.println("\n=== 场景6：天气好转 ===");
        controlTower.updateWeatherStatus("晴朗");
        Plane plane5 = new Plane("SC7890", controlTower);
        plane5.requestTakeoff();

        // 等待所有飞机操作完成
        TimeUnit.SECONDS.sleep(12);

        System.out.println("\n=== 最终状态统计 ===");
        System.out.println("当前注册飞机数量：" + controlTower.getPlanes().size());
        for (Plane plane : controlTower.getPlanes()) {
            System.out.println(plane);
        }

        System.out.println("\n========== 中介者模式演示完成 ==========");
    }
}
