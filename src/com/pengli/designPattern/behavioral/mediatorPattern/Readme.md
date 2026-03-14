# 中介者模式（Mediator Pattern）

## 设计模式简介

中介者模式是一种行为型设计模式，它通过引入一个中介者对象来封装多个对象之间的交互，从而避免对象之间直接相互引用。  
这样可以把原本复杂的网状关系，转化为以中介者为中心的星状关系，显著降低对象之间的耦合。

当前示例中，机场塔台 `ControlTower` 作为中介者，飞机 `Plane` 作为同事对象。飞机之间不直接通信，而是统一通过塔台完成起飞、降落、调度和紧急广播。

## 核心角色

### 1. 抽象中介者（Mediator）
定义同事对象之间交互的统一接口。示例中的 `AirportMediator` 声明了注册飞机、发送调度、起降许可和紧急广播等能力。

### 2. 具体中介者（Concrete Mediator）
实现对象协调逻辑。示例中的 `ControlTower` 负责管理已注册飞机和天气状态，并统一进行调度。

### 3. 同事对象（Colleague）
需要与其他对象交互，但不直接互相调用，而是通过中介者通信。示例中的 `Plane` 就是同事对象。

### 4. 客户端（Client）
负责创建中介者和同事对象，并触发业务场景。示例中的 `MediatorPatternTest` 演示了完整运行流程。

## 实现方式

### 1. 定义中介者接口
```java
public interface AirportMediator {
    void registerPlane(Plane plane);
    void sendDispatch(String message, Plane sender);
    void sendTakeoffPermission(String flightNumber);
    void sendLandingPermission(String flightNumber);
    void broadcastEmergency(String message);
    String getWeatherStatus();
}
```

### 2. 具体中介者集中处理协调逻辑
```java
public class ControlTower implements AirportMediator {
    private List<Plane> planes;
    private String weatherStatus;
}
```

### 3. 同事对象通过中介者发起交互
```java
public void requestTakeoff() {
    if (mediator.getWeatherStatus().equals("雷雨")) {
        return;
    }
    mediator.sendTakeoffPermission(flightNumber);
}
```

## 实现特点

### 优点
1. **降低对象间耦合**：飞机不需要直接感知其他飞机。
2. **集中管理交互逻辑**：所有调度规则都放在塔台中统一处理。
3. **结构更清晰**：避免多对象之间形成复杂网状依赖。
4. **便于扩展同事对象**：新增飞机时只需要注册到塔台即可。

### 缺点
1. **中介者可能变复杂**：系统越大，中介者越容易膨胀成“上帝类”。
2. **交互逻辑集中带来维护压力**：所有协作规则都堆到中介者中时，需要额外注意拆分职责。
3. **调试时需关注中介者流程**：问题通常集中发生在中介者协调逻辑中。

### 适用场景
- 多个对象之间交互关系复杂
- 希望减少对象之间的直接引用
- 需要统一管理通信、调度或协作规则
- GUI 控件联动、聊天系统、调度系统等场景

## 运行示例

编译和运行：
```bash
javac -d . src/com/pengli/designPattern/behavioral/mediatorPattern/*.java
java com.pengli.designPattern.behavioral.mediatorPattern.MediatorPatternTest
```

### 示例流程
```text
1. 创建 ControlTower 作为机场塔台
2. 创建多架 Plane 并自动注册到塔台
3. 演示正常起飞调度
4. 演示飞行中发送调度请求
5. 演示降落调度
6. 演示天气变化对起飞的影响
7. 演示紧急广播通知所有飞机
8. 输出所有飞机的最终状态
```

## 关键代码说明

### `AirportMediator`
- 规定统一调度接口
- 屏蔽同事对象之间的直接交互

### `ControlTower`
- 保存所有已注册飞机
- 根据航班号找到目标飞机并下发指令
- 维护天气状态，控制能否起飞
- 支持紧急广播，通知所有飞机

### `Plane`
- 不直接操作其他飞机
- 起飞、降落、调度请求全部交给塔台
- 收到塔台许可后更新自身状态并模拟飞行过程

### `MediatorPatternTest`
- 用多个场景串联起整个中介者协作过程
- 包含正常起飞、空中调度、天气限制、紧急广播等典型交互

## 设计模式对比

| 模式 | 关注点 | 通信关系 | 典型场景 |
|------|------|---------|---------|
| 中介者模式 | 协调多个对象交互 | 多对一 | 调度系统、聊天系统 |
| 观察者模式 | 一对多通知 | 一对多 | 订阅发布、监听机制 |
| 责任链模式 | 请求沿链传递 | 顺序链式 | 校验、审批、拦截 |

## 示例总结

这个示例很好地说明了中介者模式的价值：
- 飞机之间不直接通信
- 所有调度逻辑集中在塔台中管理
- 通过中介者把复杂交互关系统一收口

当系统中“对象很多、关系很乱”时，中介者模式通常能显著提升结构清晰度。
