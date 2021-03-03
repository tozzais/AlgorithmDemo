package com.example.algorithmdemo.test2021;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 338. 比特位计数
 */
public class LeeCode0303UnitTest {
    @Test
    public void test() {
        countBits(16);

//        System.out.println(numMatrix.sumRegion(1,1,2,2));
//        System.out.println(numMatrix.sumRegion(1,2,2,4));

    }

    /*
    0  ->  0
    1  ->  1            1
    2  ->  10           1
    3  ->  11           2
    4  ->  100          1
    5  ->  101          2
    6  ->  110          2
    7  ->  111          3
    8  ->  1000         1
    9  ->  1001         2
    10  ->  1010        2
    11  ->  1011        3
    12  ->  1100        2
    13  ->  1101        3
    14  ->  1110        4
    15  ->  1111        4
    16  ->  10000       1
     */
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        int highBit = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;

    }

    private int getOne(int num) {
        int count = 0;
        while (num > 0) {
            int i = num % 2;
            if (i == 1) count++;
            num = num / 2;
        }
        return count;
    }

}