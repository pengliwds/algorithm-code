# 状态模式（State Pattern）

## 设计模式简介

状态模式是一种行为型设计模式，它允许对象在内部状态发生变化时改变自己的行为，看起来就像对象修改了自己的类一样。  
虽然当前目录位于 `structural` 包下，但就模式分类而言，状态模式通常被归为行为型模式。

当前示例中，订单对象 `OrderContext` 会在 `新订单`、`已支付`、`已发货`、`已完成`、`已取消` 等状态之间切换，不同状态下对同一操作的处理逻辑不同。

## 核心角色

### 1. 环境类（Context）
持有当前状态对象，并把请求委托给当前状态处理。示例中的 `OrderContext` 就是环境类。

### 2. 状态接口（State）
定义所有具体状态的统一行为。示例中的 `OrderState` 规定了 `handle()` 和 `getStateName()`。

### 3. 具体状态（Concrete State）
在特定状态下执行具体逻辑，并决定下一个状态。示例中的 `NewOrderState`、`PaidState`、`ShippedState`、`DeliveredState`、`CancelledState` 都属于具体状态。

## 实现方式

### 1. 定义状态接口
```java
public interface OrderState {
    void handle(OrderContext context);
    String getStateName();
}
```

### 2. 环境类持有当前状态
```java
public class OrderContext {
    private OrderState currentState;

    public void process() {
        currentState.handle(this);
    }
}
```

### 3. 具体状态决定状态迁移
```java
public class NewOrderState implements OrderState {
    @Override
    public void handle(OrderContext context) {
        System.out.println("新订单，等待支付");
        context.setState(new PaidState());
    }
}
```

## 实现特点

### 优点
1. **消除大量状态判断**：避免把复杂 `if-else` 都堆在上下文里。
2. **状态职责清晰**：每个状态只关注自己那部分逻辑。
3. **扩展方便**：新增状态时通常只需要增加新的状态类。
4. **状态迁移明确**：状态变化逻辑分散到各个状态实现中，更贴近业务语义。

### 缺点
1. **类数量增加**：每种状态通常都对应一个类。
2. **状态流转分散**：整体状态迁移关系需要结合多个类才能看全。
3. **简单场景可能不划算**：状态很少时，直接条件判断反而更直观。

### 适用场景
- 工作流、订单流转
- 游戏角色状态切换
- 审批流程状态变化
- 同一对象在不同状态下行为差异明显

## 运行示例

编译和运行：
```bash
javac -d . src/com/pengli/designPattern/structural/statePattern/*.java
java com.pengli.designPattern.structural.statePattern.StatePatternTest
```

### 示例流程
```text
1. 初始状态为新订单
2. 第一次 process() 后切换到已支付
3. 第二次 process() 后切换到已发货
4. 调用 cancel() 后切换到已取消
5. 再次 process() 时按已取消状态处理
```

## 关键代码说明

### `OrderContext`
- 保存当前状态对象
- `process()` 委托给当前状态执行
- `cancel()` 中根据当前状态决定是否允许取消

### `OrderState`
- 抽象状态接口
- 统一规定状态处理行为和状态名称

### `NewOrderState`
- 表示订单刚创建、等待支付
- 执行后迁移到 `PaidState`

### `PaidState`
- 表示订单已支付、等待发货
- 执行后迁移到 `ShippedState`

### `ShippedState`
- 表示订单已发货
- 执行后迁移到 `DeliveredState`

### `DeliveredState`
- 表示订单已完成
- 属于终态之一

### `CancelledState`
- 表示订单已取消
- 也是终态之一

## 设计模式对比

| 模式 | 关注点 | 是否强调状态迁移 | 典型场景 |
|------|------|----------------|---------|
| 状态模式 | 状态驱动行为变化 | 是 | 订单流转、工作流 |
| 策略模式 | 不同算法可切换 | 否 | 规则选择 |
| 命令模式 | 请求对象化 | 否 | 撤销、任务封装 |

## 示例总结

这个示例把订单流程拆成多个独立状态类：
- 每个状态负责自己的行为
- 状态对象内部决定如何迁移到下一个状态
- `OrderContext` 只负责持有当前状态并委托执行

这种写法在业务流程复杂、状态转换频繁的系统里很有价值。
