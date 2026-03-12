package com.pengli.designPattern.behavioral.commandPattern;

/**
 * 接受者灯，执行灯的命令
 */
public class Light {

    private String location;
    private boolean isOn = false;

    public Light(String location) {
        this.location = location;
    }

    public void turnOn() {
        isOn = true;
        System.out.println(location + "的灯已打开");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(location + "的灯已关闭");
    }

    public boolean isOn() {
        return isOn;
    }
}
