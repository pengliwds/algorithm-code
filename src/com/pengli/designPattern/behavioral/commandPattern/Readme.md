# 命令模式（Command Pattern）

## 设计模式简介

命令模式是一种行为型设计模式，它将请求封装为一个对象，从而将“请求发起者”和“请求执行者”解耦。  
这样不仅可以支持延迟执行、日志记录、命令队列，还很适合实现撤销、重做以及宏命令等功能。

当前示例中，遥控器 `RemoteControl` 作为调用者，灯、风扇、电视作为接收者，`LightOnCommand`、`FanHighCommand`、`TVOnCommand` 等命令对象封装了具体操作。

## 核心角色

### 1. 命令接口（Command）
定义统一命令行为。示例中的 `Command` 规定了 `execute()` 和 `undo()`。

### 2. 具体命令（Concrete Command）
封装具体请求和接收者对象，例如 `LightOnCommand`、`LightOffCommand`、`FanHighCommand`、`TVOnCommand`。

### 3. 调用者（Invoker）
负责触发命令执行，但不关心命令内部细节。示例中的 `RemoteControl` 就是调用者。

### 4. 接收者（Receiver）
真正执行操作的对象。示例中的 `Light`、`Fan`、`TV` 都属于接收者。

### 5. 客户端（Client）
负责组装命令对象并把命令绑定给调用者。示例中的 `CommandPatternTest` 扮演这一角色。

## 实现方式

### 1. 定义命令接口
```java
public interface Command {
    void execute();
    void undo();
}
```

### 2. 具体命令持有接收者
```java
public class LightOnCommand implements Command {
    private Light light;

    @Override
    public void execute() {
        light.turnOn();
    }
}
```

### 3. 调用者统一触发命令
```java
public void onButtonWasPushed(int slot) {
    onCommands[slot].execute();
    undoStack.push(onCommands[slot]);
}
```

### 4. 支持宏命令
```java
public class MacroCommand implements Command {
    private List<Command> commands;

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }
}
```

## 实现特点

### 优点
1. **调用者与接收者解耦**：遥控器不需要知道设备如何执行操作。
2. **便于扩展新命令**：新增功能时通常只需增加新的命令类。
3. **支持撤销与重做**：当前示例用 `undoStack` 和 `redoStack` 实现了命令回退。
4. **支持宏命令**：可以把多个命令组合成一个复合命令。
5. **适合日志与队列场景**：命令对象天然便于记录和传输。

### 缺点
1. **类数量增加**：每种操作都可能需要单独的命令类。
2. **结构更复杂**：对于特别简单的操作，模式本身会显得偏重。
3. **命令过多时维护成本上升**：需要管理较多命令对象和绑定关系。

### 适用场景
- 遥控器、菜单、按钮等操作封装
- 撤销与重做功能
- 宏操作、批处理命令
- 操作日志、任务队列、延迟执行

## 运行示例

当前 [CommandPatternTest.java](G:\code\algorithm-code\src\com\pengli\designPattern\behavioral\commandPattern\CommandPatternTest.java) 中的入口方法是 `static void main()`，不是标准的 `public static void main(String[] args)`，因此更适合在 IDE 中直接调用该方法进行演示。

编译命令：
```bash
javac -d . src/com/pengli/designPattern/behavioral/commandPattern/*.java
```

### 示例流程
```text
1. 创建灯、风扇、电视等接收者
2. 创建开灯、关灯、开风扇、开电视等命令对象
3. 将命令绑定到 RemoteControl 各个插槽
4. 测试开关控制
5. 测试 undo / redo
6. 测试 homeMode / awayMode 宏命令
```

## 关键代码说明

### `Command`
- 抽象命令接口
- 统一所有命令的执行和撤销行为

### `LightOnCommand` / `LightOffCommand`
- 记录灯之前的状态
- 在 `undo()` 中恢复到执行前状态

### `FanHighCommand`
- 记录风扇原来的档位
- 撤销时根据原档位恢复状态

### `TVOnCommand`
- 除开机外，还会设置默认音量和频道
- 撤销时恢复电视之前的开关状态、音量和频道

### `RemoteControl`
- 维护 `onCommands` 与 `offCommands`
- 使用 `undoStack` 与 `redoStack` 实现撤销和重做
- 是整个命令模式示例中的核心调用者

### `MacroCommand`
- 将多个命令组合成一个命令
- 示例中的“回家模式”和“离家模式”就是典型宏命令

## 设计模式对比

| 模式 | 关注点 | 是否封装请求 | 是否支持撤销 |
|------|------|-------------|-------------|
| 命令模式 | 将操作请求对象化 | 是 | 非常适合 |
| 责任链模式 | 请求沿多个处理者传递 | 否 | 一般不强调 |
| 中介者模式 | 协调多个对象交互 | 否 | 不强调 |

## 示例总结

这个示例很好地体现了命令模式的几个关键价值：
- 遥控器不直接操控设备，而是操控命令对象
- 命令对象内部封装了设备操作细节
- 基于命令对象，很自然地扩展了撤销、重做和宏命令能力

这也是命令模式在实际项目中最常见、最实用的用法。
