package com.pengli.designPattern.behavioral.commandPattern;

/**
 * 接收者 电视，执行电视相关的命令操作
 */
public class TV {

    private String location;
    private boolean isOn = false;
    private int volume = 10;
    private int channel = 1;

    public TV(String location) {
        this.location = location;
    }

    public void turnOn() {
        isOn = true;
        System.out.println(location + "的电视已打开");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(location + "的电视已关闭");
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println(location + "的电视音量设置为: " + volume);
    }

    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println(location + "的电视频道设置为: " + channel);
    }

    public boolean isOn() {
        return isOn;
    }

    public int getVolume() {
        return volume;
    }

    public int getChannel() {
        return channel;
    }

}

