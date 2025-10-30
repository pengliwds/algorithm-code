package com.pengli.designPattern.creational.factoryMethodPattern.optimize;

public class FactoryTest {


    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        String needCar = "TangCar";
        Car myCar = CarFactory.getCar(needCar);
        System.out.println("My car is " + myCar.speed());

    }

}
