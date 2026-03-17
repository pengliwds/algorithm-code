package com.pengli.designPattern.behavioral.visitorPattern;

/**
 * 信息打印访问者（具体访问者）
 */
public class InfoVisitor implements Visitor {
    private int count;

    public InfoVisitor() {
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public void resetCount() {
        this.count = 0;
    }

    @Override
    public void visit(Dog dog) {
        count++;
        System.out.println("🐕 狗:");
        System.out.println("   名称: " + dog.getName());
        System.out.println("   年龄: " + dog.getAge() + " 岁");
        System.out.println("   品种: " + dog.getBreed());
        dog.bark();
        System.out.println();
    }

    @Override
    public void visit(Cat cat) {
        count++;
        System.out.println("🐱 猫:");
        System.out.println("   名称: " + cat.getName());
        System.out.println("   年龄: " + cat.getAge() + " 岁");
        System.out.println("   颜色: " + cat.getColor());
        cat.meow();
        System.out.println();
    }

    @Override
    public void visit(Bird bird) {
        count++;
        System.out.println("🐦 鸟:");
        System.out.println("   名称: " + bird.getName());
        System.out.println("   年龄: " + bird.getAge() + " 岁");
        System.out.println("   羽毛颜色: " + bird.getFeatherColor());
        System.out.println("   会飞: " + (bird.canFly() ? "是" : "否"));
        bird.chirp();
        bird.fly();
        System.out.println();
    }
}