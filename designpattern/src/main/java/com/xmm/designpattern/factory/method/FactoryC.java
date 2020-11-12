package com.xmm.designpattern.factory.method;


import com.xmm.designpattern.factory.simple.Product;

public class FactoryC implements Factory {
    @Override
    public Product createProduct() {
        return new ProductC();
    }
}
