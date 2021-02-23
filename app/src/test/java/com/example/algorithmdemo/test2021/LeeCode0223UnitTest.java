package com.example.algorithmdemo.test2021;

import org.junit.Test;


/**
 * 665. 非递减数列
 */
public class LeeCode0223UnitTest {
    @Test
    public void test() {
        int[] a = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] b = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        System.out.println(maxSatisfied(a, b, 3));
    }
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int length = customers.length;
        int max = 0;//原本满意的
        for (int i = 0; i < length; i++) {
            int i1 = grumpy[i];
            if (i1 == 0) {
                max += customers[i];
            }
        }
        int maxReduce = 0;
        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1) {
                maxReduce += customers[i];
            }
        }
        int advance = maxReduce;
        for (int i = 1; i < length - X + 1; i++) {
            int m = advance;
            int i3 = i - 1;
            int i1 = grumpy[i3];
            int i2 = grumpy[i3 + X];
            if (i1 == 1) {
                m -= customers[i3];
            }
            if (i2 == 1) {
                m += customers[i3 + X];
            }
            advance = m;
            maxReduce = Math.max(m, maxReduce);
        }
        return max + maxReduce;
    }
}