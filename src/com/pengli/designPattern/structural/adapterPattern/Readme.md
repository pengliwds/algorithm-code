# 适配器模式（Adapter Pattern）

## 设计模式简介

适配器模式是一种结构型设计模式，它通过增加一个适配器类，把原本接口不兼容的两个类连接起来，使它们能够协同工作。  
它的核心目标不是新增功能，而是“转换接口”，让旧代码能够接入新系统。

当前示例中，`LegacyFileHandler` 是已有的旧类，它的接口与系统期望的 `FileProcessor` 不一致，因此通过 `FileProcessorAdapter` 把旧接口适配成新接口。

## 核心角色

### 1. 目标接口（Target）
客户端期望使用的接口。示例中的 `FileProcessor` 就是目标接口。

### 2. 被适配者（Adaptee）
已有但接口不兼容的类。示例中的 `LegacyFileHandler` 提供了 `read()` 和 `determineFileType()`。

### 3. 适配器（Adapter）
负责把被适配者的接口转换成目标接口。示例中的 `FileProcessorAdapter` 就是适配器。

### 4. 客户端（Client）
面向目标接口编程，不直接依赖旧类。示例中的 `AdapterTest` 使用 `FileProcessor` 调用文件处理能力。

## 实现方式

### 1. 定义系统期望的目标接口
```java
public interface FileProcessor {
    void processFile(String fileName);
    String getFileType();
}
```

### 2. 旧类保留原有接口
```java
public class LegacyFileHandler {
    public void read(String fileName) { ... }
    public String determineFileType(String fileName) { ... }
}
```

### 3. 通过适配器完成接口转换
```java
public class FileProcessorAdapter implements FileProcessor {
    private LegacyFileHandler legacyFileHandler;

    @Override
    public void processFile(String fileName) {
        legacyFileHandler.read(fileName);
    }
}
```

## 实现特点

### 优点
1. **复用旧代码**：无需修改原有类，就能接入新系统。
2. **降低改造成本**：对遗留系统兼容非常友好。
3. **隔离变化**：客户端只依赖新接口，不感知旧接口细节。
4. **符合开闭原则**：通过新增适配器扩展兼容能力，而不是改旧类。

### 缺点
1. **类数量增加**：每适配一种接口，通常就要增加一个适配器类。
2. **多一层间接调用**：增加少量理解和维护成本。
3. **复杂适配场景实现麻烦**：接口差异越大，适配逻辑越复杂。

### 适用场景
- 新系统需要兼容旧系统接口
- 第三方库接口与项目规范不一致
- 希望在不修改旧类的前提下复用现有能力
- 需要统一多个不同来源组件的调用方式

## 运行示例

编译和运行：
```bash
javac -d . src/com/pengli/designPattern/structural/adapterPattern/*.java
java com.pengli.designPattern.structural.adapterPattern.AdapterTest
```

### 输出示例
```text
Reading file: test.txt
Determining file type for: default.txt
File type is txt
```

## 关键代码说明

### `FileProcessor`
- 新系统期望的统一文件处理接口
- 客户端只面向它编程

### `LegacyFileHandler`
- 表示已有旧系统能力
- 接口命名与新系统不一致，不能直接使用

### `FileProcessorAdapter`
- 持有 `LegacyFileHandler`
- 将 `processFile()` 转换为 `read()`
- 将 `getFileType()` 转换为 `determineFileType()`

### `AdapterTest`
- 客户端只依赖 `FileProcessor`
- 通过适配器间接使用旧类能力

## 设计模式对比

| 模式 | 主要目的 | 是否改变原接口 | 典型用途 |
|------|---------|---------------|---------|
| 适配器模式 | 接口兼容 | 否 | 旧系统接入、新旧接口转换 |
| 装饰器模式 | 动态增强功能 | 否 | 运行时扩展行为 |
| 外观模式 | 简化子系统调用 | 否 | 统一对外入口 |

## 示例总结

这个示例很好地体现了适配器模式的本质：
- 旧类 `LegacyFileHandler` 不动
- 新接口 `FileProcessor` 保持统一
- 中间通过 `FileProcessorAdapter` 完成兼容

这类模式在遗留系统改造和第三方组件整合中非常常见。
