package com.pengli.designPattern.creational.prototypePattern;

/**
 * @Author pengli
 * @Date 27/3/2023
 * @Version 1.0
 */
public class Tree implements Cloneable{

    private String name;

    private Area area;

    @Override
    protected Tree clone() throws CloneNotSupportedException {
        Tree tree = (Tree)super.clone();
        tree.setArea(this.area.clone());
        return tree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "name='" + name + '\'' +
                ", area=" + area +
                '}';
    }
}
