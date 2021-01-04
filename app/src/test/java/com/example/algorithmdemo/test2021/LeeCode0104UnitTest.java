package com.example.algorithmdemo.test2021;

import org.junit.Test;

/**
 509. 斐波那契数
 */
public class LeeCode0104UnitTest {
    @Test
    public void test() {
        System.out.println(fib(3));
        System.out.println(fib(4));

    }

    public int fib(int n) {
        if (n == 0 || n == 1){
            return n;
        }else {
            return fib(n-1)+fib(n-2);
        }
    }




}