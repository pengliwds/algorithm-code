# 中介者模式：飞机与塔台调度系统

## 设计模式简介

中介者模式（Mediator Pattern）是一种行为设计模式，它通过引入一个中介者对象来封装一组对象之间的交互，从而减少对象之间的直接耦合。这些对象不再直接相互引用，而是通过中介者进行通信。

## 核心角色

### 1. 中介者接口（AirportMediator）
定义了中介者对象的接口，包含所有同事对象之间的交互方法。

### 2. 具体中介者（ControlTower - 塔台）
实现中介者接口，协调各个飞机对象之间的通信和调度。

### 3. 同事类（Plane - 飞机）
定义同事类，知道中介者但不知道其他同事对象。

## 实现特点

### ✅ 优点
1. **降低耦合度**：飞机之间不再直接通信，都通过塔台中介
2. **集中控制**：所有的调度逻辑都在塔台中实现
3. **易于扩展**：新增飞机只需要注册到塔台即可
4. **符合单一职责原则**：每个类只负责自己的职责

### 🎯 应用场景
- 空中交通控制系统
- 聊天室系统
- GUI事件处理
- 工作流系统

## 运行示例

编译和运行：
```bash
javac -d . src/com/pengli/designPattern/behavioral/mediatorPattern/*.java
java com.pengli.designPattern.behavioral.mediatorPattern.MediatorPatternTest
```

### 输出示例程序会演示：

1. **飞机注册**：所有飞机注册到塔台系统
2. **起飞调度**：飞机请求起飞，塔台控制起飞许可
3. **通信调度**：飞机发送调度信息，塔台处理响应
4. **降落调度**：飞机请求降落，模拟降落过程
5. **天气影响**：雷雨天气影响起飞
6. **紧急广播**：塔台广播紧急信息
7. **状态统计**：查看所有飞机的最终状态

## 关键代码说明

### 塔台（ControlTower）
```java
public class ControlTower implements AirportMediator {
    private List<Plane> planes;

    // 注册飞机
    public void registerPlane(Plane plane) {
        planes.add(plane);
    }

    // 处理起飞许可
    public void sendTakeoffPermission(String flightNumber) {
        // 找到对应飞机并通知
    }
}
```

### 飞机（Plane）
```java
public class Plane {
    private AirportMediator mediator;

    // 请求起飞
    public void requestTakeoff() {
        // 通过中介者发送请求，不直接调用其他飞机
        mediator.sendTakeoffPermission(this.flightNumber);
    }
}
```

## 设计模式对比

| 特性 | 中介者模式 | 观察者模式 |
|------|-----------|-----------|
| 目的 | 减少对象间耦合 | 对象间一对多依赖 |
| 通信 | 通过中介者直接通信 | 通过事件间接通信 |
| 耦合度 | 对象间松耦合 | 观察者需要知道被观察者 |
| 适用场景 | 网状通信变星型结构 | 事件驱动系统 |