package com.xmm.designpattern.factory.method;

import com.example.designpatternsdemo.factory.simple.Product;
import com.example.designpatternsdemo.factory.simple.ProductA;

public class FactoryA implements Factory {
    @Override
    public Product createProduct() {
        return new ProductA();
    }
}
