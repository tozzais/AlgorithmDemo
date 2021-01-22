package com.example.algorithmdemo.test2021;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 989. 数组形式的整数加法
 */
public class LeeCode0122UnitTest {
    @Test
    public void test() {
        int[] a = new int[]{2,1,5};
        addToArrayForm(a,806);
    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new ArrayList<>();
        int length = A.length;
        int i = length - 1;
        int isIn = 0;
        while (i >= 0 || K > 0) {
            //K的个位数
            int k2 = K % 10+isIn;
            //A的各位数
            int i1 = 0;
            if (i>=0){
                i1 = A[i];
            }
            int i2 = k2 + i1;
            list.add(i2%10);
            isIn = i2 / 10;
            K = K / 10;
            i--;
        }
        if (isIn == 1)
            list.add(0,1);
        Collections.reverse(list);
        return list;

    }

}