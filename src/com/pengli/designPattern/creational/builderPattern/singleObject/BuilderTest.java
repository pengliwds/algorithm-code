package com.pengli.designPattern.creational.builderPattern.singleObject;


// 客户端使用
public class BuilderTest {
    public static void main(String[] args) {
        // 构建基础电脑
        Computer basicComputer = new Computer.ComputerBuilder("i5", "8GB", "256GB SSD")
                .build();
        System.out.println("基础电脑: " + basicComputer);

        // 构建高端电脑（使用链式调用）
        Computer gamingComputer = new Computer.ComputerBuilder("i9", "32GB", "1TB NVMe SSD")
                .setGpu("RTX 4080")
                .setBluetooth(true)
                .setWifi(true)
                .build();
        System.out.println("游戏电脑: " + gamingComputer);

        // 构建办公电脑
        Computer officeComputer = new Computer.ComputerBuilder("i7", "16GB", "512GB SSD")
                .setWifi(true)
                .build();
        System.out.println("办公电脑: " + officeComputer);
    }
}