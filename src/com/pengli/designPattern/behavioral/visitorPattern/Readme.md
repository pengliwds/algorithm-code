# 访问者模式（Visitor Pattern）

## 模式概述

访问者模式是一种行为型设计模式，它允许在不修改对象结构的前提下，定义作用于这些对象的新操作。它将操作从对象结构中分离出来，封装到独立的访问者类中。

## 核心思想

访问者模式的核心思想是：**将数据结构与作用于结构上的操作解耦**，使得操作集合可以相对自由地演化而不影响数据结构。

## 设计角色

### 1. 访问者接口（Visitor）
- 定义对每个具体元素的访问操作接口
- 通常包含多个 visit 方法，每个方法对应一种具体元素类型

### 2. 具体访问者（Concrete Visitor）
- 实现访问者接口，实现对具体元素的操作
- 每个具体访问者可以定义一组不同的操作

### 3. 元素接口（Element）
- 定义一个 accept 方法，接受访问者对象
- 通常形式为：`void accept(Visitor visitor)`

### 4. 具体元素（Concrete Element）
- 实现元素接口
- 在 accept 方法中调用访问者的对应 visit 方法

### 5. 对象结构（Object Structure）
- 存储元素集合
- 提供让访问者访问所有元素的方法

## 优缺点

### 优点

1. **符合单一职责原则**
   - 数据结构与操作分离，各自独立变化

2. **扩展性好**
   - 新增操作只需新增访问者类，无需修改元素类
   - 符合开闭原则

3. **灵活性高**
   - 可以定义多种访问者，实现不同的操作

4. **集中管理操作**
   - 相关的操作可以集中在同一个访问者中

### 缺点

1. **增加新的元素类困难**
   - 需要修改所有访问者接口和具体访问者类
   - 违反了开闭原则

2. **依赖倒置**
   - 元素类需要知道访问者接口
   - 增加了耦合度

3. **破坏封装**
   - 访问者可能需要访问元素的内部状态

4. **学习成本高**
   - 双重分发机制理解难度较大

## 适用场景

### 适用

1. **对象结构相对稳定**
   - 数据结构很少变化，但需要经常添加新的操作

2. **操作复杂且多样**
   - 一个对象结构包含多种类型的对象，需要对这些对象进行多种不同的操作

3. **需要避免操作在对象类中分散**
   - 不希望在对象类中添加大量操作代码

4. **需要对一个对象结构中的对象进行多种不同操作**
   - 例如：解析语法树、编译器设计等

### 不适用

1. **对象结构经常变化**
   - 频繁添加新的元素类型

2. **操作简单且固定**
   - 操作很少变化且逻辑简单

3. **元素类需要保持高内聚**
   - 不希望暴露内部状态给访问者

## 实现示例

本项目实现了一个动物管理系统：

- **元素接口**: `Animal` - 动物接口
- **具体元素**: `Dog`, `Cat`, `Bird` - 具体动物类
- **访问者接口**: `Visitor` - 访问者接口
- **具体访问者**:
  - `InfoVisitor` - 打印动物信息
  - `AgeStatVisitor` - 统计动物年龄
  - `YoungAnimalCheckVisitor` - 检查幼年动物
- **对象结构**: `AnimalManager` - 动物管理者

## 双重分发（Double Dispatch）

访问者模式实现了"双重分发"：

1. **第一重分发**: 元素调用访问者的 visit 方法
   - `animal.accept(visitor)` → `visitor.visit(this)`

2. **第二重分发**: 编译器根据元素的实际类型选择正确的 visit 方法重载
   - `visitor.visit(Dog dog)` 或 `visitor.visit(Cat cat)` 等

这使得访问者可以根据元素的具体类型执行不同的操作。

## 使用方法

### 基本使用

```java
// 创建对象结构
AnimalManager manager = new AnimalManager();

// 添加元素
manager.addAnimal(new Dog("旺财", 3, "金毛"));
manager.addAnimal(new Cat("咪咪", 2, "橘色"));

// 创建访问者
InfoVisitor visitor = new InfoVisitor();

// 让所有元素接受访问
manager.accept(visitor);
```

### 添加新操作（新增访问者）

```java
// 新增访问者，无需修改元素类
class YoungAnimalCheckVisitor implements Visitor {
    // 实现 visit 方法...
}

// 使用新访问者
YoungAnimalCheckVisitor youngCheck = new YoungAnimalCheckVisitor();
manager.accept(youngCheck);
```

## 运行测试

```bash
# 编译
javac -d out src/com/pengli/designPattern/behavioral/visitorPattern/*.java

# 运行
java -cp out com.pengli.designPattern.behavioral.visitorPattern.VisitorPatternTest
```

## 与其他模式的对比

| 模式 | 目的 | 操作添加方式 | 元素添加方式 |
|------|------|-------------|-------------|
| 访问者模式 | 分离操作与数据 | 新增访问者（简单） | 需修改所有访问者（困难） |
| 策略模式 | 封装算法 | 新增策略类（简单） | 无影响 |
| 装饰器模式 | 动态添加职责 | 新增装饰器（简单） | 无影响 |

## 总结

访问者模式的核心价值在于：**当数据结构稳定但操作频繁变化时，提供了一个优雅的解决方案**。但在数据结构不稳定、元素类型经常变化的情况下，访问者模式反而会增加维护成本。