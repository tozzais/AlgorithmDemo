package com.example.algorithmdemo;


import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * 976. 三角形的最大周长
 */
public class LeetCode20201129Test {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void test() {
        int[] D = new int[]{3,3,6,2};
        System.out.println(largestPerimeter(D));

    }

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length-1; i >= 2; i--) {
            //最长的边
            int a = A[i];
            int b = A[i-1];
            int c = A[i-2];
            if (b+c > a){
                return a+b+c;
            }
        }
        return 0;
    }


}