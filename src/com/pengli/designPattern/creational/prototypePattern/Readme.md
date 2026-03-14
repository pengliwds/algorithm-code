# 原型模式（Prototype Pattern）

## 设计模式简介

原型模式是一种创建型设计模式，它通过复制一个已有对象来创建新对象，而不是每次都重新实例化。  
当对象创建成本较高，或者需要基于某个现有对象生成多个相似对象时，原型模式会很有价值。

当前示例中，`Tree` 对象通过重写 `clone()` 方法进行复制，并且对其内部的 `Area` 对象做了深拷贝处理。

## 核心角色

### 1. 原型接口（Prototype）
约定对象具备复制自己的能力。Java 中通常通过实现 `Cloneable` 并重写 `clone()` 完成。

### 2. 具体原型（Concrete Prototype）
真正可被复制的对象。示例中的 `Tree` 和 `Area` 都实现了克隆能力。

### 3. 客户端（Client）
通过复制原型对象来生成新实例，而不是直接重新创建对象。

## 实现方式

### 1. 可克隆对象实现 `Cloneable`
```java
public class Area implements Cloneable {
    @Override
    protected Area clone() throws CloneNotSupportedException {
        return (Area) super.clone();
    }
}
```

### 2. 复杂对象在克隆时处理引用类型
```java
public class Tree implements Cloneable {
    private String name;
    private Area area;

    @Override
    protected Tree clone() throws CloneNotSupportedException {
        Tree tree = (Tree) super.clone();
        tree.setArea(this.area.clone());
        return tree;
    }
}
```

### 3. 基于原型对象批量复制
```java
Tree yinhua = new Tree();
Tree meihua = yinhua.clone();
Tree haitanghua = yinhua.clone();
```

## 实现特点

### 优点
1. **提升创建效率**：复制现有对象通常比重新初始化复杂对象更高效。
2. **简化对象创建过程**：客户端无需关心复杂初始化细节。
3. **便于生成相似对象**：适合多个对象只有少量差异的场景。
4. **支持运行期动态扩展**：可以在运行时通过复制已有对象生成新实例。

### 缺点
1. **需要正确处理深拷贝与浅拷贝**：引用类型处理不当容易产生共享状态问题。
2. **实现复杂对象克隆较麻烦**：层级越深、引用越多，克隆逻辑越复杂。
3. **依赖对象本身提供复制能力**：并非所有类都适合直接克隆。

### 适用场景
- 创建对象成本较高
- 需要大量相似对象
- 希望避免重复执行初始化过程
- 对象内部结构相对稳定，但属性值经常变化

## 运行示例

编译和运行：
```bash
javac -d . src/com/pengli/designPattern/creational/prototypePattern/*.java
java com.pengli.designPattern.creational.prototypePattern.PrototypePatternTest
```

### 输出示例
```text
Tree{name='樱花', area=Area{province='江苏省', city='南京'}}
Tree{name='梅花', area=Area{province='江苏省', city='南京'}}
Tree{name='海棠花', area=Area{province='江苏省', city='南京'}}
Tree{name='樱花', area=Area{province='江苏省', city='苏州'}}
Tree{name='梅花', area=Area{province='江苏省', city='南京'}}
Tree{name='海棠花', area=Area{province='江苏省', city='南京'}}
```

## 关键代码说明

### `Area`
- 实现浅层克隆
- 作为 `Tree` 的成员对象，被 `Tree.clone()` 进一步复制

### `Tree`
- 先调用 `super.clone()` 完成对象本身复制
- 再对 `area` 调用 `clone()`，实现深拷贝
- 这样修改原对象的 `area` 时，不会影响克隆对象

### 深拷贝体现
- `yinhua`、`meihua`、`haitanghua` 最初共享相同数据
- 当原始 `area` 的城市被修改为 `苏州` 后
- 只有原始对象变化，两个克隆对象仍保持 `南京`

这说明当前示例实现的是带引用对象复制的深拷贝方案。

## 设计模式对比

| 模式 | 创建方式 | 关注点 | 适合场景 |
|------|---------|------|---------|
| `new` 创建 | 直接实例化 | 构造过程 | 对象简单、创建成本低 |
| 工厂模式 | 工厂统一创建 | 封装创建逻辑 | 产品类型较多 |
| 建造者模式 | 分步骤构建 | 创建过程拆分 | 复杂对象组装 |
| 原型模式 | 复制已有对象 | 克隆与复用 | 相似对象批量生成 |

## 示例总结

这个示例的重点在于：
- `Tree` 不是重新构造，而是复制已有对象
- `Tree.clone()` 对 `Area` 继续克隆，避免共享同一引用
- 因而能够安全地基于一个原型派生出多个相似但独立的新对象

这正是原型模式在实际开发中的典型用法。
