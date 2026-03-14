# 策略模式（Strategy Pattern）

## 设计模式简介

策略模式是一种行为型设计模式，它定义一组可互换的算法或行为，并将它们分别封装起来，使它们可以在运行时自由替换。  
这样客户端不必把大量 `if-else` 或 `switch` 写死在业务逻辑里，而是把变化点抽成独立策略。

当前目录中给出了两组示例：
- `common`：基础版策略模式，以“吃饭方式”为例
- `optimize`：结合 `Map + 单例` 的优化版，以“健身方式”为例

## 核心角色

### 1. 策略接口（Strategy）
定义统一算法接口。示例中的 `EatStrategy` 和 `ExerciseStrategy` 分别就是策略抽象。

### 2. 具体策略（Concrete Strategy）
实现具体行为。示例中的 `QuickEatStrategy`、`SlowEatStrategy`、`CrazyStrategy`、`ModerateStrategy` 都属于具体策略。

### 3. 上下文（Context）
持有策略对象，并在合适时机调用策略。示例中的 `Context` 和 `ExerciseContext` 就是上下文。

### 4. 客户端（Client）
负责选择策略并传入上下文。示例中的 `StrategyTest` 和 `OptimizeStrategyTest` 负责这个工作。

## 实现方式

### 1. 定义策略接口
```java
public interface EatStrategy {
    void eat();
}
```

### 2. 定义多个具体策略
```java
public class QuickEatStrategy implements EatStrategy {
    @Override
    public void eat() {
        System.out.println("每天吃饭时间控制在20分钟");
    }
}
```

### 3. 上下文组合策略对象
```java
public class Context {
    EatStrategy eatStrategy;

    public Context(EatStrategy eatStrategy) {
        this.eatStrategy = eatStrategy;
    }

    public void contextInterface() {
        this.eatStrategy.eat();
    }
}
```

### 4. 优化版通过 `Map` 统一管理策略
```java
private static final Map<String, ExerciseStrategy> strategyMap = new HashMap<>();

static {
    strategyMap.put("疯狂", CrazyStrategy.getInstance());
    strategyMap.put("适度", ModerateStrategy.getInstance());
}
```

## 实现特点

### 优点
1. **消除条件分支**：把变化逻辑拆到不同策略类中。
2. **符合开闭原则**：新增策略通常只需增加新的策略实现。
3. **运行时可切换**：不同策略可以动态替换。
4. **复用性高**：策略可以被多个上下文或业务场景复用。

### 缺点
1. **类数量增加**：每种算法或行为都可能需要一个类。
2. **客户端需要理解策略差异**：调用方通常要知道该选哪种策略。
3. **简单场景可能过度设计**：如果只有两三种极简单分支，收益可能不大。

### 适用场景
- 同一业务有多种处理算法
- 运行时需要切换不同规则
- 代码中存在大量条件分支
- 希望把变化点抽离成独立模块

## 运行示例

基础版编译和运行：
```bash
javac -d . src/com/pengli/designPattern/behavioral/strategyPattern/common/*.java
java com.pengli.designPattern.behavioral.strategyPattern.common.StrategyTest
```

优化版编译和运行：
```bash
javac -d . src/com/pengli/designPattern/behavioral/strategyPattern/optimize/*.java
java com.pengli.designPattern.behavioral.strategyPattern.optimize.OptimizeStrategyTest
```

### 输出示例
```text
每天吃饭时间控制在20分钟
疯狂健身，不疯活不成魔
```

## 关键代码说明

### `common/Context`
- 通过组合方式持有 `EatStrategy`
- 调用 `contextInterface()` 时委托给具体策略执行

### `common/QuickEatStrategy` / `SlowEatStrategy`
- 两种不同的“吃饭行为”策略实现
- 用于体现策略模式最基础的结构

### `optimize/ExerciseContext`
- 不再由客户端直接传策略对象
- 而是通过 `type` 从 `strategyMap` 中选择策略

### `optimize/CrazyStrategy` / `ModerateStrategy`
- 使用单例方式提供策略实例
- 避免频繁创建同类策略对象

## 设计模式对比

| 模式 | 主要目的 | 是否可运行时切换 | 典型替代对象 |
|------|---------|----------------|-------------|
| 策略模式 | 替换算法或规则 | 是 | `if-else` / `switch` |
| 模板方法模式 | 固定流程，变化局部步骤 | 一般由继承决定 | 重复流程代码 |
| 状态模式 | 状态变化驱动行为变化 | 是，但强调状态流转 | 状态判断分支 |

## 示例总结

这个目录里的两个示例正好展示了策略模式从基础到实用的两种写法：
- `common` 展示最标准的“接口 + 实现 + 上下文”
- `optimize` 展示了更贴近业务开发的“策略注册表 + 单例策略”

它们共同说明了一件事：把变化行为抽出来独立封装，代码会更容易扩展和维护。
