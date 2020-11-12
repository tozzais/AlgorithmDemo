package com.xmm.designpattern.factory.method;


import com.xmm.designpattern.factory.simple.Product;
import com.xmm.designpattern.factory.simple.ProductB;

public class FactoryB implements Factory {
    @Override
    public Product createProduct() {
        return new ProductB();
    }
}
