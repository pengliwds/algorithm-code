package com.pengli.designPattern.behavioral.commandPattern;

import java.util.ArrayList;
import java.util.List;


/**
 * 命令模式是一种行为型设计模式，它将请求封装成一个对象，从而允许用户使用不同的请求、队列或日志来参数化其他对象，同时支持可撤销的操作。
 * <p>
 * 核心思想：
 * 将请求封装为对象：将操作请求与执行操作的对象解耦
 * 支持撤销/重做：可以记录操作历史，实现撤销和重做功能
 * 支持队列和日志：可以将命令对象放入队列中，实现延迟执行或日志记录
 * 支持宏命令：可以将多个命令组合成一个复合命令
 * <p>
 * 解耦调用者与接收者：调用者不需要知道接收者的具体实现
 * 支持撤销/重做操作：可以轻松实现操作的撤销和重做功能
 * 支持命令队列：可以将命令放入队列中，实现延迟执行或批处理
 * 支持宏命令：可以将多个命令组合成一个复合命令
 * 易于扩展：可以轻松添加新的命令，而不影响现有代码
 * 支持日志记录：可以记录所有执行过的命令，用于审计或恢复
 */
public class CommandPatternTest {


    static void main() {
        System.out.println("=== 命令模式演示：智能家居控制系统 ===\n");

        // 创建接收者（家居设备）
        Light livingRoomLight = new Light("客厅");
        Light kitchenLight = new Light("厨房");
        Fan livingRoomFan = new Fan("客厅");
        TV livingRoomTV = new TV("客厅");

        // 创建命令对象
        Command livingRoomLightOn = new LightOnCommand(livingRoomLight);
        Command livingRoomLightOff = new LightOffCommand(livingRoomLight);
        Command kitchenLightOn = new LightOnCommand(kitchenLight);
        Command kitchenLightOff = new LightOffCommand(kitchenLight);
        Command fanHigh = new FanHighCommand(livingRoomFan);
        Command tvOn = new TVOnCommand(livingRoomTV);

        // 创建宏命令：回家模式（打开所有设备）
        List<Command> homeCommands = new ArrayList<>();
        homeCommands.add(livingRoomLightOn);
        homeCommands.add(kitchenLightOn);
        homeCommands.add(fanHigh);
        homeCommands.add(tvOn);
        Command homeMode = new MacroCommand(homeCommands);

        // 创建宏命令：离家模式（关闭所有设备）
        List<Command> awayCommands = new ArrayList<>();
        awayCommands.add(livingRoomLightOff);
        awayCommands.add(kitchenLightOff);
        Command awayMode = new MacroCommand(awayCommands);

        // 创建遥控器
        RemoteControl remote = new RemoteControl(7);

        // 配置遥控器按钮
        remote.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remote.setCommand(1, kitchenLightOn, kitchenLightOff);
        remote.setCommand(2, fanHigh, new NoCommand());
        remote.setCommand(3, tvOn, new NoCommand());
        remote.setCommand(4, homeMode, awayMode);

        // 显示遥控器配置
        remote.display();

        // 测试遥控器功能
        System.out.println("=== 测试基本功能 ===");
        remote.onButtonWasPushed(0);  // 打开客厅灯
        remote.offButtonWasPushed(0); // 关闭客厅灯
        remote.onButtonWasPushed(1);  // 打开厨房灯
        remote.onButtonWasPushed(2);  // 打开风扇（高速）
        remote.onButtonWasPushed(3);  // 打开电视

        System.out.println("\n=== 测试撤销功能 ===");
        remote.undoButtonWasPushed(); // 撤销打开电视
        remote.undoButtonWasPushed(); // 撤销打开风扇
        remote.undoButtonWasPushed(); // 撤销打开厨房灯

        System.out.println("\n=== 测试重做功能 ===");
        remote.redoButtonWasPushed(); // 重做打开厨房灯
        remote.redoButtonWasPushed(); // 重做打开风扇

        System.out.println("\n=== 测试宏命令 ===");
        System.out.println("执行回家模式：");
        remote.onButtonWasPushed(4);  // 执行回家模式

        System.out.println("\n执行离家模式：");
        remote.offButtonWasPushed(4); // 执行离家模式

        System.out.println("\n=== 测试撤销宏命令 ===");
        remote.undoButtonWasPushed(); // 撤销离家模式
    }


}
