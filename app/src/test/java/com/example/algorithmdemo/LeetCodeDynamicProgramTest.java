package com.example.algorithmdemo;

import org.junit.Test;

/**
 * 测试 动态规划
 *
 */
public class LeetCodeDynamicProgramTest {

    @Test
    public void test() {
        int[]  a = new int[]{1,2,3,1};
        System.out.println(massage(a));

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

    /**
     * 面试题 17.16. 按摩师
     * @param nums
     * @return
     */
    public int massage(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int dp0 = 0, dp1 = nums[0];
        for (int i = 1; i < n; ++i){
            int tdp0 = Math.max(dp0, dp1); // 计算 dp[i][0]
            int tdp1 = dp0 + nums[i]; // 计算 dp[i][1]

            dp0 = tdp0; // 用 dp[i][0] 更新 dp_0
            dp1 = tdp1; // 用 dp[i][1] 更新 dp_1
        }
        return Math.max(dp0, dp1);



    }



}