# 代理模式（Proxy Pattern）

## 设计模式简介

代理模式是一种结构型设计模式，它为某个对象提供一个代理对象，由代理对象控制对原对象的访问。  
代理可以在不改变原对象的前提下，附加访问控制、日志、权限校验、延迟加载、增强行为等能力。

当前目录中包含两种典型实现：
- `staticProxy`：静态代理
- `dynamicProxy`：JDK 动态代理

两个示例都围绕 `GiveGift` 接口展开，由追求者 `Pursuit` 执行真正送礼行为，而代理对象在调用前后增加额外表达。

## 核心角色

### 1. 抽象主题（Subject）
定义真实对象和代理对象共同实现的接口。示例中的 `GiveGift` 就是抽象主题。

### 2. 真实主题（Real Subject）
真正执行业务逻辑的对象。示例中的 `Pursuit` 就是真实主题。

### 3. 代理对象（Proxy）
持有真实主题引用，并在访问时附加控制或增强逻辑。静态代理中的 `Proxy`、动态代理中的 `ProxyFactory` 都承担这一职责。

### 4. 客户端（Client）
通过代理访问真实主题，而不是直接操作真实对象。示例中的 `ProxyTest` 和 `DynamicProxyTest` 就是客户端。

## 实现方式

### 1. 定义统一接口
```java
public interface GiveGift {
    void giveMoney();
    void giveFlowers();
    void giveBags();
}
```

### 2. 真实对象实现业务逻辑
```java
public class Pursuit implements GiveGift {
    @Override
    public void giveFlowers() {
        System.out.println("追求者送了99朵花");
    }
}
```

### 3. 静态代理显式包装真实对象
```java
public class Proxy implements GiveGift {
    Pursuit pursuit;

    @Override
    public void giveFlowers() {
        pursuit.giveFlowers();
        System.out.println("代理类说我爱你");
    }
}
```

### 4. 动态代理在运行时生成代理对象
```java
public static <T> T getProxy(T target) {
    return (T) Proxy.newProxyInstance(
        target.getClass().getClassLoader(),
        target.getClass().getInterfaces(),
        new DynamicProxyHandler<>(target)
    );
}
```

## 实现特点

### 优点
1. **控制访问**：可以在不改原对象的前提下拦截调用。
2. **增强能力灵活**：便于附加日志、权限、缓存、事务等逻辑。
3. **职责分离**：核心业务放在真实对象，附加逻辑放在代理中。
4. **动态代理扩展性更强**：可以为一类接口统一生成代理。

### 缺点
1. **结构更复杂**：引入代理层后，调用链更长。
2. **静态代理类数量多**：每个接口或类都可能要写一个代理类。
3. **动态代理有一定理解门槛**：涉及反射和运行时生成代理对象。

### 适用场景
- 权限控制
- 日志记录
- 延迟加载
- 远程代理
- AOP 场景下的方法增强

## 运行示例

静态代理编译和运行：
```bash
javac -d . src/com/pengli/designPattern/structural/proxyPattern/staticProxy/*.java
java com.pengli.designPattern.structural.proxyPattern.staticProxy.ProxyTest
```

动态代理编译和运行：
```bash
javac -d . src/com/pengli/designPattern/structural/proxyPattern/dynamicProxy/*.java
java com.pengli.designPattern.structural.proxyPattern.dynamicProxy.DynamicProxyTest
```

### 输出示例
```text
追求者送了99朵花
代理类说我爱你
追求者送了爱马仕包
代理类说我爱你
追求者送了一万块
代理类说我爱你
```

动态代理版本中，附加输出会先由代理处理器打印，再调用真实对象方法。

## 关键代码说明

### `staticProxy/Proxy`
- 代理类显式实现 `GiveGift`
- 内部持有 `Pursuit`
- 每个方法中先或后调用增强逻辑

### `dynamicProxy/ProxyFactory`
- 使用 JDK `Proxy.newProxyInstance()` 动态创建代理对象
- 通过 `InvocationHandler` 统一拦截所有接口方法
- 适合做通用增强

### `Pursuit`
- 表示真实业务对象
- 两种代理方式都围绕它展开

## 设计模式对比

| 模式 | 主要目的 | 是否控制访问 | 典型用途 |
|------|---------|-------------|---------|
| 代理模式 | 通过代理控制或增强访问 | 是 | 权限、日志、延迟加载 |
| 装饰器模式 | 动态增强功能 | 部分 | 功能叠加 |
| 外观模式 | 简化子系统入口 | 否 | 模块整合 |

## 示例总结

这个目录把代理模式的两种经典写法都展示出来了：
- 静态代理适合直观理解和简单场景
- 动态代理更适合通用增强和框架化扩展

两者的共同点都是：不改真实对象，通过代理层附加额外能力。
