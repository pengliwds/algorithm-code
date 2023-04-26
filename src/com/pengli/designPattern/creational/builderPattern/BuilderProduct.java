package com.pengli.designPattern.creational.builderPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author pengli
 * @Date 23/4/2023
 * @Version 1.0
 */
public class BuilderProduct {

    private List<String> product = new ArrayList<>();

    public void add(String part){
        product.add(part);
    }

    public void showProduct(){
        System.out.println("构建的产品：");
        System.out.println(product);
    }

}
