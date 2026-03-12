package com.pengli.designPattern.behavioral.commandPattern;

import java.util.List;

/**
 * 宏命令 - 组合多个命令
 */
public class MacroCommand implements Command {


    private List<Command> commands;

    public MacroCommand(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        // 逆序执行撤销
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }
}
