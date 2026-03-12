package com.pengli.designPattern.behavioral.commandPattern;

public class FanHighCommand implements Command{

    private Fan fan;
    private int previousSpeed;

    public FanHighCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        previousSpeed = fan.getSpeed();
        fan.setHigh();
    }

    @Override
    public void undo() {
        switch (previousSpeed) {
            case 0: fan.turnOff(); break;
            case 1: fan.setLow(); break;
            case 2: fan.setMedium(); break;
            case 3: fan.setHigh(); break;
        }
    }
}
