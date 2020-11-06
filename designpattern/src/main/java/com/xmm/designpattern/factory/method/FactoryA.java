package com.xmm.designpattern.factory.method;


import com.xmm.designpattern.factory.simple.Product;
import com.xmm.designpattern.factory.simple.ProductA;

public class FactoryA implements Factory {
    @Override
    public Product createProduct() {
        return new ProductA();
    }
}
