# 装饰器模式（Decorator Pattern）

## 设计模式简介

装饰器模式是一种结构型设计模式，它在不修改原对象类的前提下，通过包装对象的方式，动态地为对象增加额外功能。  
相比继承，装饰器模式更灵活，因为功能可以在运行时自由组合。

当前示例中，`Yourself` 表示原始对象，`Tshirt`、`Trousers`、`Shoes` 分别是不同装饰器，通过层层包裹实现“穿搭”效果。

## 核心角色

### 1. 抽象组件（Component）
定义对象公共接口。示例中的 `Person` 规定了 `doSomething()`。

### 2. 具体组件（Concrete Component）
被装饰的原始对象。示例中的 `Yourself` 就是基础对象。

### 3. 抽象装饰器（Decorator）
实现与组件一致的接口，并持有组件对象引用。示例中的 `PersonDecorator` 就是抽象装饰器。

### 4. 具体装饰器（Concrete Decorator）
为原对象动态增加功能。示例中的 `Tshirt`、`Trousers`、`Shoes` 分别扩展不同穿衣行为。

## 实现方式

### 1. 定义统一组件接口
```java
public interface Person {
    void doSomething();
}
```

### 2. 抽象装饰器包装组件
```java
public abstract class PersonDecorator implements Person {
    public Person person;

    @Override
    public void doSomething() {
        person.doSomething();
    }
}
```

### 3. 具体装饰器在调用前后扩展行为
```java
public class Tshirt extends PersonDecorator {
    @Override
    public void doSomething() {
        super.doSomething();
        System.out.println("穿Tshirt");
    }
}
```

## 实现特点

### 优点
1. **动态增强功能**：可以在运行时自由组合装饰功能。
2. **比继承更灵活**：不需要为各种组合情况创建大量子类。
3. **符合开闭原则**：通过新增装饰器扩展功能，而不修改原类。
4. **组合顺序可控**：不同包装顺序可以产生不同效果。

### 缺点
1. **对象层次增加**：多层装饰后理解链路会稍复杂。
2. **调试不如直接调用直观**：需要顺着包装链逐层查看。
3. **过度使用会让结构变碎**：装饰器太多时阅读成本会上升。

### 适用场景
- 运行时动态增强对象行为
- 希望避免继承带来的类爆炸
- 功能需要自由组合、叠加
- 原类不方便修改，但需要扩展行为

## 运行示例

编译和运行：
```bash
javac -d . src/com/pengli/designPattern/structural/decoratorPattern/*.java
java com.pengli.designPattern.structural.decoratorPattern.DecoratorTest
```

### 输出示例
```text
我是xxx
穿Tshirt
穿裤子
穿鞋子
```

## 关键代码说明

### `Person`
- 抽象组件接口
- 所有原始对象和装饰器都实现同一接口

### `Yourself`
- 具体组件
- 表示最原始、未被装饰的对象

### `PersonDecorator`
- 抽象装饰器
- 内部持有 `Person` 对象，并默认委托原行为

### `Tshirt` / `Trousers` / `Shoes`
- 在原行为基础上逐层追加功能
- 示例中体现为不同服饰的叠加效果

### `DecoratorTest`
- 通过 `new Shoes(new Trousers(new Tshirt(new Yourself())))`
  构造出一条装饰链
- 最终执行时会从内到外依次附加行为

## 设计模式对比

| 模式 | 主要目的 | 是否动态增强 | 典型方式 |
|------|---------|-------------|---------|
| 装饰器模式 | 运行时扩展对象功能 | 是 | 对象包装 |
| 适配器模式 | 转换接口 | 否 | 接口兼容 |
| 代理模式 | 控制访问 | 可附带增强 | 访问控制、增强 |

## 示例总结

这个示例通过“穿衣服”场景把装饰器模式表现得很直观：
- `Yourself` 是原始对象
- 不同衣物是不同装饰器
- 每加一层装饰，就多一层行为

它很好地说明了装饰器模式“增强功能但不改原类”的核心思想。
