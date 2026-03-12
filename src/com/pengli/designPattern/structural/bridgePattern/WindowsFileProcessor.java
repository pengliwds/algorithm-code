package com.pengli.designPattern.structural.bridgePattern;

public class WindowsFileProcessor extends FileProcessor{
    public WindowsFileProcessor(FileFormat fileFormat) {
        super(fileFormat);
    }

    @Override
    public void processFile(String data) {
        System.out.println("在Windows系统上处理文件...");
        fileFormat.save(data);
    }

    @Override
    public String getFileInfo() {
        System.out.println("Windows系统文件处理器 - 使用" + fileFormat.getClass().getSimpleName());
        return  fileFormat.load();
    }
}
