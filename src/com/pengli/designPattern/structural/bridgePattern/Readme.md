# 桥接模式（Bridge Pattern）

## 设计模式简介

桥接模式是一种结构型设计模式，它将抽象部分与实现部分分离，使它们可以独立变化。  
当一个系统存在两个或多个独立变化维度时，桥接模式可以避免类继承层级不断膨胀。

当前示例中有两个独立变化维度：
- 操作系统维度：`WindowsFileProcessor`、`LinuxFileProcessor`
- 文件格式维度：`PDFFormat`、`DOCXFormat`

通过桥接模式，这两个维度可以自由组合，而不必为每种组合都创建一个子类。

## 核心角色

### 1. 抽象部分（Abstraction）
定义高层抽象，并持有实现部分的引用。示例中的抽象类 `FileProcessor` 就是抽象部分。

### 2. 扩展抽象（Refined Abstraction）
对抽象部分进行具体扩展。示例中的 `WindowsFileProcessor` 和 `LinuxFileProcessor` 属于扩展抽象。

### 3. 实现部分（Implementor）
定义底层实现接口。示例中的 `FileFormat` 定义了 `save()` 和 `load()`。

### 4. 具体实现（Concrete Implementor）
提供具体实现细节。示例中的 `PDFFormat` 和 `DOCXFormat` 是具体实现。

## 实现方式

### 1. 抽象类组合实现接口
```java
abstract class FileProcessor {
    protected FileFormat fileFormat;

    public FileProcessor(FileFormat fileFormat) {
        this.fileFormat = fileFormat;
    }
}
```

### 2. 不同抽象扩展不同平台逻辑
```java
public class WindowsFileProcessor extends FileProcessor {
    @Override
    public void processFile(String data) {
        fileFormat.save(data);
    }
}
```

### 3. 不同实现类负责不同格式逻辑
```java
public class PDFFormat implements FileFormat {
    @Override
    public void save(String data) { ... }
}
```

## 实现特点

### 优点
1. **抽象与实现解耦**：平台和格式两个维度可以独立扩展。
2. **避免类爆炸**：不需要为每种“平台 + 格式”组合都写一个子类。
3. **运行时灵活切换实现**：示例中支持通过 `setFileFormat()` 动态切换文件格式。
4. **更符合组合优于继承的思想**：通过组合代替多维继承。

### 缺点
1. **设计理解门槛较高**：比普通继承结构更抽象。
2. **系统初期可能显得复杂**：如果变化维度不明显，使用桥接会偏重。
3. **需要提前识别变化维度**：设计不当时容易抽象过度。

### 适用场景
- 存在两个或多个独立变化维度
- 希望避免多层继承结构
- 需要在运行时切换实现部分
- 高层逻辑与底层实现需要解耦

## 运行示例

当前 [BridgePatternTest.java](G:\code\algorithm-code\src\com\pengli\designPattern\structural\bridgePattern\BridgePatternTest.java) 中的入口方法是 `static void main()`，不是标准的 `public static void main(String[] args)`，更适合在 IDE 中直接调用该方法演示。

编译命令：
```bash
javac -d . src/com/pengli/designPattern/structural/bridgePattern/*.java
```

### 示例流程
```text
1. 创建 PDF 与 DOCX 两种文件格式实现
2. 创建 Windows 与 Linux 两种文件处理器
3. 分别组合成不同平台 + 格式的处理方案
4. 动态切换同一个处理器的文件格式
```

## 关键代码说明

### `FileProcessor`
- 抽象“文件处理器”这一高层概念
- 内部组合 `FileFormat`
- 允许通过 `setFileFormat()` 动态更换底层实现

### `WindowsFileProcessor` / `LinuxFileProcessor`
- 表示平台维度的不同扩展
- 负责平台相关处理逻辑

### `FileFormat`
- 抽象文件格式接口
- 屏蔽 PDF / DOCX 等具体存取细节

### `PDFFormat` / `DOCXFormat`
- 负责格式维度的具体实现
- 与操作系统维度完全独立

## 设计模式对比

| 模式 | 关注点 | 是否强调多维变化 | 典型收益 |
|------|------|----------------|---------|
| 桥接模式 | 分离抽象与实现 | 是 | 避免类爆炸 |
| 适配器模式 | 转换不兼容接口 | 否 | 兼容旧接口 |
| 外观模式 | 简化子系统入口 | 否 | 降低使用复杂度 |

## 示例总结

这个示例非常适合理解桥接模式：
- “平台”是一条变化维度
- “文件格式”是另一条变化维度
- 两者通过组合桥接起来，可以自由搭配

这正是桥接模式最经典的应用场景。
