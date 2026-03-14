# 单例模式（Singleton Pattern）

## 设计模式简介

单例模式是一种创建型设计模式，它确保一个类只有一个实例，并提供一个全局访问点来访问该实例。单例模式常用于需要全局唯一实例的场景，如配置管理器、日志记录器等。

## 核心角色

### 1. 单例类（Singleton）
实现单例模式的类，负责创建并维护自己的唯一实例。

## 实现方式

### 1. 饿汉式（静态常量）
```java
public class SingletonOne {
    // 1. 私有化构造器
    private SingletonOne() {}

    // 2. 类内部创建对象
    private static final SingletonOne INSTANCE = new SingletonOne();

    // 3. 提供公共的静态方法
    public static SingletonOne getInstance() {
        return INSTANCE;
    }
}
```

### 2. 懒汉式（线程不安全）
```java
public class SingletonTwo {
    private static SingletonTwo instance;

    private SingletonTwo() {}

    public static SingletonTwo getInstance() {
        if (instance == null) {
            instance = new SingletonTwo();
        }
        return instance;
    }
}
```

### 3. 双检锁（线程安全）
```java
public class SingletonThree {
    private static volatile SingletonThree instance;

    private SingletonThree() {}

    public static SingletonThree getInstance() {
        if (instance == null) {
            synchronized (SingletonThree.class) {
                if (instance == null) {
                    instance = new SingletonThree();
                }
            }
        }
        return instance;
    }
}
```

## 实现特点

### ✅ 优点
1. **节省内存**：只创建一个实例，减少内存消耗
2. **全局访问点**：提供统一的访问接口
3. **严格控制实例**：防止外部创建多个实例

### ⚠️ 缺点
1. **违反单一职责原则**：单例类既要管理实例又要处理业务逻辑
2. **扩展性差**：单例类很难扩展
3. **测试困难**：单例模式使得模块间的依赖关系难以

### 🎯 适用场景
- 日志记录器
- 配置管理器
- 数据库连接池
- 线程池
- 缓存
- 注册表

## 运行示例

编译和运行：
```bash
javac -d . src/com/pengli/designPattern/creational/singletonPattern/*.java
java com.pengli.designPattern.creational.singletonPattern.SingletonOne
```

### 输出示例：
```
=== 饿汉式单例 ===
创建单例实例
获取到的实例地址: SingletonOne@15db9742

=== 懒汉式单例 ===
第一次获取实例，创建对象
获取到的实例地址: SingletonTwo@6d03e736
再次获取实例，应返回同一个实例: SingletonTwo@6d03e736

=== 双检锁单例 ===
创建双检锁单例实例
获取到的实例地址: SingletonThree@5c647e05
多次获取实例验证: SingletonThree@5c647e05
```

## 关键代码说明

### 饿汉式
- **特点**：类加载时就创建实例，线程安全但可能浪费内存
- **适用**：实例创建不耗费资源，且一定会使用

### 懒汉式
- **特点**：第一次使用时才创建实例，线程不安全
- **适用**：实例创建耗费资源，可能不一定使用

### 双检锁
- **特点**：结合了饿汉式的线程安全和懒汉式的延迟加载
- **适用**：多线程环境，需要延迟加载

## 设计模式对比

| 实现方式 | 线程安全 | 延迟加载 | 性能 | 内存使用 |
|---------|---------|---------|------|---------|
| 饿汉式 | ✅ | ❌ | 高 | 较高 |
| 懒汉式 | ❌ | ✅ | 高 | 低 |
| 双检锁 | ✅ | ✅ | 中 | 低 |
| 静态内部类 | ✅ | ✅ | 高 | 低 |
| 枚举 | ✅ | ❌ | 最高 | 低 |