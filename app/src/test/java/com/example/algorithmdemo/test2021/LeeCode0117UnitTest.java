package com.example.algorithmdemo.test2021;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 1018. 可被 5 整除的二进制前缀
 */
public class LeeCode0117UnitTest {
    @Test
    public void test() {
        int[][] a = new int[][]{{0,1},{1,3},{-4,-7},{5,11}};
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i][0]);
        }

    }



    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = ((sum << 1)+A[i])%5;
            list.add(sum==0);
        }
        return list;

    }



}