package com.pengli.designPattern.behavioral.commandPattern;

public class LightOffCommand implements Command {
    private Light light;
    private boolean previousState;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        previousState = light.isOn();
        light.turnOff();
    }

    @Override
    public void undo() {
        if (previousState) {
            light.turnOn();
        } else {
            light.turnOff();
        }
    }
}
