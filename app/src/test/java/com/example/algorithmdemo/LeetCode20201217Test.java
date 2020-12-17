package com.example.algorithmdemo;


import org.junit.Test;

import java.util.HashMap;

/**
 方法一：哈希表
 思路及解法
 */
public class LeetCode20201217Test {

    @Test
    public void test() {
        char c = "123".charAt(1);



    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }





}