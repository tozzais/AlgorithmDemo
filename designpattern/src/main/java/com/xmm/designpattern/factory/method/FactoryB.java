package com.xmm.designpattern.factory.method;

import com.example.designpatternsdemo.factory.simple.Product;
import com.example.designpatternsdemo.factory.simple.ProductB;

public class FactoryB implements Factory {
    @Override
    public Product createProduct() {
        return new ProductB();
    }
}
