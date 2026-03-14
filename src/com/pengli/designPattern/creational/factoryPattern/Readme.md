# 简单工厂模式（Simple Factory Pattern）

## 设计模式简介

简单工厂模式是一种常见的对象创建方式，通常也被归类到创建型设计思路中。  
它通过一个工厂类根据传入参数统一创建不同的具体对象，客户端无需直接 `new` 具体实现类。

当前示例中，`ShapeFactory` 根据字符串类型创建 `Circle`、`Square`、`Triangle` 等图形对象。

## 核心角色

### 1. 抽象产品（Product）
定义产品公共行为。示例中的 `Shape` 规定了 `printShape()` 方法。

### 2. 具体产品（Concrete Product）
实现抽象产品接口。示例中的 `Circle`、`Square`、`Triangle` 都实现了 `Shape`。

### 3. 工厂类（Factory）
负责根据条件返回对应的具体产品实例。示例中的 `ShapeFactory` 通过 `type` 参数决定创建哪一种图形。

## 实现方式

### 1. 定义统一产品接口
```java
public interface Shape {
    void printShape();
}
```

### 2. 定义具体产品
```java
public class Circle implements Shape {
    @Override
    public void printShape() {
        System.out.println("我是圆形");
    }
}
```

### 3. 由工厂统一创建对象
```java
public class ShapeFactory {
    public static Shape createShape(String type) {
        switch (type) {
            case "正方形":
                return new Square();
            case "圆形":
                return new Circle();
            case "三角形":
                return new Triangle();
            default:
                return null;
        }
    }
}
```

## 实现特点

### 优点
1. **封装对象创建逻辑**：客户端只关心要什么对象，不关心怎么创建。
2. **降低客户端与具体类的耦合**：客户端依赖抽象 `Shape`，不直接依赖具体图形类。
3. **调用简单**：统一通过工厂入口创建对象，使用门槛低。

### 缺点
1. **违反开闭原则**：新增一种产品时，需要修改工厂类中的判断逻辑。
2. **工厂职责过重**：产品种类越来越多时，工厂类会越来越复杂。
3. **类型判断集中**：`switch` 或 `if-else` 分支会持续膨胀。

### 适用场景
- 产品种类不多，创建逻辑相对简单
- 客户端不希望直接依赖具体实现类
- 希望把对象创建集中管理

## 运行示例

编译和运行：
```bash
javac -d . src/com/pengli/designPattern/creational/factoryPattern/*.java
java com.pengli.designPattern.creational.factoryPattern.FactoryPatternTest
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
- 统一规定图形输出行为

### `Circle` / `Square` / `Triangle`
- 具体产品实现
- 每种图形负责自己的业务表现

### `ShapeFactory`
- 统一对象创建入口
- 根据传入的图形名称返回不同具体实现

### `FactoryPatternTest`
- 客户端只通过工厂获得对象
- 使用过程中面向 `Shape` 接口编程

## 设计模式对比

| 模式 | 工厂数量 | 是否支持开闭原则 | 适合场景 |
|------|---------|----------------|---------|
| 简单工厂 | 一个 | 较弱 | 产品少、逻辑简单 |
| 工厂方法 | 多个 | 较好 | 产品扩展频繁 |
| 抽象工厂 | 多个工厂 + 多个产品族 | 强 | 需要创建一组相关对象 |

## 示例总结

这个示例体现了简单工厂模式的核心：
- 把对象创建集中到 `ShapeFactory`
- 客户端通过参数获取具体对象
- 简化使用方式，但扩展新产品时需要修改工厂类

因此，简单工厂更适合作为入门示例或产品类型比较稳定的场景。
