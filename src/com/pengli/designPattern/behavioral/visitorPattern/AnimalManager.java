package com.pengli.designPattern.behavioral.visitorPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 动物管理者（对象结构）
 * 维护一个动物集合，提供让访问者遍历访问的方法
 */
public class AnimalManager {
    private List<Animal> animals;

    public AnimalManager() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    /**
     * 让访问者访问所有动物
     */
    public void accept(Visitor visitor) {
        for (Animal animal : animals) {
            animal.accept(visitor);
        }
    }

    /**
     * 让访问者访问特定类型的动物
     */
    public void accept(Visitor visitor, Class<? extends Animal> animalType) {
        for (Animal animal : animals) {
            if (animalType.isInstance(animal)) {
                animal.accept(visitor);
            }
        }
    }

    public int getAnimalCount() {
        return animals.size();
    }
}