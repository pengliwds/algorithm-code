package com.pengli.designPattern.structural.bridgePattern;


/**
 * 桥接模式
 * 桥接模式是一种结构型设计模式，它将抽象部分与实现部分分离，使它们可以独立变化。这种模式通过使用组合关系代替继承关系，避免了继承层次的指数级爆炸。
 * <p>
 * 分离抽象与实现：将抽象接口与其具体实现解耦
 * 组合优于继承：使用对象组合代替多层继承
 * 两个维度独立变化：抽象和实现可以各自独立扩展，互不影响
 *
 * 使用场景
 * 当一个类存在两个独立变化的维度，且这两个维度都需要扩展时
 * 当需要在多个对象间共享实现时
 * 当需要避免在抽象和实现之间建立固定的绑定关系时
 * 当继承会导致类层次结构过于复杂时
 *
 */
public class BridgePatternTest {


    static void main() {
        //不同操作系统的不同文件逻辑处理
        System.out.println("=== 实际应用：跨平台文件处理 ===\n");

        // 创建文件格式
        FileFormat pdf = new PDFFormat();
        FileFormat docx = new DOCXFormat();

        // 创建不同系统的处理器
        FileProcessor windowsPdf = new WindowsFileProcessor(pdf);
        FileProcessor linuxDocx = new LinuxFileProcessor(docx);

        // 处理文件
        windowsPdf.processFile("重要的文档内容.pdf");
        System.out.println("信息: " + windowsPdf.getFileInfo());

        System.out.println();

        linuxDocx.processFile("Linux系统文档.doc");
        System.out.println("信息: " + linuxDocx.getFileInfo());

        System.out.println("\n=== 动态切换文件格式 ===");

        // 动态切换格式
        windowsPdf.setFileFormat(docx);
        windowsPdf.processFile("切换后的文档.docx");
        System.out.println("信息: " + windowsPdf.getFileInfo());
    }


}
