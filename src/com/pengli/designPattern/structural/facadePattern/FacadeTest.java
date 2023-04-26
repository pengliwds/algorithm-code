package com.pengli.designPattern.structural.facadePattern;

/**
 * 外观模式，提供一个统一的对外接口
 * 可以用于把很多很乱的子模块功能集成起来，对外暴露一个集成的接口，做多个子模块的事。用户不需要处理和了解各个子模块的处理细节，相当于包装一下
 *
 * @Author pengli
 * @Date 23/4/2023
 * @Version 1.0
 */
public class FacadeTest {

    public static void main(String[] args) {
        Facade facade = new Facade();

        facade.integration();

    }
}
