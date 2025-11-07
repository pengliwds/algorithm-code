package com.pengli.designPattern.behavioral.mementoParttern;

/**
 * 备忘录模式测试类
 * 备忘录模式是一种行为型设计模式，它在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。
 * 这样就可以将该对象恢复到原先保存的状态。备忘录模式可以提供一个可回滚的操作，当用户需要时能够恢复到之前的状态。
 *
 */
public class MementoTest {


    public static void main(String[] args) {

        HeroRole hero = new HeroRole();
        SaveManager saveManager = new SaveManager();
        hero.currentState();
        // 保存状态
        saveManager.save("新手村", hero.saveState());
        // 升级
        hero.levelUp();
        // 保存状态
        saveManager.save("新手村", hero.saveState());
        // 进入副本
        hero.addExp(100);
        // 保存状态
        saveManager.save("幻夜城", hero.saveState());
        hero.currentState();

        // 回到新手村
        GameMemento memento = saveManager.load("新手村", 0);
        hero.restoreState(memento);
        hero.currentState();

        // 回到幻夜城
        memento = saveManager.load("幻夜城", 0);
        hero.restoreState(memento);
        hero.currentState();





    }






}




