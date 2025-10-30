package com.pengli.designPattern.creational.builderPattern.singleObject;

// 产品类 - 要构建的复杂对象
public class Computer {
    private String cpu;
    private String ram;
    private String storage;
    private String gpu;
    private boolean hasBluetooth;
    private boolean hasWifi;

    // 私有构造函数，只能通过Builder创建
    private Computer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
        this.hasBluetooth = builder.hasBluetooth;
        this.hasWifi = builder.hasWifi;
    }

    // Getters
    public String getCpu() { return cpu; }
    public String getRam() { return ram; }
    public String getStorage() { return storage; }
    public String getGpu() { return gpu; }
    public boolean hasBluetooth() { return hasBluetooth; }
    public boolean hasWifi() { return hasWifi; }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                ", gpu='" + gpu + '\'' +
                ", hasBluetooth=" + hasBluetooth +
                ", hasWifi=" + hasWifi +
                '}';
    }

    // 建造者类 - 静态内部类
    public static class ComputerBuilder {
        // 必需参数
        private String cpu;
        private String ram;
        private String storage;

        // 可选参数（有默认值）
        private String gpu = "Integrated";
        private boolean hasBluetooth = false;
        private boolean hasWifi = false;

        // 必需参数的构造函数
        public ComputerBuilder(String cpu, String ram, String storage) {
            this.cpu = cpu;
            this.ram = ram;
            this.storage = storage;
        }

        // 设置可选参数的方法（返回Builder本身，支持链式调用）
        public ComputerBuilder setGpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public ComputerBuilder setBluetooth(boolean hasBluetooth) {
            this.hasBluetooth = hasBluetooth;
            return this;
        }

        public ComputerBuilder setWifi(boolean hasWifi) {
            this.hasWifi = hasWifi;
            return this;
        }

        // 构建方法
        public Computer build() {
            return new Computer(this);
        }
    }
}

