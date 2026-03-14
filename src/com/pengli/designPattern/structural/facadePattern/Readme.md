# 外观模式（Facade Pattern）

## 设计模式简介

外观模式是一种结构型设计模式，它为复杂子系统提供一个统一的高层入口，从而简化客户端对多个子系统的调用。  
客户端不再需要了解每个子系统的内部细节，只需要调用外观对象提供的统一接口即可。

当前示例中，`ActionA`、`ActionB`、`ActionC` 表示多个子系统能力，`Facade` 把它们整合起来，对外提供一个 `integration()` 方法。

## 核心角色

### 1. 外观类（Facade）
负责封装多个子系统的复杂调用流程。示例中的 `Facade` 就是外观类。

### 2. 子系统（Subsystem）
实现具体业务功能。示例中的 `ActionA`、`ActionB`、`ActionC` 都是子系统角色。

### 3. 客户端（Client）
通过外观类访问子系统，而不是直接逐个调用。示例中的 `FacadeTest` 使用 `Facade.integration()` 完成整合调用。

## 实现方式

### 1. 定义多个子系统类
```java
public class ActionA {
    public void doSomething() {
        System.out.println("ActionA doSomething");
    }
}
```

### 2. 外观类统一组合子系统
```java
public class Facade {
    private ActionA a;
    private ActionB b;
    private ActionC c;
}
```

### 3. 外观类提供统一入口
```java
public void integration() {
    a.doSomething();
    b.doSomething();
    c.doSomething();
}
```

## 实现特点

### 优点
1. **简化调用**：客户端只面对一个统一入口。
2. **降低耦合**：客户端不需要了解多个子系统之间的调用关系。
3. **隐藏复杂性**：复杂流程被封装进外观类内部。
4. **便于维护**：子系统调整时，只要外观接口稳定，客户端受影响较小。

### 缺点
1. **外观类可能变大**：整合逻辑过多时，外观类会逐渐膨胀。
2. **可能掩盖子系统能力**：过度封装会让高级用法不够灵活。
3. **不是所有场景都适合**：如果子系统本来就很简单，增加外观会显得多余。

### 适用场景
- 多个子系统组合调用
- 希望对外暴露统一入口
- 复杂模块需要降低使用门槛
- 分层架构中对下层模块进行封装

## 运行示例

编译和运行：
```bash
javac -d . src/com/pengli/designPattern/structural/facadePattern/*.java
java com.pengli.designPattern.structural.facadePattern.FacadeTest
```

### 输出示例
```text
ActionA doSomething
ActionB doSomething
ActionC doSomething
```

## 关键代码说明

### `ActionA` / `ActionB` / `ActionC`
- 各自负责一个独立子功能
- 客户端本来需要逐个手动调用它们

### `Facade`
- 在构造函数中统一创建子系统对象
- `integration()` 封装多个子系统的调用顺序
- 客户端无需感知内部细节

### `FacadeTest`
- 只依赖 `Facade`
- 通过统一方法完成多个动作整合

## 设计模式对比

| 模式 | 主要目标 | 是否简化调用 | 典型用途 |
|------|---------|-------------|---------|
| 外观模式 | 为复杂子系统提供统一入口 | 是 | 模块集成、统一 API |
| 适配器模式 | 让不兼容接口协同工作 | 否 | 旧接口兼容 |
| 代理模式 | 控制对象访问 | 否 | 访问控制、延迟加载 |

## 示例总结

这个示例展示了外观模式最核心的价值：
- 把多个子系统行为打包在一个统一接口里
- 客户端不再关心内部组合关系
- 使用更简单、结构更清晰

当一个模块“功能很多、调用很乱”时，外观模式通常非常有效。
