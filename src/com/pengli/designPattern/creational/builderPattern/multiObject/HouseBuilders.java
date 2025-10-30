package com.pengli.designPattern.creational.builderPattern.multiObject;

public class HouseBuilders {



    public static Table.TableBuilder buildTable() {
        return new Table.TableBuilder();
    }

    public static Chair.ChairBuilder buildChair() {
        return new Chair.ChairBuilder();
    }

    public static Computer.ComputerBuilder buildComputer() {
        return new Computer.ComputerBuilder();
    }

}
