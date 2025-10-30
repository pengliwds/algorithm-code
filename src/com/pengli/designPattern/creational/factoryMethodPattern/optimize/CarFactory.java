package com.pengli.designPattern.creational.factoryMethodPattern.optimize;

public class CarFactory {

    public static final String CAR_CLASS_NAME = "com.pengli.designPattern.creational.factoryMethodPattern.optimize";

    public static Car getCar(String carName) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        ClassLoader classLoader = CarFactory.class.getClassLoader();
        Class<?> carClass = classLoader.loadClass(CAR_CLASS_NAME + "." + carName);
        return (Car) carClass.newInstance();
    }

}
