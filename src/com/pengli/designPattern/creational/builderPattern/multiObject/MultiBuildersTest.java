package com.pengli.designPattern.creational.builderPattern.multiObject;

public class MultiBuildersTest {


    public static void main(String[] args) {
        Table table = HouseBuilders.buildTable().setHeigth("100cm").setWidth("100cm").setLegs("4").setColor("red").setMaterial("wood").build();
        System.out.println(table);

        Chair chair = HouseBuilders.buildChair().setType("wood").setLegs(4).setHasBackrest(true).setColor("red").setMaterial("wood").build();
        System.out.println(chair);

        Computer computer = HouseBuilders.buildComputer().setCpu("i7").setRam("16GB").setStorage("512GB").setGpu("Nvidia GTX 1080").setBluetooth(true).setWifi(true).build();
        System.out.println(computer);
    }
}
