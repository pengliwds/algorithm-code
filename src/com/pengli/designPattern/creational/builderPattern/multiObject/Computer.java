package com.pengli.designPattern.creational.builderPattern.multiObject;

public class Computer {

    private String cpu;
    private String ram;
    private String storage;
    private String gpu;
    private boolean hasBluetooth;
    private boolean hasWifi;

    private Computer(ComputerBuilder builder){
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
        this.hasBluetooth = builder.hasBluetooth;
        this.hasWifi = builder.hasWifi;
    }

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

    public static class ComputerBuilder {

        public String cpu;
        public String ram;
        public String storage;
        public String gpu;
        public boolean hasBluetooth;
        public boolean hasWifi;

        public ComputerBuilder() {
            this.cpu = "i7";
            this.ram = "16GB";
            this.storage = "512GB";
            this.gpu = "Nvidia GTX 1080";
            this.hasBluetooth = true;
            this.hasWifi = true;
        }

        public ComputerBuilder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public ComputerBuilder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

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

        public Computer build() {
            return new Computer(this);
        }

    }

}
