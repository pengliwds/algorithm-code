# 享元模式（Flyweight Pattern）

## 设计模式简介

享元模式是一种结构型设计模式，它通过共享对象来减少内存使用，特别适用于需要创建大量相似对象的场景。
核心思想是将对象的内部状态（不变的部分）与外部状态（变化的部分）分离，通过共享相同的内部状态对象来减少内存占用。

当前示例中，`ChessPiece` 是享元对象，`ConcreteChessPiece` 是具体享元，`ChessPieceFactory` 是享元工厂。围棋棋盘上可能有数百个棋子，但实际只有黑、白两种颜色，因此可以共享黑棋和白棋对象。

## 核心角色

### 1. 享元接口（Flyweight）
定义共享对象的公共接口。示例中的 `ChessPiece` 抽象类定义了 `display()` 方法。

### 2. 具体享元（Concrete Flyweight）
实现享元接口，包含可以共享的内部状态。示例中的 `ConcreteChessPiece` 具体实现棋子对象。

### 3. 享元工厂（Flyweight Factory）
负责创建和管理享元对象池。示例中的 `ChessPieceFactory` 使用 `HashMap` 缓存已创建的棋子对象。

### 4. 非享元对象（Unshared Flyweight）/ 外部状态
不能共享的状态，由客户端维护并传递给享元对象。示例中的 `Position` 表示棋子的位置，是外部状态。

### 5. 客户端（Client）
使用享元对象的代码。示例中的 `FlyweightPatternTest` 负责创建和展示棋子。

## 实现方式

### 1. 定义享元接口，分离内部和外部状态
```java
public abstract class ChessPiece {
    // 内部状态：颜色
    protected String color;

    public ChessPiece(String color) {
        this.color = color;
    }

    // 外部状态：位置
    public abstract void display(Position position);
}
```

### 2. 实现具体享元类
```java
public class ConcreteChessPiece extends ChessPiece {
    public ConcreteChessPiece(String color) {
        super(color);
        System.out.println("创建 " + color + " 棋子");
    }

    @Override
    public void display(Position position) {
        System.out.println(color + "棋子放在位置 (" +
                position.getX() + ", " + position.getY() + ")");
    }
}
```

### 3. 实现享元工厂管理共享对象
```java
public class ChessPieceFactory {
    private static final Map<String, ChessPiece> pieces = new HashMap<>();

    public static ChessPiece getChessPiece(String color) {
        if (!pieces.containsKey(color)) {
            pieces.put(color, new ConcreteChessPiece(color));
        }
        return pieces.get(color);
    }
}
```

### 4. 定义外部状态类
```java
public class Position {
    private int x;
    private int y;
    // getters and constructor
}
```

## 实现特点

### 优点
1. **减少内存占用**：通过共享相同内部状态的对象，显著降低内存使用。
2. **提高性能**：减少了对象创建和销毁的开销。
3. **简化对象管理**：享元工厂统一管理对象的生命周期。
4. **灵活性**：内部状态共享，外部状态可变，两者分离便于扩展。

### 缺点
1. **增加系统复杂性**：需要分离内部和外部状态，逻辑更复杂。
2. **需要维护共享对象**：享元工厂管理对象池，增加了一层间接性。
3. **可能影响线程安全**：共享对象在多线程环境下需要注意同步问题。
4. **不适用场景受限**：只有对象存在大量重复内部状态时才有效。

### 适用场景
- 需要创建大量相似对象的场景（如文档编辑器中的字符、游戏中的子弹粒子）
- 对象的大部分状态可以外部化（外部状态可以独立于对象存在）
- 应用程序不依赖对象身份（两个对象相等是指内容相等，而非引用相等）
- 需要缓存和重用对象以优化性能和内存

## 运行示例

编译和运行：
```bash
javac -d . src/com/pengli/designPattern/structural/flyweightPattern/*.java
java com.pengli.designPattern.structural.flyweightPattern.FlyweightPatternTest
```

