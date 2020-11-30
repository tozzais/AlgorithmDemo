package com.example.algorithmdemo;


import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 164. 最大间距
 */
public class LeetCode20201127Test {

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
        int[] A = new int[]{1,2};
        int[] B = new int[]{-2,-1};
        int[] C = new int[]{-1,2};
        int[] D = new int[]{0,2};
        System.out.println(fourSumCount(A,B,C,D));

    }


    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int a1 = A[i];
            for (int j = 0; j < B.length; j++) {
                int b1 = B[j];
                map.put(a1+b1,map.getOrDefault(a1+b1,0)+1);
            }
        }
        for (int k = 0; k < C.length; k++) {
            int c1 = C[k];
            for (int l = 0; l < D.length; l++) {
                int d1 = D[l];
                if (map.containsKey(-c1-d1)){
                    count += map.get(-c1-d1);
                }
            }
        }
        return count;
    }


}