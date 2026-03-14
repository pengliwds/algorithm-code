# 责任链模式（Chain of Responsibility Pattern）

## 设计模式简介

责任链模式是一种行为型设计模式，它将多个处理者串成一条链，请求沿着这条链依次传递，直到某个处理者完成处理或链结束。  
这样可以让请求发送者不必关心究竟由谁处理请求，从而降低发送者和处理者之间的耦合。

当前示例中，`FirstCheck`、`SecondCheck`、`ThirdCheck` 被串联成一条校验链，依次执行检查逻辑，最终返回校验结果。

## 核心角色

### 1. 抽象处理者（Handler）
定义处理请求的接口，并持有下一个处理者的引用。示例中的 `CheckHandler` 就是责任链抽象类。

### 2. 具体处理者（Concrete Handler）
真正执行具体处理逻辑的类。示例中的 `FirstCheck`、`SecondCheck`、`ThirdCheck` 分别负责不同环节的校验。

### 3. 请求结果（Result）
用于封装处理结果。示例中的 `Result` 保存了最终提示信息。

### 4. 客户端（Client）
负责组装责任链并发起请求。示例中的 `PatternTest` 使用 `CheckHandler.Builder` 构造链条并调用 `check()`。

## 实现方式

### 1. 定义抽象处理者
```java
public abstract class CheckHandler {
    protected CheckHandler next;

    abstract Result check();
}
```

### 2. 构建责任链
```java
CheckHandler.Builder builder = new CheckHandler.Builder();
builder.addHandler(new FirstCheck())
       .addHandler(new SecondCheck())
       .addHandler(new ThirdCheck());
```

### 3. 处理者决定是否传递给下一个节点
```java
if (null != next) {
    return next.check();
}
return new Result("第三道关校验成功");
```

## 实现特点

### 优点
1. **降低耦合**：请求发起者不需要知道由哪个对象具体处理。
2. **增强扩展性**：可以方便地新增、删除或调整处理节点顺序。
3. **职责分离**：每个处理者只负责自己那一段逻辑。
4. **链式处理清晰**：很适合多阶段校验、审批、过滤等流程。

### 缺点
1. **调试链路较长**：责任链较复杂时，排查请求到底被谁处理会变麻烦。
2. **可能无人处理**：如果链中没有节点处理请求，可能得到空结果或默认结果。
3. **性能受链长影响**：链条过长时，请求需要逐个节点传递。

### 适用场景
- 多级审批流程
- 登录、支付、表单等多步校验
- 过滤器、拦截器链
- 请求需要由多个候选对象顺序处理

## 运行示例

编译和运行：
```bash
javac -d . src/com/pengli/designPattern/behavioral/chainOfResponsibilityPattern/*.java
java com.pengli.designPattern.behavioral.chainOfResponsibilityPattern.PatternTest
```

### 输出示例
```text
第一道关
第一道关校验成功
第二道关
第二道关校验成功
第三道关
第三道关校验成功
第三道关校验成功
```

## 关键代码说明

### `CheckHandler`
- 定义 `next` 引用，用于把多个处理者串起来
- 内部 `Builder` 负责按顺序组装责任链

### `FirstCheck` / `SecondCheck` / `ThirdCheck`
- 每个类负责一个独立校验步骤
- 当前步骤完成后，通过 `next.check()` 把请求继续向后传递

### `Result`
- 封装链路执行后的结果信息
- 当前示例中主要用于输出最终校验状态

### `PatternTest`
- 客户端只负责“搭链”和“发请求”
- 不需要关心具体每一步的执行细节

## 设计模式对比

| 模式 | 主要目标 | 请求流向 | 典型场景 |
|------|---------|---------|---------|
| 责任链模式 | 让多个对象依次处理请求 | 沿链传递 | 审批、校验、过滤 |
| 命令模式 | 把请求封装成对象 | 由调用者触发 | 遥控器、撤销重做 |
| 策略模式 | 动态切换算法 | 单点选择 | 不同业务规则切换 |

## 示例总结

这个示例展示了责任链模式的核心思想：
- 将多个校验步骤拆分成多个处理者
- 通过 `Builder` 组装成一条执行链
- 请求沿链顺序向后传递，直到处理完成

这样既保留了流程顺序，又让每一步职责保持独立。