### 输出示例
```text
=== 围棋棋盘示例 ===
创建 黑色 棋子
创建 白色 棋子
黑色棋子放在位置 (3, 3)
黑色棋子放在位置 (4, 4)
黑色棋子放在位置 (5, 5)
白色棋子放在位置 (3, 4)
白色棋子放在位置 (4, 3)

棋盘上摆放了 5 个棋子，但只创建了 2 个棋子对象
```

## 关键代码说明

### `ChessPiece`
- 抽象享元类
- 定义内部状态 `color`（棋子颜色，可共享）
- 定义抽象方法 `display(Position)`，接收外部状态

### `ConcreteChessPiece`
- 具体享元类
- 实现具体的棋子展示逻辑
- 内部状态在构造时初始化，之后不再改变

### `ChessPieceFactory`
- 享元工厂类
- 使用 `HashMap` 作为对象池
- `getChessPiece()` 方法提供获取享元对象的统一入口，确保相同内部状态的对象只创建一次

### `Position`
- 外部状态类
- 存储棋子的位置信息（x, y 坐标）
- 由客户端维护，使用时传递给享元对象

### `FlyweightPatternTest`
- 演示享元模式的客户端
- 创建 19x19 的棋盘（361 个位置）
- 摆放 5 个棋子，但只创建 2 个享元对象（黑棋、白棋各一个）

## 设计模式对比

| 模式 | 主要目的 | 状态管理 | 典型用途 |
|------|---------|---------|---------|
| 享元模式 | 减少内存占用 | 内外状态分离 | 大量相似对象共享（字符、粒子） |
| 单例模式 | 确保唯一实例 | 全局唯一 | 配置管理、连接池 |
| 原型模式 | 快速创建对象 | 克隆复制 | 复杂对象复制 |
| 对象池模式 | 重用已创建对象 | 对象池管理 | 数据库连接、线程池 |

| 模式 | 对象数量 | 共享方式 | 与享元模式区别 |
|------|---------|---------|-------------|
| 享元模式 | 大量 | 共享内部状态 | 内外状态分离，外部状态传递 |
| 单例模式 | 1个 | 全局唯一 | 不区分内外状态 |
| 原型模式 | 按需克隆 | 复制创建 | 复制整个对象而非共享 |

## 与其他设计模式的关系

### 享元模式 vs 单例模式
- **单例模式**：确保一个类只有一个实例，全局唯一
- **享元模式**：可以有多个享元对象，每个享元对象对应一种内部状态
- **联系**：享元工厂可以确保每种内部状态只创建一个实例（类似单例）

### 享元模式 vs 原型模式
- **原型模式**：通过克隆对象来创建新对象
- **享元模式**：通过共享对象来减少内存
- **联系**：两者都关注对象创建效率，但侧重点不同

### 享元模式 vs 组合模式
- **组合模式**：构建树形结构，部分-整体关系
- **享元模式**：共享子节点以减少内存
- **联系**：两者可以结合使用，享元模式可以优化组合模式中的叶子节点

### 享元模式 vs 装饰器模式
- **装饰器模式**：动态添加行为，不影响对象结构
- **享元模式**：共享对象内部状态
- **联系**：享元对象可以配合装饰器模式使用，在不增加对象数量的前提下扩展功能

## 示例总结

这个示例很好地体现了享元模式的核心思想：

1. **内部状态共享**：黑棋和白棋对象被创建后，可以无限次复用
2. **外部状态分离**：位置信息不存储在棋子对象中，而是由客户端维护
3. **内存优化**：棋盘上有 5 个棋子，但只创建了 2 个享元对象
4. **工厂管理**：`ChessPieceFactory` 统一管理享元对象的创建和获取

在真实应用中，享元模式常用于：
- 文字编辑器中的字符对象（共享字体、字号等内部状态）
- 游戏中的粒子效果（共享纹理、颜色等内部状态）
- 网站中的用户头像（共享同一张图片）
- 数据库连接池（共享连接对象）
- 字体渲染（共享字体对象）

享元模式是性能优化的有效手段，但需要谨慎使用，只在确实存在大量重复对象的情况下才有明显收益。
