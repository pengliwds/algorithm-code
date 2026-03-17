package com.pengli.designPattern.behavioral.visitorPattern;

/**
 * 访问者模式测试类
 */
public class VisitorPatternTest {
    public static void main(String[] args) {
        System.out.println("========== 访问者模式测试 ==========\n");

        // 创建动物管理者
        AnimalManager manager = new AnimalManager();

        // 添加各种动物
        manager.addAnimal(new Dog("旺财", 3, "金毛"));
        manager.addAnimal(new Cat("咪咪", 2, "橘色"));
        manager.addAnimal(new Bird("小黄", 1, "黄色", true));
        manager.addAnimal(new Dog("来福", 5, "哈士奇"));
        manager.addAnimal(new Cat("花花", 4, "黑白"));
        manager.addAnimal(new Bird("小蓝", 2, "蓝色", true));
        manager.addAnimal(new Bird("小企鹅", 3, "黑白色", false));

        System.out.println("动物总数: " + manager.getAnimalCount());
        System.out.println();

        // 使用信息访问者打印所有动物信息
        System.out.println("========== 使用 InfoVisitor 打印动物信息 ==========");
        InfoVisitor infoVisitor = new InfoVisitor();
        manager.accept(infoVisitor);
        System.out.println("已访问动物数量: " + infoVisitor.getCount());
        System.out.println();

        // 使用年龄统计访问者统计所有动物的年龄
        AgeStatVisitor ageStatVisitor = new AgeStatVisitor();
        manager.accept(ageStatVisitor);
        ageStatVisitor.printStatistics();
        System.out.println();

        // 只访问狗的信息
        System.out.println("========== 只访问狗的信息 ==========");
        InfoVisitor dogInfoVisitor = new InfoVisitor();
        manager.accept(dogInfoVisitor, Dog.class);
        System.out.println("狗的数量: " + dogInfoVisitor.getCount());
        System.out.println();

        // 只统计猫的年龄
        System.out.println("========== 只统计猫的年龄 ==========");
        AgeStatVisitor catAgeStat = new AgeStatVisitor();
        manager.accept(catAgeStat, Cat.class);
        catAgeStat.printStatistics();
        System.out.println();

        // 演示访问者模式的优点：添加新功能不需要修改元素类
        System.out.println("========== 访问者模式优点演示 ==========");
        System.out.println("如果我们需要添加一个功能来检查哪些动物是'幼年'的(年龄<=2岁)，");
        System.out.println("只需要创建一个新的访问者，而不需要修改 Animal、Dog、Cat、Bird 类！");
        System.out.println();

        YoungAnimalCheckVisitor youngCheckVisitor = new YoungAnimalCheckVisitor();
        manager.accept(youngCheckVisitor);
        System.out.println();

        System.out.println("========== 访问者模式测试完成 ==========");
    }
}

/**
 * 检查幼年动物的访问者（新增功能）
 * 展示访问者模式的扩展性
 */
class YoungAnimalCheckVisitor implements Visitor {
    private int youngCount = 0;
    private int adultCount = 0;

    @Override
    public void visit(Dog dog) {
        if (dog.getAge() <= 2) {
            System.out.println("✓ " + dog.getName() + " 是一只幼犬（" + dog.getAge() + "岁）");
            youngCount++;
        } else {
            adultCount++;
        }
    }

    @Override
    public void visit(Cat cat) {
        if (cat.getAge() <= 2) {
            System.out.println("✓ " + cat.getName() + " 是一只幼猫（" + cat.getAge() + "岁）");
            youngCount++;
        } else {
            adultCount++;
        }
    }

    @Override
    public void visit(Bird bird) {
        if (bird.getAge() <= 2) {
            System.out.println("✓ " + bird.getName() + " 是一只幼鸟（" + bird.getAge() + "岁）");
            youngCount++;
        } else {
            adultCount++;
        }
    }

    public void printSummary() {
        System.out.println("幼年动物: " + youngCount + " 只");
        System.out.println("成年动物: " + adultCount + " 只");
    }
}