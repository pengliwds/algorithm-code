package com.pengli.designPattern.behavioral.commandPattern;

public class LightOnCommand implements Command {
    private Light light;
    private boolean previousState;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        previousState = light.isOn();
        light.turnOn();
    }

    @Override
    public void undo() {
        if (!previousState) {
            light.turnOff();
        } else {
            light.turnOn();
        }
    }
}
