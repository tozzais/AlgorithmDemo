package com.xmm.designpattern.factory.simple;

public class ProductFactory  {

    //简单工厂模式  但是违背了开放-封闭 原则
    public static Product create(String name){
        if (name.equalsIgnoreCase("productA")){
            return new ProductA();
        }else if (name.equalsIgnoreCase("productB")){
            return new ProductB();
        }
        return null;

    }
}
