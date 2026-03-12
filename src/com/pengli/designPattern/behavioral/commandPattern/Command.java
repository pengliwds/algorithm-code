package com.pengli.designPattern.behavioral.commandPattern;

public interface Command {

    /**
     * 执行方法，用于执行特定操作
     * 该方法没有参数和返回值
     */
    void execute(); // 定义一个执行方法，无参数无返回值

    /**
     * 撤销操作方法
     * 该方法用于执行撤销操作，可能是撤销上一步的操作或更改
     * 具体行为取决于实现类的上下文和业务逻辑
     */
    void undo();
}
