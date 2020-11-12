package com.example.algorithmdemo;

import org.junit.Test;

/**
 * 测试 动态规划
 *
 */
public class LeetCodeDynamicProgramTest {

    @Test
    public void test() {
        int[]  a = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(a));

    }

    /**
     * 53. 最大子序和
     * @param a
     * @return
     */
    public int maxSubArray(int[] a) {
        int max = a[0];
        int sum = a[0];
        for (int i = 1; i < a.length; i++) {
            sum = Math.max(sum+a[i],a[i]);
            if (sum>max) max = sum;
        }
        return max;
    }


}