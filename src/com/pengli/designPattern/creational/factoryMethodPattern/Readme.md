# 工厂方法模式（Factory Method Pattern）

## 设计模式简介

工厂方法模式是一种创建型设计模式，它定义了创建对象的接口，但将具体实例化延迟到子类中完成。  
与简单工厂不同，工厂方法模式不再通过一个“大而全”的工厂类负责所有产品创建，而是让每种产品拥有自己的工厂实现，从而更符合开闭原则。

当前示例中，`CircleFactory`、`SquareFactory`、`TriangleFactory` 分别负责创建各自的图形对象。

## 核心角色

### 1. 抽象产品（Product）
定义产品公共行为。示例中的 `Shape` 定义了 `printShape()` 方法。

### 2. 具体产品（Concrete Product）
实现抽象产品接口。示例中的 `Circle`、`Square`、`Triangle` 都属于具体产品。

### 3. 抽象工厂（Creator）
声明工厂方法。示例中的 `ShapeFactory` 规定了 `createShape()`。

### 4. 具体工厂（Concrete Creator）
实现工厂方法并返回具体产品对象。示例中的 `CircleFactory`、`SquareFactory`、`TriangleFactory` 分别创建不同图形。

## 实现方式

### 1. 定义产品接口
```java
public interface Shape {
    void printShape();
}
```

### 2. 定义工厂接口
```java
public interface ShapeFactory {
    Shape createShape();
}
```

### 3. 为每个产品提供独立工厂
```java
public class CircleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Circle();
    }
}
```

## 实现特点

### 优点
1. **符合开闭原则**：新增产品时，通常只需要新增产品类和对应工厂类。
2. **降低耦合**：客户端依赖抽象产品和抽象工厂，而不直接依赖具体实现。
3. **职责清晰**：对象创建逻辑分散到各自工厂中，避免单个工厂过于庞大。
4. **便于扩展**：适合产品类型不断增加的场景。

### 缺点
1. **类数量增加**：每增加一种产品，通常也要增加一个工厂类。
2. **结构更复杂**：相比简单工厂，需要引入更多抽象层次。
3. **对简单场景可能过度设计**：如果产品种类少，工厂方法模式会显得略重。

### 适用场景
- 产品种类会不断扩展
- 希望遵守开闭原则
- 希望把对象创建职责拆分到不同工厂
- 客户端只依赖抽象，不直接依赖具体产品类

## 运行示例

编译和运行：
```bash
javac -d . src/com/pengli/designPattern/creational/factoryMethodPattern/*.java
java com.pengli.designPattern.creational.factoryMethodPattern.FactoryMethodPatternTest
```

### 输出示例
```text
我是圆形
我是正方形
我是三角形
```

## 关键代码说明

### `Shape`
- 抽象产品接口
- 所有图形都实现统一输出行为

### `ShapeFactory`
- 抽象工厂接口
- 统一规定创建产品的方法

### `CircleFactory` / `SquareFactory` / `TriangleFactory`
- 每个工厂只负责一种产品的创建
- 将对象实例化逻辑拆分到具体工厂中

### `FactoryMethodPatternTest`
- 客户端分别选择不同工厂创建产品
- 获取到对象后，依然通过 `Shape` 抽象接口使用

## 设计模式对比

| 模式 | 创建入口 | 扩展方式 | 是否符合开闭原则 |
|------|---------|---------|----------------|
| 简单工厂 | 一个工厂类 | 修改工厂分支 | 一般 |
| 工厂方法 | 多个具体工厂 | 新增产品类和工厂类 | 较好 |
| 抽象工厂 | 多个工厂创建多个产品族 | 新增产品族 | 很好 |

## 示例总结

这个示例展示了工厂方法模式的典型做法：
- 使用 `Shape` 统一抽象产品
- 使用 `ShapeFactory` 统一抽象创建行为
- 通过不同具体工厂创建不同图形对象

相较于简单工厂，它把“创建哪一种对象”的决定权下放到了具体工厂类中，因此扩展性更好。
