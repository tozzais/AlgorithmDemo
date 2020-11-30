package com.example.algorithmdemo;


import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 493. 翻转对 归并排序
 */
public class LeetCode20201128Test {

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
        int[] D = new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        System.out.println(reversePairs(D));

    }

    public int reversePairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                BigDecimal num = new BigDecimal(nums[i]);
                BigDecimal num1 = new BigDecimal(nums[j]).multiply(new BigDecimal(2));
                if (num.compareTo(num1) == 1){
                    count++;
                }
            }
        }
        return count;

    }


}