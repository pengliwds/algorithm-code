package com.pengli.designPattern.behavioral.commandPattern;

/**
 * 接受者风扇，执行风扇的命令
 */
public class Fan {

    private String location;
    private int speed = 0; // 0: 关闭, 1: 低速, 2: 中速, 3: 高速

    public Fan(String location) {
        this.location = location;
    }

    public void setHigh() {
        speed = 3;
        System.out.println(location + "的风扇设置为高速");
    }

    public void setMedium() {
        speed = 2;
        System.out.println(location + "的风扇设置为中速");
    }

    public void setLow() {
        speed = 1;
        System.out.println(location + "的风扇设置为低速");
    }

    public void turnOff() {
        speed = 0;
        System.out.println(location + "的风扇已关闭");
    }

    public int getSpeed() {
        return speed;
    }

}
