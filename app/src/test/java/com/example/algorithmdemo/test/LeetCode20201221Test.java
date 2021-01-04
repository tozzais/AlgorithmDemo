package com.example.algorithmdemo.test;


import org.junit.Test;

/**
 去除重复字母
 */
public class LeetCode20201221Test {

    @Test
    public void test() {
        int[] a = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100};
        int[] b = new int[]{0, 1, 2, 2};
        System.out.println(minCostClimbingStairs(a));

    }


    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }


}