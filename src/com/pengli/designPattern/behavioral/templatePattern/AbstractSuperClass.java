package com.pengli.designPattern.behavioral.templatePattern;

/**
 * @Author pengli
 * @Date 29/3/2023
 * @Version 1.0
 */
public abstract class AbstractSuperClass {

    abstract void doUniqueThingA();

    abstract void doUniqueThingB();

    abstract void doUniqueThingC();

    public final void doComplexThings() {

        System.out.println("您的姓名是：");
        doUniqueThingA();
        System.out.println("火影忍者动漫中，第五代火影是谁:");
        System.out.println("A. 卡卡西");
        System.out.println("B. 鸣人");
        System.out.println("C. 纲手");
        doUniqueThingB();
        System.out.println("海贼王中为什么路飞的身体可以被拉长:");
        System.out.println("A. 吃了恶魔果实");
        System.out.println("B. 遗传他父亲的");
        System.out.println("C. 九九八十一天苦练而得");
        doUniqueThingC();
    }

}
