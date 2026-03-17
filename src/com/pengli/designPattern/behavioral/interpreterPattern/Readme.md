# 解释器模式（Interpreter Pattern）

## 模式概述

解释器模式是一种行为型设计模式，它用于定义一种语言文法，并建立一个解释器来解释该语言中的句子。

## 设计角色

### 1. 抽象表达式（Abstract Expression）
- 定义解释器的接口，主要包含 `interpret()` 方法

### 2. 终结符表达式（Terminal Expression）
- 实现与文法中的终结符相关的解释操作
- 例如：数字、变量等

### 3. 非终结符表达式（Non-terminal Expression）
- 实现与文法中的非终结符相关的解释操作
- 例如：加法、减法、乘法、除法等

### 4. 上下文（Context）
- 包含解释器之外的一些全局信息

## 实现示例

本项目实现了一个简单的算术表达式解释器，支持以下运算：
- 数字（终结符表达式）
- 加法（非终结符表达式）
- 减法（非终结符表达式）
- 乘法（非终结符表达式）
- 除法（非终结符表达式）

## 优缺点

### 优点
1. **扩展性好**：可以轻松扩展新的表达式类型
2. **易于实现**：对于简单的文法，实现起来比较直观
3. **灵活性高**：可以动态构建复杂的表达式

### 缺点
1. **复杂度高**：对于复杂的文法，解释器可能会变得非常复杂
2. **效率较低**：解释执行的效率通常不如编译执行的效率高
3. **维护困难**：随着文法的复杂化，维护解释器的成本会急剧增加

## 适用场景

1. 当需要解释执行简单语言或表达式时
2. 当语言中的文法相对简单时
3. 当需要频繁修改或扩展文法规则时

## 不适用场景

1. 当文法非常复杂时
2. 当对执行效率有较高要求时
3. 当不需要动态构建表达式时

## 使用方法

```java
// 创建表达式: 10 + 2 * 6 - 4 / 2
Expression expression = new MinusExpression(
    new PlusExpression(
        new NumberExpression(10),
        new MultiplyExpression(
            new NumberExpression(2),
            new NumberExpression(6)
        )
    ),
    new DivideExpression(
        new NumberExpression(4),
        new NumberExpression(2)
    )
);

// 解释计算
int result = expression.interpret();
```

## 运行测试

```bash
# 编译
javac -d out src/com/pengli/designPattern/behavioral/interpreterPattern/*.java

# 运行
java -cp out com.pengli.designPattern.behavioral.interpreterPattern.InterpreterPatternTest
```