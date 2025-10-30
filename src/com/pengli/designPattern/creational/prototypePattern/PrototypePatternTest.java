package com.pengli.designPattern.creational.prototypePattern;

/**
 * 原型模式
 * 解决创建多个对象，每个对象在原先基础上做一点点更改，我理解为对单例的拷贝
 * 其中一个重要的实现方法是实现 {@link Cloneable} 接口
 *
 * @Author pengli
 * @Date 27/3/2023
 * @Version 1.0
 */
public class PrototypePatternTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Tree yinhua = new Tree();
        yinhua.setName("樱花");
        Area area = new Area();
        area.setProvince("江苏省");
        area.setCity("南京");
        yinhua.setArea(area);

        Tree meihua = yinhua.clone();
        meihua.setName("梅花");

        Tree haitanghua = yinhua.clone();
        haitanghua.setName("海棠花");

        System.out.println(yinhua);
        System.out.println(meihua);
        System.out.println(haitanghua);

        area.setCity("苏州");

        System.out.println(yinhua);
        System.out.println(meihua);
        System.out.println(haitanghua);
    }


}
