package com.xmm.designpattern.factory.method;

import com.example.designpatternsdemo.factory.simple.Product;

public class FactoryC implements Factory {
    @Override
    public Product createProduct() {
        return new ProductC();
    }
}
