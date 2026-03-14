# 建造者模式（Builder Pattern）

## 设计模式简介

建造者模式是一种创建型设计模式，它将复杂对象的构建过程与最终表示分离，使得同样的构建步骤可以生成不同的产品对象。  
当一个对象需要按固定步骤分阶段创建，并且不同实现会产生不同结果时，建造者模式非常适合。

当前示例中，`Director` 负责统一装配流程，`ConcreteBuilderA` 和 `ConcreteBuilderB` 负责构建不同风格的产品。

## 核心角色

### 1. 抽象建造者（Builder）
定义创建产品各个部件的接口，例如 `buildPartA()`、`buildPartB()` 和 `getResult()`。

### 2. 具体建造者（Concrete Builder）
实现具体的部件构造逻辑。示例中的 `ConcreteBuilderA`、`ConcreteBuilderB` 会构建出不同内容的产品。

### 3. 指挥者（Director）
负责安排构建步骤和顺序。示例中的 `Director` 固定按照先构建 PartA、再构建 PartB 的顺序执行。

### 4. 产品（Product）
最终被创建出来的复杂对象。示例中的 `BuilderProduct` 使用 `List<String>` 保存产品组成部分。

## 实现方式

### 1. 定义建造接口
```java
public interface Builder {
    void buildPartA();
    void buildPartB();
    BuilderProduct getResult();
}
```

### 2. 实现具体建造者
```java
public class ConcreteBuilderA implements Builder {
    private final BuilderProduct product = new BuilderProduct();

    @Override
    public void buildPartA() {
        product.add("部件A");
    }

    @Override
    public void buildPartB() {
        product.add("部件B");
    }

    @Override
    public BuilderProduct getResult() {
        return product;
    }
}
```

### 3. 由指挥者统一构建
```java
public class Director {
    public BuilderProduct build(Builder builder) {
        builder.buildPartA();
        builder.buildPartB();
        return builder.getResult();
    }
}
```

## 实现特点

### 优点
1. **分离构建过程和结果**：客户端不需要了解产品内部装配细节。
2. **便于扩展**：新增一种产品表示时，通常只需要新增具体建造者。
3. **过程可控**：通过 `Director` 可以固定创建步骤，保证构建过程一致。
4. **适合复杂对象创建**：对象由多个部件组成、创建顺序明确时尤其适用。

### 缺点
1. **类数量增加**：每新增一种构建方式，通常就需要增加一个具体建造者类。
2. **不适合过于简单的对象**：如果对象创建过程很简单，使用建造者会显得冗余。
3. **产品结构差异过大时不方便**：若产品之间差异非常大，统一抽象建造步骤会变困难。

### 适用场景
- 创建过程较复杂、包含多个步骤的对象
- 同一构建流程需要生成不同表示结果
- 希望把“如何构建”与“构建什么”分离
- 需要屏蔽复杂对象的装配细节

## 运行示例

编译和运行：
```bash
javac -d . src/com/pengli/designPattern/creational/builderPattern/*.java
java com.pengli.designPattern.creational.builderPattern.BuilderTest
```

### 输出示例
```text
===ConcreteBuilderA buildPartA===
===ConcreteBuilderA buildPartB===
构建的产品：
[部件A, 部件B]
===ConcreteBuilderB buildPartA===
===ConcreteBuilderB buildPartA===
构建的产品：
[部件X, 部件Y]
```

## 关键代码说明

### `Builder`
- 定义所有建造者都必须实现的构建步骤
- 保证 `Director` 可以面向抽象编排流程

### `ConcreteBuilderA` / `ConcreteBuilderB`
- 使用不同的实现生成不同的产品内容
- 示例中分别加入 `部件A/部件B` 和 `部件X/部件Y`

### `Director`
- 封装固定构建顺序
- 客户端只需要选择建造者，不必关心装配细节

### `BuilderProduct`
- 保存构建结果
- 通过 `add()` 累积部件，通过 `showProduct()` 展示最终内容

## 设计模式对比

| 模式 | 关注点 | 是否分步骤构建 | 是否隐藏创建细节 |
|------|------|--------------|----------------|
| 简单工厂 | 创建哪种对象 | 否 | 是 |
| 工厂方法 | 由子类决定创建哪种对象 | 否 | 是 |
| 建造者模式 | 如何一步步构建复杂对象 | 是 | 是 |
| 原型模式 | 通过复制已有对象创建新对象 | 否 | 部分 |

## 示例总结

这个示例展示了建造者模式最典型的思路：
- `Director` 固定流程
- `Builder` 定义步骤
- `ConcreteBuilder` 决定每一步具体做什么
- `BuilderProduct` 表示最终结果

因此，同样的构建顺序可以得到不同的产品表示，这正是建造者模式的核心价值。
