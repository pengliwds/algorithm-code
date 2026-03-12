package com.pengli.designPattern.behavioral.commandPattern;

public class TVOnCommand implements Command{

    private TV tv;
    private boolean previousState;
    private int previousVolume;
    private int previousChannel;

    public TVOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        previousState = tv.isOn();
        previousVolume = tv.getVolume();
        previousChannel = tv.getChannel();
        tv.turnOn();
        tv.setVolume(15);
        tv.setChannel(5);
    }

    @Override
    public void undo() {
        if (!previousState) {
            tv.turnOff();
        } else {
            tv.turnOn();
            tv.setVolume(previousVolume);
            tv.setChannel(previousChannel);
        }
    }


}
