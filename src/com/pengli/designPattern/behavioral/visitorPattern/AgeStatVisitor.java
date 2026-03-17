package com.pengli.designPattern.behavioral.visitorPattern;

/**
 * 年龄统计访问者（具体访问者）
 */
public class AgeStatVisitor implements Visitor {
    private int totalAge;
    private int dogCount;
    private int catCount;
    private int birdCount;

    public AgeStatVisitor() {
        this.totalAge = 0;
        this.dogCount = 0;
        this.catCount = 0;
        this.birdCount = 0;
    }

    @Override
    public void visit(Dog dog) {
        totalAge += dog.getAge();
        dogCount++;
    }

    @Override
    public void visit(Cat cat) {
        totalAge += cat.getAge();
        catCount++;
    }

    @Override
    public void visit(Bird bird) {
        totalAge += bird.getAge();
        birdCount++;
    }

    public void printStatistics() {
        int totalAnimals = dogCount + catCount + birdCount;
        System.out.println("========== 动物年龄统计 ==========");
        System.out.println("狗的数量: " + dogCount);
        System.out.println("猫的数量: " + catCount);
        System.out.println("鸟的数量: " + birdCount);
        System.out.println("总数量: " + totalAnimals);
        System.out.println("总年龄: " + totalAge + " 岁");
        if (totalAnimals > 0) {
            System.out.printf("平均年龄: %.2f 岁\n", (double) totalAge / totalAnimals);
        }
        System.out.println("==================================");
    }

    public void reset() {
        this.totalAge = 0;
        this.dogCount = 0;
        this.catCount = 0;
        this.birdCount = 0;
    }
}