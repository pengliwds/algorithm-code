package com.pengli.designPattern.behavioral.commandPattern;

import java.util.Stack;

/**
 * 调用者，控制面板 或者智能家居APP入口
 *
 */
public class RemoteControl {

    private Command[] onCommands;
    private Command[] offCommands;
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;

    /**
     * 初始化 slots 个按钮代表对应多少种命令模式
     * @param slots
     */
    public RemoteControl(int slots) {
        onCommands = new Command[slots];
        offCommands = new Command[slots];
        undoStack = new Stack<>();
        redoStack = new Stack<>();

        // 初始化所有按钮为空命令
        Command noCommand = new NoCommand();
        for (int i = 0; i < slots; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    /**
     * 设置按钮对应的命令
     * @param slot
     * @param onCommand
     * @param offCommand
     */
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        if (slot >= 0 && slot < onCommands.length) {
            onCommands[slot] = onCommand;
            offCommands[slot] = offCommand;
        }
    }

    public void onButtonWasPushed(int slot) {
        if (slot >= 0 && slot < onCommands.length) {
            onCommands[slot].execute();
            undoStack.push(onCommands[slot]);
            redoStack.clear(); // 执行新命令时清空重做栈
        }
    }

    public void offButtonWasPushed(int slot) {
        if (slot >= 0 && slot < offCommands.length) {
            offCommands[slot].execute();
            undoStack.push(offCommands[slot]);
            redoStack.clear(); // 执行新命令时清空重做栈
        }
    }

    public void undoButtonWasPushed() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        } else {
            System.out.println("没有可以撤销的操作");
        }
    }

    public void redoButtonWasPushed() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        } else {
            System.out.println("没有可以重做的操作");
        }
    }

    public void display() {
        System.out.println("\n======= 遥控器配置 =======");
        for (int i = 0; i < onCommands.length; i++) {
            System.out.println("[插槽 " + i + "] " +
                    onCommands[i].getClass().getSimpleName() + "    " +
                    offCommands[i].getClass().getSimpleName());
        }
        System.out.println("=========================\n");
    }

}
