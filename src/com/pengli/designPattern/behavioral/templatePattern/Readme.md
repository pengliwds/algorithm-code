# 模板方法模式（Template Method Pattern）

## 设计模式简介

模板方法模式是一种行为型设计模式，它在抽象父类中定义一个算法骨架，把具体可变步骤延迟到子类去实现。  
这样可以在复用整体流程的同时，让子类自由定制其中的部分细节。

当前示例中，`AbstractSuperClass` 定义了统一答题流程，`StudentA` 和 `StudentB` 则分别给出不同答案。

## 核心角色

### 1. 抽象模板类（Abstract Class）
定义模板方法和算法骨架。示例中的 `AbstractSuperClass` 提供了 `doComplexThings()`。

### 2. 具体子类（Concrete Class）
实现模板类中的抽象步骤。示例中的 `StudentA` 和 `StudentB` 分别实现 `doUniqueThingA()`、`doUniqueThingB()`、`doUniqueThingC()`。

### 3. 客户端（Client）
负责创建具体子类对象并调用模板方法。示例中的 `TemplatePatternTest` 演示了这个过程。

## 实现方式

### 1. 抽象类定义模板方法
```java
public final void doComplexThings() {
    System.out.println("您的姓名是：");
    doUniqueThingA();
    ...
    doUniqueThingB();
    ...
    doUniqueThingC();
}
```

### 2. 可变步骤交给子类实现
```java
abstract void doUniqueThingA();
abstract void doUniqueThingB();
abstract void doUniqueThingC();
```

### 3. 不同子类给出不同实现
```java
public class StudentA extends AbstractSuperClass {
    @Override
    void doUniqueThingA() {
        System.out.println("刘备");
    }
}
```

## 实现特点

### 优点
1. **复用公共流程**：把算法骨架写在父类中，避免重复代码。
2. **控制整体执行顺序**：流程由模板方法统一掌控。
3. **便于扩展细节**：子类只需要实现变化部分。
4. **符合“好莱坞原则”**：父类控制流程，子类被动参与。

### 缺点
1. **依赖继承**：灵活性不如组合方式高。
2. **父类修改影响面大**：模板方法变化可能影响所有子类。
3. **层次过深时不易维护**：继承结构复杂会降低理解成本。

### 适用场景
- 多个子类有相同的处理流程
- 流程固定，但某些具体步骤可变
- 希望通过父类统一约束执行顺序
- 需要提取公共代码减少重复

## 运行示例

编译和运行：
```bash
javac -d . src/com/pengli/designPattern/behavioral/templatePattern/*.java
java com.pengli.designPattern.behavioral.templatePattern.TemplatePatternTest
```

### 输出示例
```text
您的姓名是：
刘备
火影忍者动漫中，第五代火影是谁:
A. 卡卡西
B. 鸣人
C. 纲手
A
海贼王中为什么路飞的身体可以被拉长?
A. 吃了恶魔果实
B. 遗传他父亲的
C. 九九八十一天苦练而得
B
=====================这是一条华丽的分割线=====================
您的姓名是：
张飞
...
```

## 关键代码说明

### `AbstractSuperClass`
- `doComplexThings()` 定义统一执行流程
- 三个抽象方法表示流程中的可变步骤
- `final` 关键字保证子类不能篡改整体流程

### `StudentA` / `StudentB`
- 只负责给出自己的具体答案
- 共享父类中的题目展示和执行顺序

### `TemplatePatternTest`
- 依次执行两个学生对象的模板方法
- 体现相同流程下不同实现结果

## 设计模式对比

| 模式 | 复用方式 | 变化点位置 | 典型场景 |
|------|---------|-----------|---------|
| 模板方法模式 | 继承 | 子类重写步骤 | 固定流程、多实现 |
| 策略模式 | 组合 | 独立策略对象 | 运行时切换算法 |
| 命令模式 | 封装请求 | 命令对象 | 操作抽象、撤销重做 |

## 示例总结

这个示例清楚展示了模板方法模式的核心：
- 父类负责定义流程骨架
- 子类负责实现具体差异
- 客户端只需调用模板方法即可完成整套流程

当“流程固定、步骤可变”时，模板方法模式通常是非常自然的选择。
