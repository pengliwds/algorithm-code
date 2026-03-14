# 观察者模式（Observer Pattern）

## 设计模式简介

观察者模式是一种行为型设计模式，它定义了对象之间的一对多依赖关系。  
当主题对象状态发生变化时，所有依赖它的观察者都会自动收到通知并更新。

当前示例中，`Subject` 是被观察者，`BinaryObserver` 和 `OctalObserver` 是观察者。当 `state` 改变时，两个观察者会自动输出对应进制的值。

## 核心角色

### 1. 主题（Subject）
负责维护观察者列表，并在状态变化时通知所有观察者。示例中的 `Subject` 提供了 `attach()` 和 `notifyAllObservers()`。

### 2. 观察者（Observer）
定义更新接口。示例中的 `Observer` 抽象类规定了 `update()`。

### 3. 具体观察者（Concrete Observer）
在收到通知后执行具体更新行为。示例中的 `BinaryObserver` 和 `OctalObserver` 分别负责二进制和八进制展示。

### 4. 客户端（Client）
负责创建主题与观察者，并驱动状态变化。示例中的 `ObserverPatternTest` 负责完成这些动作。

## 实现方式

### 1. 主题维护观察者列表
```java
private List<Observer> observers = new ArrayList<>();

public void attach(Observer observer) {
    observers.add(observer);
}
```

### 2. 状态变化时自动通知
```java
public void setState(Integer state) {
    this.state = state;
    notifyAllObservers();
}
```

### 3. 观察者在构造时注册自己
```java
public BinaryObserver(Subject subject) {
    this.subject = subject;
    this.subject.attach(this);
}
```

## 实现特点

### 优点
1. **松耦合**：主题不需要知道观察者的具体实现。
2. **支持广播通知**：一个状态变化可以自动通知多个订阅者。
3. **扩展方便**：新增观察者通常不需要修改主题逻辑。
4. **符合事件驱动思想**：非常适合发布订阅、监听通知场景。

### 缺点
1. **通知链难追踪**：观察者多时，不容易快速看出谁会被触发。
2. **可能产生连锁更新**：设计不当时，多个观察者更新可能引发复杂副作用。
3. **顺序和性能问题**：观察者多时，通知成本会提升。

### 适用场景
- 发布订阅系统
- GUI 事件监听
- 消息通知、状态广播
- 多个视图联动更新

## 运行示例

编译和运行：
```bash
javac -d . src/com/pengli/designPattern/behavioral/observerPattern/*.java
java com.pengli.designPattern.behavioral.observerPattern.ObserverPatternTest
```

### 输出示例
```text
BinaryObserver 1010
OctalObserver 12
BinaryObserver 1111
OctalObserver 17
```

## 关键代码说明

### `Subject`
- 保存所有观察者
- 每次 `setState()` 时调用 `notifyAllObservers()`

### `Observer`
- 定义统一更新接口
- 具体观察者通过持有 `Subject` 来读取最新状态

### `BinaryObserver`
- 把主题状态转换成二进制输出

### `OctalObserver`
- 把主题状态转换成八进制输出

### `ObserverPatternTest`
- 创建主题后注册两个观察者
- 连续修改状态，触发观察者自动更新

## 设计模式对比

| 模式 | 通信关系 | 关注点 | 典型场景 |
|------|---------|------|---------|
| 观察者模式 | 一对多通知 | 状态变化广播 | 订阅通知、事件监听 |
| 中介者模式 | 多对一协调 | 统一调度对象交互 | 复杂对象通信 |
| 责任链模式 | 顺序传递请求 | 多节点接力处理 | 校验、审批 |

## 示例总结

这个示例非常典型地体现了观察者模式：
- `Subject` 负责发布状态变化
- `BinaryObserver` 和 `OctalObserver` 负责订阅并响应变化
- 客户端只需修改 `Subject` 的状态，就能触发多个观察者自动更新

这正是观察者模式在事件驱动系统中的核心价值。
